export class Client {
  id: number;
  name: string;
  years: number;

  constructor(name: string = '', years: number = 0) {
    this.name = name;
    this.years = years;
  }
}

export class Clients {
  clients: Array<Client>;
}
