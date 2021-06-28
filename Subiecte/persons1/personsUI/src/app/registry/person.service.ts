import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Person} from './person.model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private url = 'http://localhost:8080/persons';

  constructor(private httpClient: HttpClient) { }

  searchPersons(name: string): Observable<Person[]> {
    return this.httpClient.get<Person[]>(`${this.url}-name?name=${name}`);
  }
}
