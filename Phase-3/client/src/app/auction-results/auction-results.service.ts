import {Injectable} from '@angular/core';
import {AuctionResult} from './auction-result.structure';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class AuctionResultsService {

  constructor(private http: HttpClient) { }

  getAuctionResults(): Observable<AuctionResult[]> {
    return this.http.get<AuctionResult[]>('http://localhost:8080/auctionResults');
  }
}
