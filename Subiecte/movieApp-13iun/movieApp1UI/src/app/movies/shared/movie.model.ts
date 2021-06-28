import {Actor} from '../../actors/shared/actor.model';

export class Movie {
  id: number;
  title: string;
  year: number;
  actors: Actor[];
}
