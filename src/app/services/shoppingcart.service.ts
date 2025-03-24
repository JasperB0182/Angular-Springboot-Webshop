import {Injectable} from '@angular/core';
import {Product} from '../models/product-model';
import Swal from 'sweetalert2'


@Injectable({
  providedIn: 'root'
})
export class ShoppingcartService{
  totalCost : number = 0;

  constructor() {
    const savedCart = localStorage.getItem('productsCart');
    if (savedCart) {
      this.ProductsCart = JSON.parse(savedCart);
    } else {
      this.ProductsCart = [];
    }
  }



  public ProductsCart : Product[];


  public CalculateTotalCost() {
    this.totalCost = 0;
    for(let i=0; i<this.ProductsCart.length; i++){
      console.log(this.ProductsCart[i].prijs);
      this.totalCost += this.ProductsCart[i].prijs * this.ProductsCart[i].aantalInWinkelwagen;
    }
  }


  public AddToCart(Product : Product){
    const stringified = JSON.stringify(this.ProductsCart)
    if (stringified.includes(Product.productNaam)){
      let index = this.ProductsCart.findIndex((e) => e.productId === Product.productId)
      this.ProductsCart[index].aantalInWinkelwagen += 1;
      localStorage.setItem('productsCart', JSON.stringify(this.ProductsCart));
      Swal.fire({
        title: "Succes!",
        text: "Items zijn toegevoegd aan de winkelwagen.",
        icon: "success"
      })
    } else {
    this.ProductsCart.push(Product)
    localStorage.setItem('productsCart', JSON.stringify(this.ProductsCart));
    Swal.fire({
      title: "Succes!",
      text: "Items zijn toegevoegd aan de winkelwagen.",
      icon: "success"
    })
    }
  }

  public EmptyCart(){
    this.ProductsCart = [];
    localStorage.setItem('productsCart', JSON.stringify(this.ProductsCart));
    location.reload()
  }




}
