import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from './services/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'newsFrontend';
///for persisting user when logged in
  constructor(private userService: UserService, private router: Router){
    const {username, token} = localStorage
    console.log(username, token)
    if(username && token) {
      this.userService.getLoggedinUser(token, username).subscribe({
        next: () => {
          this.userService.token = token;
          // this.router.initialNavigation()
        },
        error: () => {

        }
      })
    }
  }
}
