import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { userEditPassword, userinfo } from 'src/app/model/userinfo';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  public loginUserfromBackend(user: userinfo): Observable<any> {
    return this.http.post('http://localhost:8081/login', user);
  }
  public registerUserfromBackend(user: userinfo): Observable<any> {
    return this.http.post('http://localhost:8081/register', user);
  }
  public changePassword(user: userEditPassword): Observable<any> {
    return this.http.get(
      'http://localhost:8081/edit-password?usr=' +
        user.userName +
        '&oldP=' +
        user.oldPassword +
        '&newP=' +
        user.newPassword
    );
  }
  loginUser(token: string) {
    localStorage.setItem('token', token);
    return true;
  }
  isLoggedIn() {
    let token = localStorage.getItem('token');
    if (token == undefined || token == null || token == '') {
      return false;
    } else {
      return true;
    }
  }
  logout() {
    localStorage.removeItem('token');
    return true;
  }
}
