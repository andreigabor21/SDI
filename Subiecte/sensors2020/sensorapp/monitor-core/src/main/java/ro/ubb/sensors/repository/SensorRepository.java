package ro.ubb.sensors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.ubb.sensors.model.Sensor;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    @Query("select distinct s.name from Sensor s")
    List<String> findAllSensorNames();

    List<Sensor> findTop4ByNameOrderByTimeDesc(String name);
}
