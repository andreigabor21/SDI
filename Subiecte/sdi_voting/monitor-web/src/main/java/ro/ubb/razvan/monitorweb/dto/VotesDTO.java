package ro.ubb.razvan.monitorweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotesDTO implements Serializable {
    List<VoteDTO> votes;
}
