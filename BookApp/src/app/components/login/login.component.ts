import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';
import { userinfo } from 'src/app/model/userinfo';
import { NgForm } from '@angular/forms';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  user = new userinfo();
  message = '';
  constructor(private rls: LoginService, private router: Router) {}
  ngOnInit(): void {}

  loginUser() {
    this.rls.loginUserfromBackend(this.user).subscribe(
      (response) => {
        console.log(response);
        this.rls.loginUser(response.token);
        this.router.navigate(['/dashboard']);
      },
      (error) => {
        console.log(error);
        this.message = 'Invalid Credentials Try Again';
        alert('Sorry, login unsuccesful');
      }
    );
  }
}
