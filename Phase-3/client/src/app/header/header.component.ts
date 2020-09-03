import {Component, OnInit, Output, EventEmitter, DoCheck} from '@angular/core';
import {AccountService} from '../account.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, DoCheck {

  @Output() selectedFeature = new EventEmitter<string>();
  constructor(private accountService: AccountService) { }
  isAdmin: boolean;
  isLoggedIn: boolean;
  ngOnInit() {}

  ngDoCheck(): void {
    this.isLoggedIn = this.accountService.user !== undefined;
    if (this.isLoggedIn) {
      this.isAdmin = this.accountService.user.position !== null;
    } else { this.isAdmin = false;}
  }
}
