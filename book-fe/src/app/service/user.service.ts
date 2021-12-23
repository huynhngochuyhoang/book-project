import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {UserLogin} from "../model/user-login";
import {TokenResponse} from "../model/token-response";
import {BehaviorSubject, Observable} from "rxjs";
import {User} from "../model/user";
import {UserRegister} from "../model/user-register";


@Injectable({
  providedIn: 'root'
})
export class UserService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  userBehaviorSubject: BehaviorSubject<User>
  currentUser: Observable<User>

  constructor(private http: HttpClient) {
    this.userBehaviorSubject = new BehaviorSubject<User>(null as any)
    this.currentUser = this.userBehaviorSubject.asObservable()
  }

  login(user: UserLogin): Observable<TokenResponse> {
    return this.http.post<TokenResponse>(`${environment.apiUrl}/user/login`, user)
  }

  userInfo() {
    this.httpOptions.headers = this.httpOptions.headers.append('Authorization',
      'Bearer ' + localStorage.getItem('accessToken'))
    return this.http.get<User>(`${environment.apiUrl}/user/info`, this.httpOptions)
  }

  isAuth() {
    return !!localStorage.getItem('accessToken')
  }

  register(userRegister: UserRegister) {
    return this.http.post(`${environment.apiUrl}/user/register`, userRegister, this.httpOptions)
  }
}
