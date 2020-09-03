import { Component, OnInit } from '@angular/core';
import {SearchItemService} from '../search-item/search-item.service';
import {ItemSearchResult} from '../model/ItemSearchResult';
import {Router} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {AccountService} from '../account.service';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {

  constructor(private searchItemService: SearchItemService,
              private router: Router,
              private accountService: AccountService) { }

  results$: Observable<ItemSearchResult[]>;

  ngOnInit() {
    if (this.accountService.user !== undefined) {
      console.log(this.searchItemService.criteria);
      this.generateResult();
    } else {
      this.router.navigate(['/login']);
    }
  }

  generateResult() {
    this.results$ = this.searchItemService.searchItem(this.searchItemService.criteria);

  }

  onBack() { this.router.navigate(['/search']);}

}
