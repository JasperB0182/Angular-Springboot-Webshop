import {Product} from './product-model';

export interface Brand {
  merkId: number;
  merkNaam: string;
  imgLocation: string;
  products?: Product[];
}
