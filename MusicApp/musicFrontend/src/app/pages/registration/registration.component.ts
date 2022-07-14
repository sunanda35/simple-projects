import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthServiceService } from 'src/services/auth-service.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss'],
})
export class RegistrationComponent implements OnInit {
  registerFormGroup!: FormGroup;
  submitted = false;
  constructor(
    private autService: AuthServiceService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.isLoggedIn();
    this.registerFormGroup = new FormGroup({
      userName: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required]),
    });
  }
  initForm() {}
  get Username(): FormControl {
    return this.registerFormGroup.get('userName') as FormControl;
  }
  get Email(): FormControl {
    return this.registerFormGroup.get('email') as FormControl;
  }
  get Password(): FormControl {
    return this.registerFormGroup.get('password') as FormControl;
  }
  isLoggedIn() {
    const isLoggedIn = this.autService.isLoggedIn();
    if (isLoggedIn) {
      this.router.navigate(['/']);
    }
  }
  registerUser() {
    this.submitted = true;
    if (this.registerFormGroup.valid) {
      this.autService.register(this.registerFormGroup.value).subscribe(
        (res) => {
          this.router.navigate(['/login']);
          this.toastr.success('You have Registered Successfully!');
        },
        (err) => {
          console.log(err);
          this.toastr.warning(err.error.text);
          this.autService.logout();
        }
      );
    } else {
      console.log('Form is invalid');
    }
  }
}
