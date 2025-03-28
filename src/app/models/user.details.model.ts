import {Product} from './product-model';

export interface UserDetails{
  id : number;
  email : string;
  password : string;
  voornaam : string;
  bestellingen : bestellingen[];
}

export interface bestellingen{
  bestellingId : number;
  orderDatum : string;
  bestellingProducten : bestellingProducten[];
  totaleprijs : number;
  fullname : string;
  city : string;
  address : string;
  postcode : string;
}

export interface bestellingProducten{
  hoeveelheid_besteld: number;
  product : Product;
  productBestellingNummer: number;
}
