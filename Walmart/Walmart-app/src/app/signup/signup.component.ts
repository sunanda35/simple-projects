import { Component, OnInit } from '@angular/core';
import {
  ValidationErrors,
  AbstractControl,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/services/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  signUpFormGroup!: FormGroup;
  submitted = false;
  customValidators: any;
  constructor(
    private authService: AuthService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.signUpFormGroup = new FormGroup({
      fname: new FormControl('', [
        Validators.required,
        Validators.pattern('[a-zA-Z]*'),
      ]),
      lname: new FormControl('', [
        Validators.required,
        Validators.pattern('[a-zA-Z]*'),
      ]),

      userName: new FormControl('', [
        Validators.required,
        Validators.minLength(4),
      ]),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [
        Validators.required,
        Validators.minLength(6),
      ]),
    });
  }

  get Firstname(): FormControl {
    return this.signUpFormGroup.get('fname') as FormControl;
  }
  get Lastname(): FormControl {
    return this.signUpFormGroup.get('lname') as FormControl;
  }
  get Username(): FormControl {
    return this.signUpFormGroup.get('userName') as FormControl;
  }
  get Email(): FormControl {
    return this.signUpFormGroup.get('email') as FormControl;
  }
  get Password(): FormControl {
    return this.signUpFormGroup.get('password') as FormControl;
  }

  signUpUser() {
    this.submitted = true;
    if (this.signUpFormGroup.valid) {
      this.authService.register(this.signUpFormGroup.value).subscribe(
        (data) => {
          this.router.navigate(['/login']);
        },
        (err) => {
          this.toastr.error(err?.error || 'Something went wrong');
        }
      );
    }
  }
}
