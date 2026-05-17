import {Product} from './product-model';
import {Order} from './order-model';

export interface UserDetails{
  id : number;
  email : string;
  password : string;
  firstName : string;
  orders : Order[];
}

