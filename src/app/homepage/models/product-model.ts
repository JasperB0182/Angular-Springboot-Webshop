export interface Brand {
  merk_id: number;
  merk_naam: string;
  img_location: string | null;
}

export interface Product {
  product_id: number;
  product_naam: string;
  hoeveelheid: number;
  brand: Brand;
  graphics_engine: string;
  videogeheugen: string;
  prijscategorie_id: number;
  prijs: number;
  img_product: string;
  beschrijving: string;
}
