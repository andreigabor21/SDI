import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from './user.model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) { }

  getUserName(userId): Observable<User> {
    console.log(`${this.url}/user?id=${userId}`);
    return this.httpClient.post<User>(`${this.url}/user?id=${userId}`, {});
  }

  getUserWithFollowers(userId: number): Observable<User> {
    return this.httpClient.get<User>(`${this.url}/user-followers/${userId}`);
  }
}
