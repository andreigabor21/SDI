package ro.ubb.razvan.monitorcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.razvan.monitorcore.model.CountyVote;
import ro.ubb.razvan.monitorcore.model.VoteResultDTO;
import ro.ubb.razvan.monitorcore.model.VoteStatistic;
import ro.ubb.razvan.monitorcore.repository.CountyVoteRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class VoteService {
    @Autowired
    CountyVoteRepository repository;

    public void saveVote(String name, int a, int b, int c, int nr) {
        CountyVote countyVote = CountyVote.builder()
                .id(0L)
                .name(name)
                .a(a)
                .b(b)
                .c(c)
                .nr(nr)
                .build();
        repository.save(countyVote);
    }

    public List<CountyVote> getAll() {
        return repository.findAll();
    }

    public List<CountyVote> getLatest() {
        List<CountyVote> latestVotes = repository.findLatestVotes();
        latestVotes.forEach(System.out::println);
        return latestVotes;
    }

    public List<VoteResultDTO> getResults() {
        VoteStatistic candidatesResult = repository.getCandidatesResult();

        VoteResultDTO resultA = new VoteResultDTO("a", candidatesResult.getA());
        VoteResultDTO resultB = new VoteResultDTO("b", candidatesResult.getB());
        VoteResultDTO resultC = new VoteResultDTO("c", candidatesResult.getC());
        List<VoteResultDTO> voteResultDTOS = Arrays.asList(resultA, resultB, resultC);
        voteResultDTOS.sort((o1, o2) -> (int) (o2.getVotes() - o1.getVotes()));
        return voteResultDTOS;
    }
}
