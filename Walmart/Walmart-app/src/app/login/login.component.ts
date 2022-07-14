import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  loginFormGroup!: FormGroup;
  submitted = false;
  constructor(
    private authService: AuthService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.authService.isLoggedIn() ? this.router.navigate(['/']) : null;
    this.loginFormGroup = new FormGroup({
      userName: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    });
  }
  get Username(): FormControl {
    return this.loginFormGroup.get('userName') as FormControl;
  }
  get Password(): FormControl {
    return this.loginFormGroup.get('password') as FormControl;
  }

  loginUser() {
    this.submitted = true;
    if (this.loginFormGroup.valid) {
      this.authService.login(this.loginFormGroup.value).subscribe(
        (data) => {
          this.authService.loginUser(data);
          this.toastr.success('Logged In Successfully');
          window.location.reload();
        },
        (err) => {
          this.toastr.error(err?.error || 'Something went wrong');

        }
      );
    }
  }
}
