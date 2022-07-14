import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  logIn: boolean = false;
  constructor(private auth: LoginService, private router: Router) {}

  ngOnInit(): void {
    this.loginCheck();
  }
  loginCheck() {
    const isLog = this.auth.isLoggedIn();
    this.logIn = isLog;
  }
  looutCick() {
    this.auth.logout();
    this.logIn = false;
    this.router.navigate(['/login']);
  }
}
