import {Component, EventEmitter, Input, Output} from '@angular/core';
import {UserService} from "../../service/user.service";
import {UserLogin} from "../../model/user-login";
import {MatDialog} from "@angular/material/dialog";
import {SignupComponent} from "../signup/signup.component";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  @Input() authenticate!: boolean
  @Output() successAuthenticate = new EventEmitter()

  username: string = '';
  password: string = '';

  constructor(private userService: UserService, private dialog: MatDialog) { }

  onclick() {
    let userLogin: UserLogin = {username: this.username, password: this.password}
    this.userService.login(userLogin).subscribe(response => {
      let accessToken = response.accessToken
      localStorage.setItem('accessToken', accessToken)
      this.successAuthenticate.emit(this.userService.isAuth())
    })
  }

  signUp() {
    this.dialog.open(SignupComponent)
  }
}
