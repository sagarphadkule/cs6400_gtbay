
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable()
export class CategoryService {

  constructor(private http: HttpClient) {}

  getCategories() {
    return this.http.get<string[]>('http://localhost:8080/categories');
  }
}
