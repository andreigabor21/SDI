package ro.ubb.razvan.monitorweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.razvan.monitorcore.controller.VoteService;
import ro.ubb.razvan.monitorcore.model.CountyVote;
import ro.ubb.razvan.monitorcore.model.VoteResultDTO;
import ro.ubb.razvan.monitorweb.converter.VoteConverter;
import ro.ubb.razvan.monitorweb.dto.VoteDTO;
import ro.ubb.razvan.monitorweb.dto.VoteResultsDTO;
import ro.ubb.razvan.monitorweb.dto.VotesDTO;

import java.util.List;

@RestController
public class VotingRestController {
    @Autowired
    private VoteService voteService;

    @Autowired
    private VoteConverter voteConverter;

    @GetMapping(value = "/voting")
    void test() {
        System.out.println("reached!");
    }

    @PostMapping(value = "/voting")
    void receiveVotingInfo(@RequestBody VoteDTO dto) {
        System.out.println(
                String.format("%s,%d,%d,%d,%d", dto.getName(),
                        dto.getA(),
                        dto.getB(),
                        dto.getC(),
                        dto.getNr())
        );
        voteService.saveVote(dto.getName(), dto.getA(), dto.getB(), dto.getC(), dto.getNr());
    }

    @GetMapping(value = "/voting/all")
    VotesDTO getAll() {
        List<CountyVote> all = voteService.getAll();
        return new VotesDTO(voteConverter.toDTOList(all));
    }

    @GetMapping(value = "/voting/latest")
    VotesDTO getLatest() {
        List<CountyVote> latest = voteService.getLatest();
        return new VotesDTO(voteConverter.toDTOList(latest));
    }

    @GetMapping(value = "/voting/results")
    VoteResultsDTO getResults() {
        List<VoteResultDTO> results = voteService.getResults();
        return new VoteResultsDTO(results);
    }
}
