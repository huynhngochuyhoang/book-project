import {Component, EventEmitter, Input, Output} from '@angular/core';
import {UserService} from "../../service/user.service";
import {UserLogin} from "../../model/user-login";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  @Input() authenticate!: boolean;
  @Output() successAuthenticate = new EventEmitter();
  username: string = '';
  password: string = '';

  constructor(private userService: UserService) { }

  onclick() {
    let userLogin: UserLogin = {username: this.username, password: this.password}
    this.userService.login(userLogin).subscribe(response => {
      console.log(response)
      localStorage.setItem('accessToken', response.accessToken)
      this.authenticate = true;
      this.successAuthenticate.emit(this.authenticate);
    })
  }
}
