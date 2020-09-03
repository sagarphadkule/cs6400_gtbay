import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import {LoginService} from './login.service';
import {User} from '../model/User';
import {Router} from '@angular/router';
import {AccountService} from '../account.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  // providers: [AccountService]
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  loginFailed = false;
  constructor(private accountService: AccountService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.username);
    console.log(this.password);
    this.accountService.getUserByUsernameAndPassword(this.username, this.password)
      .subscribe(
        (user) => {
          console.log(user);
          if (user.username === null) {
            this.loginFailed = true;
          } else {
            this.accountService.user = user;
            this.router.navigate(['/main']);}
        },
        (error) => console.log(error.error.message))
  }
}
