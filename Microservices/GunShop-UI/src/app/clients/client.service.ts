import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Client, Clients} from './client-model';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private url = 'http://localhost:8080/clients';

  constructor(private http: HttpClient) { }

  getClients(): Observable<Clients> {
    return this.http.get<Clients>(this.url);
  }

  addClient(name: string, years: number): Observable<any> {
    return this.http.post(this.url, new Client(name, years));
  }
}
