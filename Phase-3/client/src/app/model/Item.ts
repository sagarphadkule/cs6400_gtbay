import {Bid} from './Bid';

export class Item {
  name: string;
  description: string;
  category: string;
  itemConditionName: string;
  itemCondition: number;
  startingBidPrice: number;
  minSalePrice: number;
  getItNowPrice: number;
  returnable: boolean;
  auctionLength: number;
  listedByUser: string;
  condition: string;
  id: number;
  winner: string;
  auctionEndTime: string;
  bidList: Bid[];


}
