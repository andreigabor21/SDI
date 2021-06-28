package ro.ubb.razvan.monitorweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.ubb.razvan.monitorcore.model.VoteResultDTO;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteResultsDTO implements Serializable {
    private List<VoteResultDTO> results;
}
