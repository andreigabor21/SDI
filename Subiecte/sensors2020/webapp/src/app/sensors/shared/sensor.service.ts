import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Sensor} from './sensor.model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SensorService {

  private url = 'http://localhost:8080/api';

  constructor(private httpClient: HttpClient) { }

  getSensors(): Observable<Sensor[]> {
    return this.httpClient.get<Sensor[]>(`${this.url}/all`);
  }

  getSensorNames(): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.url}/names`);
  }

  getSensorsByName(name: string): Observable<Sensor[]> {
    return this.httpClient.get<Sensor[]>(`${this.url}/sensors/${name}`);
  }

  killSensor(name: string): Observable<any> {
    console.log(`${this.url}/kill`);
    return this.httpClient.post(`${this.url}/kill?name=${name}`, {});
  }
}
