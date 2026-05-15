import {Product} from './product-model';

export interface Categorie {
  categoryId: number;
  categoryName: string;
  products?: Product[];
}
