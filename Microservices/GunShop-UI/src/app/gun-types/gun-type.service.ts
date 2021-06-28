import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Client, Clients} from '../clients/client-model';
import {GunType, GunTypes} from './gunType-model';

@Injectable({
  providedIn: 'root'
})
export class GunTypeService {

  private url = 'http://localhost:8080/gun-types';

  constructor(private http: HttpClient) { }

  getGunTypes(): Observable<GunTypes> {
    return this.http.get<GunTypes>(this.url);
  }

  addGunType(name: string, category: string): Observable<any> {
    return this.http.post(this.url, new GunType(name, category));
  }
}
