package ro.ubb.sensors.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sensor extends BaseEntity<Long> {

    private String name;

    @Transient
    private Long sensorId;

    private Integer measurement;

    private Long time;
}
