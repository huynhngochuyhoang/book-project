import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {UserLogin} from "../model/user-login";
import {TokenResponse} from "../model/token-response";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class UserService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      Authorization: `Bearer ${localStorage.getItem('accessToken')!}`
    })
  };

  constructor(private http: HttpClient) {
  }

  login(user: UserLogin): Observable<TokenResponse> {
    return this.http.post<TokenResponse>(`${environment.apiUrl}/user/login`, user)
  }

  userInfo() {
    return this.http.get(`${environment.apiUrl}/user/info`, this.httpOptions)
  }
}
