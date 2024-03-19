import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {

  loginForm: FormGroup;

  constructor(private userService: UserService,
              private router: Router,
              private formBuilder:FormBuilder) {
    this.loginForm = this.formBuilder.group({
      username:['', Validators.required],
      password:['', Validators.required]
    });
  }

  submitLoginForm() {
    const data = {...this.loginForm.value};
    this.userService.authenticate(data).subscribe(
      response => {
        localStorage.setItem('user', JSON.stringify(response))
      })
  }

}
