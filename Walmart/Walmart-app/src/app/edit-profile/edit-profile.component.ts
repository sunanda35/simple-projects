import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/services/auth.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css'],
})
export class EditProfileComponent implements OnInit {
  userName: String = '';
  editProfileFormGroup!: FormGroup;
  submitted = false;
  passwordNotSame = false;

  constructor(
    private authService: AuthService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.userName = localStorage.getItem('userName') || '';
    this.editProfileFormGroup = new FormGroup({
      password: new FormControl('', [
        Validators.required,
        Validators.minLength(6),
      ]),
      confirmPassword: new FormControl('', [Validators.required]),
    });
  }
  get Password(): FormControl {
    return this.editProfileFormGroup.get('password') as FormControl;
  }
  get CPassword(): FormControl {
    return this.editProfileFormGroup.get('confirmPassword') as FormControl;
  }

  editUser() {
    this.submitted = true;
    if (this.editProfileFormGroup.valid) {
      if (
        this.editProfileFormGroup.value.password ==
        this.editProfileFormGroup.value.confirmPassword
      ) {
        this.authService
          .updateUser(this.editProfileFormGroup.value.password)
          .subscribe(
            (data) => {
              console.log(data);
              this.authService.loginUser(data);
              this.toastr.success('Password Changed Successfully');
              this.router.navigate(['/']);
            },
            (err) => {
              this.toastr.error(err?.error || 'Something went wrong');
            }
          );
      } else {
        this.passwordNotSame = true;
      }
    }
  }
}
