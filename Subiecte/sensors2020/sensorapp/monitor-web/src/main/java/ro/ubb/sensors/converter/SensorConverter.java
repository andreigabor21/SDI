package ro.ubb.sensors.converter;

import org.springframework.stereotype.Component;
import ro.ubb.sensors.dto.SensorDto;
import ro.ubb.sensors.model.Sensor;

@Component
public class SensorConverter implements Converter<Sensor, SensorDto> {
    @Override
    public Sensor toModel(SensorDto sensorDto) {
        Sensor sensor = Sensor.builder()
                .name(sensorDto.getName())
                .measurement(sensorDto.getMeasurement())
                .time(sensorDto.getTime())
                .build();
        sensor.setId(sensorDto.getId());
        return sensor;
    }

    @Override
    public SensorDto toDTO(Sensor sensor) {
        return SensorDto.builder()
                .id(sensor.getId())
                .name(sensor.getName())
                .measurement(sensor.getMeasurement())
                .time(sensor.getTime())
                .build();
    }
}
