import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class ItemConditionService {

  constructor(private http: HttpClient) {}

  getItemConditions() {
    return this.http.get<string[]>('http://localhost:8080/itemconditions');
  }

  getConditionValueByConditoinName(name: string) {
    return this.http.get<number>('http://localhost:8080/itemconditions/' + name);
  }
}
