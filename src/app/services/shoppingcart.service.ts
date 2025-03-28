import {inject, Injectable} from '@angular/core';
import {Product} from '../models/product-model';
import Swal from 'sweetalert2'
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ShoppingcartService{
  totalCost : number = 0;
  protected httpClient = inject(HttpClient);
  protected address = ""
  protected fullname = ""
  protected city = ""
  protected postcode = ""

  constructor() {
    const savedCart = localStorage.getItem('productsCart');
    if (savedCart) {
      this.ProductsCart = JSON.parse(savedCart);
    } else {
      this.ProductsCart = [];
    }
  }

  public setAddress(address : string){
    this.address = address
  }

  public setFullname(fullname : string){
    this.fullname = fullname
  }

  public setCity(city : string){
    this.city = city
  }

  public setPostcode(postcode : string){
    this.postcode = postcode
  }



  public checkout() {
    const bestelData = {
      products: this.ProductsCart,
      address: this.address,
      fullname: this.fullname,
      city: this.city,
      postcode: this.postcode
    };

    this.httpClient.post(
      'http://localhost:8080/api/bestelling/plaats',
      bestelData
    ).subscribe(
      response => {
        console.log("Checkout successful!", response);
      },
      error => {
        console.error("Error during checkout:", error);
      }
    );


  }




  public ProductsCart : Product[];

  public showcartinConsoleLog() {
    console.log(this.ProductsCart)
}


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

  public EmptyCartAfterCheckout() {
    this.ProductsCart = [];
    localStorage.setItem('productsCart', JSON.stringify(this.ProductsCart));
  }



}
