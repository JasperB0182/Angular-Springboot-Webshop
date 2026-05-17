import {OrderProduct} from './order-product';

export interface Order {
  orderId : number;
  orderDate : string;
  orderProducts : OrderProduct[];
  totalPrice : number;
  fullname : string;
  city : string;
  address : string;
  zipcode : string;
}
