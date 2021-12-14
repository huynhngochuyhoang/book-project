import { Component } from '@angular/core';
import {UserService} from "./service/user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  isAuthenticate: boolean = false;

  constructor(private userService: UserService) {
  }

  auth(isSuccessAuth: boolean) {
    console.log(isSuccessAuth)
    this.isAuthenticate = isSuccessAuth;
    this.userService.userInfo().subscribe(user => console.log(user))
  }
}
