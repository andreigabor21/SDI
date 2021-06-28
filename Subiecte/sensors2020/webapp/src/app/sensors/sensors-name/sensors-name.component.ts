import { Component, OnInit } from '@angular/core';
import {SensorService} from '../shared/sensor.service';
import {Sensor} from '../shared/sensor.model';

@Component({
  selector: 'app-sensors-name',
  templateUrl: './sensors-name.component.html',
  styleUrls: ['./sensors-name.component.css']
})
export class SensorsNameComponent implements OnInit {

  names: string[];
  shown = false;
  dataForNames = new Map<string, Sensor[]>();

  constructor(private sensorService: SensorService) { }

  ngOnInit(): void {
    this.getNames();
  }

  getNames(): void {
    this.sensorService.getSensorNames()
      .subscribe(n => this.names = n);
  }

  showClicked(): void {
    this.shown = true;
    this.updateSensors();
    setInterval(() => this.updateSensors(), 3000);
  }

  private updateSensors(): void {
    this.getNames();
    this.names.forEach(name => {
      this.sensorService.getSensorsByName(name)
        .subscribe(sensors => {
          this.dataForNames.set(name, sensors);
          console.log(sensors);
        });
    });
  }

  kill(name: string): void {
    console.log('kill ' + name);
    this.sensorService.killSensor(name).subscribe();
  }
}
