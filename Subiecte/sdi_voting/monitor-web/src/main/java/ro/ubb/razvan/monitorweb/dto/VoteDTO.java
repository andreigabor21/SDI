package ro.ubb.razvan.monitorweb.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class VoteDTO implements Serializable {
    String name;
    int a;
    int b;
    int c;
    int nr;
}
