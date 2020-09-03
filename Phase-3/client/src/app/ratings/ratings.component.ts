import { Component, OnInit } from '@angular/core';
import {RatingsService} from './ratings.service';
import {AccountService} from '../account.service';
import {SearchItemService} from '../search-item/search-item.service';
import {Rating} from '../model/Rating';
import {Observable} from 'rxjs/Observable';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import 'rxjs/add/operator/map';
import { Location } from '@angular/common';
import {Item} from '../model/Item';


@Component({
  selector: 'app-ratings',
  templateUrl: './ratings.component.html',
  styleUrls: ['./ratings.component.css'],
  providers: [Location]
})
export class RatingsComponent implements OnInit {

  ratings$: Observable<Rating[]>
  newRating: Rating = new Rating();
  item: Item;
  itemId: number;
  ratingsByLoggedInUserCount: number = 1; // will change when all ratings are retrieved

  constructor(private ratingService: RatingsService,
              private accountService: AccountService,
              private route: ActivatedRoute,
              private router: Router,
              private location: Location,
              private searchItemService: SearchItemService) {

  }

  ngOnInit() {
    if (this.accountService.user === undefined) {
       this.router.navigate(['/login'])
      } 
    else {
      this.itemId = Number(this.route.snapshot.paramMap.get('id'));

      this.searchItemService.getItemById(Number(this.route.snapshot.paramMap.get('id'))).
            subscribe(item => this.item = item);

      this.ratings$ = this.route.paramMap.switchMap(
        (params: ParamMap) =>  this.ratingService.getRatingsByItemId(+params.get('id')));
      
       this.ratingService.countRatings(
              this.itemId, this.accountService.user.username).subscribe(
              response => this.ratingsByLoggedInUserCount = response
            );


    }
  }

  createdByCurrentUser(username: string) {
    return this.accountService.user.username === username;
  }

  onDelete(itemId: number, username: string) {
    this.ratingService.deleteRating(itemId, username).subscribe(response => {
      this.ngOnInit();
    });
  }

  onCancel() {
    this.router.navigateByUrl("/item/" + this.itemId.toString());
  }

  onSubmit() {
    this.newRating.ratedByUser = this.accountService.user.username;
    this.newRating.ratedItemId = this.itemId;
    
      this.ratingService.submitRating(this.newRating).subscribe(response => {
        this.ngOnInit();
      });
  }

}
