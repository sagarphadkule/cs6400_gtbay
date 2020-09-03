import { Component, OnInit } from '@angular/core';
import {AuctionService} from '../auction.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Item} from '../model/Item';
import {SearchItemService} from '../search-item/search-item.service';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/switchMap';
import {AccountService} from '../account.service';
import {Bid} from '../model/Bid';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  item$: Observable<Item>;
  bids: Bid[];
  myBid: number;
  message: string;

  constructor(private searchItemService: SearchItemService,
              private router: Router,
              private route: ActivatedRoute,
              private accountService: AccountService,
              private auctionService: AuctionService) { }

  ngOnInit() {
    this.message = '';
    if (this.accountService.user === undefined) { this.router.navigate(['/login']); } else {
      this.searchItemService.getBids(Number(this.route.snapshot.paramMap.get('id'))).subscribe(bids => this.bids = bids);
      this.item$ = this.route.paramMap.switchMap(
        (params: ParamMap) => this.searchItemService.getItemById(+params.get('id')));
    }
  }

  onGetItNow(item) {
    item.winner = this.accountService.user.username;
    this.auctionService.updateWinnerAndFinalSalePrice(item);
  }

  editDescription(description, itemId) {
    const obj = new Item();
    obj.id = itemId;
    obj.description = description;
    this.auctionService.updateDescription(obj);
  }

  onBack() { this.router.navigate(['/searchResult']); }

  createdByCurrentUser(username: string) {
    return this.accountService.user.username === username;
  }

  placeBid(item: Item) {
    console.log(item.getItNowPrice);
    console.log(this.myBid);
    if (this.bids !== null && this.bids[0] !== undefined && this.bids[0].amount !== undefined && this.myBid <= this.bids[0].amount) {
      this.message = 'Bid has to be at least one dollar higher than the current bid';
      return;
    } else if (this.myBid <= 1) {
      this.message = 'Bid has to greater than one dollar ';
      return;
    } else if (this.myBid === undefined) {
      this.message = 'Bid has to be at least one dollar higher than the current bid';
      return;
    } else if (item.getItNowPrice !== null && this.myBid >= item.getItNowPrice) {
      this.message = 'Click Get It Now instead of bidding';
      return;
    } else if (this.myBid < item.startingBidPrice) {
      this.message = 'Bid cannot be less than the starting Bid price';
      return;
    } else {
      this.message = '';
    }
    const bid = new Bid();
    bid.bidByUser = this.accountService.user.username;
    bid.amount = this.myBid;
    bid.bidItemId = item.id;
    this.auctionService.bidItem(bid);
    this.message = 'Bid successfully placed';
    this.searchItemService.getBids(Number(this.route.snapshot.paramMap.get('id'))).subscribe(bids => this.bids = bids);
  }
}
