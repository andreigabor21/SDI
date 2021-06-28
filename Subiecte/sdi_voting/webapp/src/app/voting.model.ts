export class Vote {
  id: number
  name: string
  a: number
  b: number
  c: number
  nr: number
}

export class Votes {
  votes: Array<Vote>
}

export class VoteResult {
  candidate: string
  votes: number
}

export class VoteResults {
  results: Array<VoteResult>
}
