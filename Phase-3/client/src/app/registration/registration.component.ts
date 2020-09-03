import {Component, OnInit, Output, EventEmitter, ViewChild, ElementRef} from '@angular/core';
import { User} from '../model/User';
import {RegistrationService} from './registration.service';
import {Router} from '@angular/router';
import {AccountService} from '../account.service';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
  // providers: [AccountService]
})
export class RegistrationComponent implements OnInit {

  user = new User();
  duplicatedUsername = false;

  constructor(private accountService: AccountService, private router: Router) {}
  ngOnInit() {
  }

  onRegister() {
    this.accountService.addUser(this.user).subscribe(
      (response) => {
        alert('Registration is successful');
        this.router.navigate(['/login']); },
      (error) => {
        console.log(error.error.message);
        console.log(error.error.message.search('Duplicate entry') > 0);
        if (error.error.message.search('Duplicate entry') > 0) {this.duplicatedUsername = true};
      }
    );
  }
  get diagnostic() { return JSON.stringify(this.user); }

}
