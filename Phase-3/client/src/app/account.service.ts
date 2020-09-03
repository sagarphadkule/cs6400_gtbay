import {User} from './model/User';
import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class AccountService {
  user: User;

  constructor(private http: HttpClient) {
  }

  addUser(user: User) {
    return this.http.post<User>('http://localhost:8080/users', user);
  }

  getUserByUsernameAndPassword(username: string, password: string) {
    return this.http.get<User>('http://localhost:8080/users/' + username + '/' + password);
  }
}
