import {Brand} from './brand-model';
import {Category} from './category-model';

export interface Product{
  productId: number;
  productName: string;
  amount: number;
  brand: Brand;
  category: Category;
  price: number;
  imgProduct: string;
  description: string;
  descriptionEN: string;
  amountInCart: number;
}
