import { Component, OnInit } from '@angular/core';
import {AuctionResult} from './auction-result.structure';
import {AuctionResultsService} from './auction-results.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-auction-results',
  templateUrl: './auction-results.component.html',
  styleUrls: ['./auction-results.component.css']
})

export class AuctionResultsComponent implements OnInit {

  constructor(private auctionResultsService: AuctionResultsService, private router: Router) { }

  currentUrl: string;
  auctionResults: AuctionResult[];
  
  ngOnInit() {
    this.currentUrl = this.router.url;
    this.showAuctionResults();
  }

  showAuctionResults(): void {
    this.auctionResultsService.getAuctionResults()
      .subscribe(auctionResults => this.auctionResults = auctionResults);
  }


}




