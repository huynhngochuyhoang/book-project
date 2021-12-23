import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  public signupForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private userService: UserService) { }

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      username: [''],
      password: [''],
      email: [''],
      phone: [''],
      firstName: [''],
      lastName: ['']
    })
  }

  signup() {
    let userRegister = this.signupForm.value
    this.userService.register(userRegister).subscribe(() => alert('Register successfully'), error => alert(error))
  }
}
