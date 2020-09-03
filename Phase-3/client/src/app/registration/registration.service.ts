import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { User } from '../model/User';
import { Observable } from 'rxjs/Observable';
import {catchError} from 'rxjs/operators';
import {ErrorObservable} from 'rxjs/observable/ErrorObservable';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-type': 'application/json',
    'Authorization': 'root'
  })
};

@Injectable()
export class RegistrationService {
  constructor(private http: HttpClient) {}

  // addUser(user: User): Observable<User> {
  addUser(user: User) {
    return this.http.post<User>('http://localhost:8080/users', user, httpOptions);
      // .pipe(catchError(this.handleError));
  }

  // private handleError(error: HttpErrorResponse) {
  //   if (error.error instanceof ErrorEvent) {
  //     // A client-side or network error occurred. Handle it accordingly.
  //     console.error('An error occurred:', error.error.message);
  //   } else {
  //     // The backend returned an unsuccessful response code.
  //     // The response body may contain clues as to what went wrong,
  //     console.error(
  //       `Backend returned code ${error.status}, ` +
  //       `body was: ${error.error}`);
  //   }
  //   // return an ErrorObservable with a user-facing error message
  //   return new ErrorObservable(
  //     'Something bad happened; please try again later.');
  // };
}
