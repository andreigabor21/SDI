package ro.ubb.sensors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.sensors.model.Sensor;
import ro.ubb.sensors.repository.SensorRepository;

import java.util.List;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    public List<String> findAllDistinctNames() {
        return sensorRepository.findAllSensorNames();
    }

    public List<Sensor> findTopByName(String name){
        return sensorRepository.findTop4ByNameOrderByTimeDesc(name);
    }

}
