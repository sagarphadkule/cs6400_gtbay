import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const users = [
      { username: 'user1', password: 'pass1', firstName: 'Danite' , lastName: 'Kelor' },
      { username: 'user2', password: 'pass2', firstName: 'Dodra', lastName: 'Kiney'},
      { username: 'user3', password: 'pass3', firstName: 'Peran', lastName: 'Bishop' },
      { username: 'user4', password: 'pass4', firstName: 'Randy', lastName: 'Roran'},
      { username: 'user5', password: 'pass5', firstName: 'Ashod', lastName: 'Iankel'},
      { username: 'user6', password: 'pass6', firstName: 'Cany', lastName: 'Achant'}
    ];
    return {users};
  }
}


/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/
