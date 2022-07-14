import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, ActivatedRouteSnapshot, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']

})
export class LoginComponent implements OnInit {

  constructor(private userService:UserService, private snack:MatSnackBar, private router:Router, private route: ActivatedRoute) {
    const {username, token} = localStorage
    console.log(username, token)
    if(username && token) {

      this.userService.getLoggedinUser(token, username).subscribe({
        next: () => {
          this.userService.token = token;
          // this.router.navigateByUrl("/")
          const params = this.route.snapshot.queryParams;
          const redirectURL = params["redirectURL"]
          console.log(params)
          if(redirectURL){
            this.router.navigateByUrl(redirectURL)
          } else {
            this.router.navigateByUrl("/")
          }
        },
        error: () => {

        }
      })
    }
   }

  public user={
    username: '',
    password: '',
  
  };

  ngOnInit(): void {}

  formSubmit(){
    console.log(this.user);
    if(this.user.username=='' || this.user.username == null){
      //alert('User is required');
      this.snack.open("Username is required",'',{
        duration:3000,
        // verticalPosition:'top',
        // horizontalPosition:'right',
      })
      return;
    }
    if(this.user.password=='' || this.user.password == null){
      //alert('User is required');
      this.snack.open("Password is required",'',{
        duration:3000,
        // verticalPosition:'top',
        // horizontalPosition:'right',
      })
      return;
    }


    /////////addUser: userservice

    this.userService.signin(this.user).subscribe(
      (data)=>{
        //success
        console.log(data);
        //alert('success');
        this.userService.getLoggedinUser(data.token, this.user.username).subscribe({next: (data)=>{
          this.router.navigateByUrl("/")
        }})
        //Swal.fire('Successfully done!!', 'User is signed in','success')
      },
      (error)=>{
        console.log(error);
        // alert('something went wrong');
        this.snack.open('Something went wrong','',{
          duration:3000,
        })
      }
      
    )
  }

}

