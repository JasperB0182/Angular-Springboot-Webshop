import {Brand} from './brand-model';
import {Categorie} from './categorie-model';

export interface Product{
  productId: number;
  productNaam: string;
  hoeveelheid: number;
  brand: Brand;
  categorie: Categorie;
  prijs: number;
  imgProduct: string;
  beschrijving: string;
  beschrijvingEN: string;
  aantalInWinkelwagen: number;
}
