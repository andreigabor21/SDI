export class Article {
  id: number;
  title: string;
  body: string;

  constructor(title: string, body: string) {
    this.title = title;
    this.body = body;
  }
}
