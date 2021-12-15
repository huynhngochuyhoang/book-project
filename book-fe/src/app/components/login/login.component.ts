import {Component, EventEmitter, Input, Output} from '@angular/core';
import {UserService} from "../../service/user.service";
import {UserLogin} from "../../model/user-login";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  username: string = '';
  password: string = '';

  constructor(private userService: UserService, private route: Router) { }

  onclick() {
    let userLogin: UserLogin = {username: this.username, password: this.password}
    this.userService.login(userLogin).subscribe(response => {
      console.log(response)
      localStorage.setItem('accessToken', response.accessToken)
      this.route.navigate(["dashboard"])
    })
  }
}
