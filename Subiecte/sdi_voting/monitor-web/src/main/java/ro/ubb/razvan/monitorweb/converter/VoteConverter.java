package ro.ubb.razvan.monitorweb.converter;

import org.springframework.stereotype.Component;
import ro.ubb.razvan.monitorcore.model.CountyVote;
import ro.ubb.razvan.monitorweb.dto.VoteDTO;

@Component
public class VoteConverter implements Converter<CountyVote, VoteDTO> {
    @Override
    public CountyVote toModel(VoteDTO voteDTO) {
        return CountyVote.builder()
                .id(0L)
                .name(voteDTO.getName())
                .a(voteDTO.getA())
                .b(voteDTO.getB())
                .c(voteDTO.getC())
                .nr(voteDTO.getNr())
                .build();
    }

    @Override
    public VoteDTO toDTO(CountyVote countyVote) {
        return VoteDTO.builder()
                .name(countyVote.getName())
                .a(countyVote.getA())
                .b(countyVote.getB())
                .c(countyVote.getC())
                .nr(countyVote.getNr())
                .build();
    }
}
