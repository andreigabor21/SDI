export class Bullet {
  id: number;
  velocity: number;
  brand: string;

  constructor(velocity: number, brand: string) {
    this.velocity = velocity;
    this.brand = brand;
  }
}
