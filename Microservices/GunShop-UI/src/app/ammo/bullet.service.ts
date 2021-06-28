import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Client, Clients} from '../clients/client-model';
import {Bullet} from './bullet-model';

@Injectable({
  providedIn: 'root'
})
export class BulletService {

  private url = 'http://localhost:8080/bullets';

  constructor(private http: HttpClient) { }

  getBullets(): Observable<Bullet[]> {
    return this.http.get<Bullet[]>(this.url);
  }

  addBullet(velocity: number, brand: string): Observable<any> {
    return this.http.post(this.url, new Bullet(velocity, brand));
  }
}
