import {Injectable, OnInit} from '@angular/core';
import {dummy_products} from '../shopping-cart/dummy_products';
import {Product} from '../models/product-model';
import Swal from 'sweetalert2'


@Injectable({
  providedIn: 'root'
})
export class ShoppingcartService{

  constructor() {
    const savedCart = localStorage.getItem('productsCart');
    if (savedCart) {
      this.ProductsCart = JSON.parse(savedCart);
    } else {
      this.ProductsCart = [];
    }
  }

  public ProductsCart : Product[];


  public AddToCart(Product : Product){
    this.ProductsCart.push(Product)
    localStorage.setItem('productsCart', JSON.stringify(this.ProductsCart));
    Swal.fire({
      title: "Succes!",
      text: "Items zijn toegevoegd aan de winkelwagen.",
      icon: "success"
    })
  }

  public EmptyCart(){
    this.ProductsCart = [];
    localStorage.setItem('productsCart', JSON.stringify(this.ProductsCart));
    location.reload()
  }




}
