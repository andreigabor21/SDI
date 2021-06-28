package ro.ubb.sensors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ubb.sensors.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
