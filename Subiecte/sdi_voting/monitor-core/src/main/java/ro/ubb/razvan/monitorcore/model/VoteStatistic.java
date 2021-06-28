package ro.ubb.razvan.monitorcore.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class VoteStatistic {
    private Long a;
    private Long b;
    private Long c;
}
