import {Component, OnInit} from '@angular/core';
import {UserService} from "./service/user.service";
import {User} from "./model/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  isAuthenticate: boolean = false;
  user: User = null as any;

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
    this.isAuthenticate = this.userService.isAuth();
    if (this.isAuthenticate) {
      this.userService.userInfo().subscribe(user => {
        this.user = user
        this.userService.userBehaviorSubject.next(user)
      })
    }
  }

  auth(event: any) {
    this.isAuthenticate = event
    this.userService.userInfo().subscribe(user => {
      this.user = user
      this.userService.userBehaviorSubject.next(user)
    })
  }

  logout() {
    localStorage.clear()
    window.location.reload()
  }
}
