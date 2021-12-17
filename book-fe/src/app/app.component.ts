import {Component, OnInit} from '@angular/core';
import {UserService} from "./service/user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  isAuthenticate: boolean = false;

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
    this.isAuthenticate = this.userService.isAuth();
  }

  auth(event: any) {
    this.isAuthenticate = event
  }
}
