import {Component, OnInit} from '@angular/core';
import {Vote} from "../voting.model";
import {VotingService} from "../voting.service";

@Component({
  selector: 'app-voting-all',
  templateUrl: './voting-all.component.html',
  styleUrls: ['./voting-all.component.css']
})
export class VotingAllComponent implements OnInit {
  votes: Array<Vote>;

  constructor(private votingService: VotingService) {
  }

  ngOnInit(): void {
    this.votingService.getAll().subscribe(dto => this.votes = dto.votes);
  }

}
