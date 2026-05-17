import {Product} from './product-model';

export interface Brand {
  brandId: number;
  brandName: string;
  imgLocation: string;
  products?: Product[];
}
