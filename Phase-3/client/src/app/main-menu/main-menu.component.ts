import {Component, EventEmitter, OnChanges, OnInit, Output} from '@angular/core';
import {AccountService} from '../account.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-main-menu',
  templateUrl: './main-menu.component.html',
  styleUrls: ['./main-menu.component.css']
})
export class MainMenuComponent implements OnInit {
  @Output() selectedFeature = new EventEmitter<string>();
  isLoggedIn: boolean;
  isAdmin: boolean;
  position: string;
  constructor(private accountService: AccountService,
              private router: Router) { }

  ngOnInit() {
    this.isLoggedIn = this.accountService.user !== undefined;
    if (this.isLoggedIn) {
      this.isAdmin = this.accountService.user.position !== null;
      this.position = this.accountService.user.position;
    } else {
      this.router.navigate(['login']);
    }
  }
}
