import {HttpClient} from "@angular/common/http";
import {VoteResults, Votes} from "./voting.model";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";

@Injectable()
export class VotingService {
  private url = "http://localhost:8080/api"

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Votes> {
    return this.httpClient.get<Votes>(`${this.url}/voting/all`);
  }

  getLatest(): Observable<Votes> {
    return this.httpClient.get<Votes>(`${this.url}/voting/latest`);
  }

  getResults(): Observable<VoteResults> {
    return this.httpClient.get<VoteResults>(`${this.url}/voting/results`);
  }
}
