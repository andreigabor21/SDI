export class GunType {
  id: number;
  name: string;
  category: string;

  constructor(name: string = '', category: string = '') {
    this.name = name;
    this.category = category;
  }
}

export class GunTypes {
  gunTypes: Array<GunType>;
}
