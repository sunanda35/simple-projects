import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';
import { Cookie } from 'ng2-cookies/ng2-cookies';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private router: Router, private http: HttpClient) { }

  registerUser(userData){
    let params = {
      'firstName':userData.firstname,
      'lastName':userData.lastname,
      'email':userData.email,
      'phone':userData.phone,
      'password':userData.password};
    
    let headers = 
      new HttpHeaders({'Content-type': 'application/json',
      'Accept': '*/*'});
    let options = ({ headers: headers });
    
    this.http.post(environment.apiUrl+'/user-api/user/add', 
      params, options)
      .subscribe(
        data => {this.router.navigate(['/login'],{state:{message:'Registration Successful.',status:'success'}});},//this.saveToken(data),
        err => alert(err)); 
  }

  updateProfile(userData){
    let params = {
      'id':Cookie.get("id"),
      'firstName':userData.firstname,
      'lastName':userData.lastname,
      'phone':userData.phone};
    
    let headers = 
      new HttpHeaders({'Content-type': 'application/json',
      'Accept': '*/*','Authorization': 'Bearer '+Cookie.get('access_token')});
    let options = ({ headers: headers });
    
    this.http.post(environment.apiUrl+'/user-api/user/update', 
      params, options)
      .subscribe(
        data => {
          alert('Profile updated successfully.');

          const userDetails = this.getUserDetails();
          userDetails.firstname=userData.firstname;
          userDetails.lastname=userData.lastname;
          userDetails.phone=userData.phone
         
          Cookie.set("user",JSON.stringify(userDetails));
          this.router.navigate(['/'],{state:{message:'Profile updated successfully.'}});
        },//this.saveToken(data),
        err => alert(err)); 
  }

  changePassword(password){
    let params = {
      'id':Cookie.get("id"),
      'password':password
    };
    
    let headers = 
      new HttpHeaders({'Content-type': 'application/json',
      'Accept': '*/*','Authorization': 'Bearer '+Cookie.get('access_token')});
    let options = ({ headers: headers });
    
    this.http.post(environment.apiUrl+'/user-api/user/password', 
      params, options)
      .subscribe(
        data => {
          alert('Password updated successfully.');
          this.router.navigate(['/'],{state:{message:'Password updated successfully.'}});
        },//this.saveToken(data),
        err => alert(err)); 
  }

  getUserDetails(){
    return JSON.parse(Cookie.get("user"));
  }
}
