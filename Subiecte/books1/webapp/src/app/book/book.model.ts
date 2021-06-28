import {Author} from './author.model';

export class Book {
  id: number;
  title: string;
  year: number;
  authorDto: Author;
}
