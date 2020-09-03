import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../model/User';

@Injectable()
export class LoginService {

  constructor(private http: HttpClient) { }

  getUserByUsername(username: string) {
    return this.http.get('http://localhost:8080/users/' + username);
  }

  getUserByUsernameAndPassword(username: string, password: string) {
    return this.http.get<User>('http://localhost:8080/users/' + username + '/' + password);
  }
}
