import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {Router} from '@angular/router';
import {ItemSearchCriteria} from '../model/ItemSearchCriteria';
import {ItemConditionService} from '../itemCondition.service';
import {CategoryService} from '../category.service';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {SearchItemService} from './search-item.service';
import {AccountService} from '../account.service';


@Component({
  selector: 'app-search-item',
  templateUrl: './search-item.component.html',
  styleUrls: ['./search-item.component.css'],
})
export class SearchItemComponent implements OnInit {

  constructor(private router: Router,
              private searchItemService: SearchItemService,
              private itemConditionService: ItemConditionService,
              private categoryService: CategoryService,
              private accountService: AccountService ) { }

  criteria: ItemSearchCriteria;
  conditions$: Observable<string[]>;
  categories$: Observable<string[]>;

  ngOnInit() {
    if (this.accountService.user !== undefined) {
      this.criteria = new ItemSearchCriteria();
      this.categories$ = this.categoryService.getCategories();
      this.conditions$ = this.itemConditionService.getItemConditions();
    } else { this.router.navigate(['/login']); }
  }

  onSubmit() {
    console.log(this.criteria);
    this.searchItemService.criteria = this.criteria;
    if (this.criteria.keyword === undefined) { this.searchItemService.criteria.keyword = ' ';}
    if (this.criteria.category === undefined) { this.searchItemService.criteria.category = ' ';}
    if (this.criteria.minPrice === undefined) { this.searchItemService.criteria.minPrice = -1;}
    if (this.criteria.maxPrice === undefined) { this.searchItemService.criteria.maxPrice = -1;}
    if (this.criteria.conditionAtLeast === undefined) { this.searchItemService.criteria.conditionAtLeast = ' ';}
    this.router.navigate(['/searchResult']);

    // this.searchItemService.searchItem(this.criteria).subscribe(
    //   (response) => {
    //     this.searchItemService.result = response;
    //     this.router.navigate(['/searchResult']);
    //   }
    // );
  }

  onCancel() {
    this.router.navigate(['/main']);
  }

  get diagnostic() {
    return JSON.stringify(this.criteria);
  }

  checkValue() {
    if (this.checkExist(this.criteria.minPrice) && this.checkExist(this.criteria.maxPrice)) {
      return this.criteria.maxPrice >= this.criteria.minPrice;
    } else { return true; }
  }

  checkExist(num: number) {
    return num !== undefined && num !== null;
  }
}
