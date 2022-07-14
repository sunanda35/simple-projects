import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service'
import{ BreakpointObserver } from '@angular/cdk/layout'

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
 
  user: any;


  // @ViewChild(MatSidenav) 
  // sidenav!: MatSidenav;

  constructor(private userService:UserService, private router: Router, private observer: BreakpointObserver) {

    this.userService.user.subscribe({next: data=> {
      this.user = data
    }})
   }

  ngOnInit(): void {
  }

  logout(){
    const loggedout = this.userService.logout();
    if(loggedout) {
      this.router.navigateByUrl("/login")
    }
  }
  // ngAfterViewInit(){
  //   this.observer.observe(['(max-width: 800px)']).subscribe((res)=>{
  //     if(res.matches){
  //       this.sidenav.mode='over';
  //       this.sidenav.close();
  //     }else{
  //       this.sidenav.mode ='side';
  //       this.sidenav.open();
  //     }
  //   });
  //  }


}
