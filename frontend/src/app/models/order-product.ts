import {Product} from './product-model';

export interface OrderProduct {
  amountBought: number;
  product : Product;
  productOrderNumber: number;
}
