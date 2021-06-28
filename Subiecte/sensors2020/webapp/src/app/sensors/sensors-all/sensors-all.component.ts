import { Component, OnInit } from '@angular/core';
import {Sensor} from '../shared/sensor.model';
import {SensorService} from '../shared/sensor.service';

@Component({
  selector: 'app-sensors-all',
  templateUrl: './sensors-all.component.html',
  styleUrls: ['./sensors-all.component.css']
})
export class SensorsAllComponent implements OnInit {

  sensors: Sensor[];

  constructor(private sensorService: SensorService) { }

  ngOnInit(): void {
    this.getSensors();
  }

  getSensors(): void {
    this.sensorService.getSensors()
      .subscribe(s => this.sensors = s);
  }

}
