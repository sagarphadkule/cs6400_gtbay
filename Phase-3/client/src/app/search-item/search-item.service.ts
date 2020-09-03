import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ItemSearchCriteria} from '../model/ItemSearchCriteria';
import {ItemSearchResult} from '../model/ItemSearchResult';
import {Item} from '../model/Item';
import {Bid} from '../model/Bid';

@Injectable()
export class SearchItemService {

  criteria: ItemSearchCriteria;
  results: ItemSearchResult[];
  id: number;

  constructor(private http: HttpClient) {}

  searchItem(criteria: ItemSearchCriteria) {
    const url = 'http://localhost:8080/items/search/'
      + criteria.keyword + '/'
      + criteria.category + '/'
      + criteria.conditionAtLeast + '/'
      + criteria.minPrice + '/'
      + criteria.maxPrice;

    console.log(url);
    return this.http.get<ItemSearchResult[]>(url);
  }

  getItemById(id: number) {
    return this.http.get<Item>('http://localhost:8080/items/' + id);
  }

  getBids(id: number) {
    return this.http.get<Bid[]>('http://localhost:8080/getBids/' + id);
  }

}
