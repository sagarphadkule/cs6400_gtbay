import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Rating} from '../model/Rating';

@Injectable()
export class RatingsService {

  constructor(private http: HttpClient) {}

  getRatingsByItemId(id: number) {
    return this.http.get<Rating[]>('http://localhost:8080/ratings/' + id);
  }

  deleteRating(itemId: number, username: string) {
    const url = 'http://localhost:8080/ratings/' + itemId + "/" + username;
    console.log(url);
    return this.http.delete(url);
  }

  countRatings(itemId: number, username: string) {
    return this.http.get<number>('http://localhost:8080/ratings/count/' + itemId + '/' + username);
  }

  submitRating(rating: Rating) {
    return this.http.post<Rating>('http://localhost:8080/ratings', rating);
  }

}
