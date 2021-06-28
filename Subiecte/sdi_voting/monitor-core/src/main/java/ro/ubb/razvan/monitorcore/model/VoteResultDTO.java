package ro.ubb.razvan.monitorcore.model;

import lombok.*;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class VoteResultDTO implements Serializable, Comparable<VoteResultDTO> {
    String candidate;
    Long votes;

    @Override
    public int compareTo(VoteResultDTO o) {
        return (int) (votes - o.votes);
    }
}
