import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthServiceService } from 'src/services/auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  formGroup!: FormGroup;

  constructor(
    private autService: AuthServiceService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.isLoggedIn();
    this.formGroup = new FormGroup({
      userName: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    });
  }
  initForm() {}
  get Username(): FormControl {
    return this.formGroup.get('userName') as FormControl;
  }
  get Password(): FormControl {
    return this.formGroup.get('password') as FormControl;
  }
  isLoggedIn() {
    const isLoggedIn = this.autService.isLoggedIn();
    if (isLoggedIn) {
      this.router.navigate(['/']);
    }
  }
  loginUser() {
    if (this.formGroup.valid) {
      this.autService.login(this.formGroup.value).subscribe(
        (res) => {
          this.autService.loginUser(res);
          this.router.navigate(['/']);
          this.toastr.success('Logged In Successfully!');
        },
        (err) => {
          this.toastr.warning(err.error);
          console.log(err.error);
          this.autService.logout();
        }
      );
    }
  }
}
