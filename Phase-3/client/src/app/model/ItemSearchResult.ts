import {Timestamp} from 'rxjs/operators/timestamp';

export class ItemSearchResult {
  id: number;
  name: string;
  highBidder: string;
  currentBid: number;
  getItNowPrice: number;
  auctionEnds: string;
}
