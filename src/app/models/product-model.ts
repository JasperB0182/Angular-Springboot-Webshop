export interface Categorie {
  categoryId: number;
  categoryName: string;
  products?: Product[];
}

export interface Brand {
  merkId: number;
  merkNaam: string;
  imgLocation: string;
  products?: Product[];
}

export interface Product {
  productId: number;
  productNaam: string;
  hoeveelheid: number;
  brand: Brand;
  categorie: Categorie;
  prijs: number;
  imgProduct: string;
  beschrijving: string;
}
