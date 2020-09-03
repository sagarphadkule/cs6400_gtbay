export class AuctionResult {
    constructor(public itemId: number,
                public itemName: string,
                public salePrice: string,
                public winner: string,
                public auctionEndTimeStamp: string) {    }
  }
  