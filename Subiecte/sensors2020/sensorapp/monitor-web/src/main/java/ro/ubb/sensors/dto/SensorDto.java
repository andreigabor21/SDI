package ro.ubb.sensors.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Builder
public class SensorDto implements Serializable {
    private Long id;
    private String name;
    private Integer measurement;
    private Long time;
}
