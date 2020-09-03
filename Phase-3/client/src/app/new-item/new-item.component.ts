import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {Item} from '../model/Item';

import {CategoryService} from '../category.service';
import {ItemConditionService} from '../itemCondition.service';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';
import {AuctionService} from '../auction.service';
import {AccountService} from '../account.service';
import {Router} from '@angular/router';




@Component({
  selector: 'app-new-item',
  templateUrl: './new-item.component.html',
  styleUrls: ['./new-item.component.css']
})
export class NewItemComponent implements OnInit {

  item = new Item();
  categories$: Observable<string[]>;
  conditions$: Observable<string[]>;

  constructor(private categoryService: CategoryService,
              private itemConditionService: ItemConditionService,
              private auctionService: AuctionService,
              private accountService: AccountService,
              private router: Router) { }

  ngOnInit() {
    if (this.accountService.user == null) {this.router.navigate(['/login']); } else {
      this.categories$ = this.categoryService.getCategories();
      this.conditions$ = this.itemConditionService.getItemConditions();
      this.item.returnable = false;
      console.log('current logged as: ' + this.accountService.user.username);
    }
  }

  onSubmit() {
    if (this.checkValues()) {
      // this.itemConditionService.getConditionValueByConditoinName(this.item.itemConditionName).subscribe(
      //   (response) => this.item.itemCondition = response
      // );
      this.item.listedByUser = this.accountService.user.username;
      console.log(this.item);
      this.auctionService.addItem(this.item).subscribe(response => {
        alert('Auction created successfully');
        this.router.navigate(['/main']);
      });
    } else { alert('Minimum sale price should be at least greater than starting bid price. \n' +
                    'Get it now price (if specified) should be at least greater than minimum sale price.');}
  }

  checkValues() {
    if (this.item.startingBidPrice <= this.item.minSalePrice) {
      if (this.item.getItNowPrice !== null && this.item.getItNowPrice !== undefined) {
        return this.item.getItNowPrice >= this.item.minSalePrice;
      } else {
        return true;
      }
    } else { return false; }
  }
  get diagnostic() {
    return JSON.stringify(this.item);
  }
}
