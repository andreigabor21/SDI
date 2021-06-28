import {Component, OnInit} from '@angular/core';
import {Vote, VoteResult} from "../voting.model";
import {VotingService} from "../voting.service";

@Component({
  selector: 'app-voting-latest',
  templateUrl: './voting-latest.component.html',
  styleUrls: ['./voting-latest.component.css']
})
export class VotingLatestComponent implements OnInit {
  votes: Array<Vote>;
  results: Array<VoteResult>;

  constructor(private votingService: VotingService) {
  }

  ngOnInit(): void {
    this.updateLatest();
    this.updateRanking();
    setInterval(() => this.updateLatest(), 5000);
    setInterval(() => this.updateRanking(), 5000);
  }

  updateLatest() {
    this.votingService.getLatest().subscribe(dto => this.votes = dto.votes);
  }

  updateRanking() {
    this.votingService.getResults().subscribe(dto => this.results = dto.results);
  }
}
