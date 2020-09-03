import {Injectable} from '@angular/core';
import {CategoryReport} from './category.report';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {UserReport} from './user.report';

@Injectable()
export class ReportService {

  constructor(private http: HttpClient) { }

  generateCategoryReport(): Observable<CategoryReport[]> {
    return this.http.get<CategoryReport[]>('http://localhost:8080/categoryReport');
  }

  generateUserReport(): Observable<UserReport[]> {
    return this.http.get<UserReport[]>('http://localhost:8080/userReport');
  }

}
