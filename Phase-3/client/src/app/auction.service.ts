import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Item} from './model/Item';
import {Observable} from 'rxjs/Observable';
import {Bid} from './model/Bid';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-type': 'application/json',
    'Authorization': 'root'
  })
};

@Injectable()
export class AuctionService {

  constructor(private http: HttpClient) {}

  addItem(item: Item) {
    return this.http.post<Item>('http://localhost:8080/items', item);
  }

  updateWinnerAndFinalSalePrice(item: Item) {
    const result = this.http.post<Item>('http://localhost:8080/getItNow', item, httpOptions);
    result.toPromise().then(function (data) {
    }).catch(function(error) {
      console.log(error);
    });
  }

  updateDescription(item: Item) {
    const result = this.http.post<Item>('http://localhost:8080/updateDescription', item, httpOptions);
    result.toPromise().then(function (data) {
    }).catch(function(error) {
      console.log(error);
    });
  }

  bidItem (bid: Bid) {
  const result = this.http.post<Item>('http://localhost:8080/bidItem', bid, httpOptions);
  result.toPromise().then(function (data) {
  }).catch(function(error) {
    console.log(error);
  });
}

}
