import {inject, Injectable} from '@angular/core';
import {Product} from '../models/product-model';
import Swal from 'sweetalert2'
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {TranslateService} from '@ngx-translate/core';


@Injectable({
  providedIn: 'root'
})
export class ShoppingcartService{
  public totalCost : number = 0;
  public ProductsCart : Product[];
  protected httpClient = inject(HttpClient);
  protected translate = inject(TranslateService);
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

  public get currentLanguage(): string {
    return this.translate.currentLang;
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
      (environment.apiUrl + '/bestelling/plaats'),
      bestelData
    ).subscribe(
      );


  }


  public CalculateTotalCost() {
    this.totalCost = 0;
    for(let i=0; i<this.ProductsCart.length; i++){
      this.totalCost += this.ProductsCart[i].prijs * this.ProductsCart[i].aantalInWinkelwagen;
    }
  }


  public AddToCart(Product : Product){
    const stringified = JSON.stringify(this.ProductsCart)
    if (stringified.includes(Product.productNaam)){
      let index = this.ProductsCart.findIndex((e) => e.productId === Product.productId)
      this.ProductsCart[index].aantalInWinkelwagen += 1;
      localStorage.setItem('productsCart', JSON.stringify(this.ProductsCart));
      this.addedtocartnotif()
    } else {
    this.ProductsCart.push(Product)
    localStorage.setItem('productsCart', JSON.stringify(this.ProductsCart));
    this.addedtocartnotif()
    }
  }

  public RemoveFromCart(productNaam : string){
    const index = this.ProductsCart.findIndex(Product => Product.productNaam === productNaam)
    this.ProductsCart.splice(index, 1)
    localStorage.setItem('productsCart', JSON.stringify(this.ProductsCart))
    window.location.reload()
  }

  public EmptyCart(){
    this.ProductsCart = [];
    localStorage.setItem('productsCart', JSON.stringify(this.ProductsCart));
    location.reload()
  }

  protected addedtocartnotif(){
    if (this.currentLanguage == "en"){
      Swal.fire({
        title: "Success!",
        text: "Items succesfully added to cart",
        icon: "success"
      })
    } else {
      Swal.fire({
        title: "Succes!",
        text: "Items zijn toegevoegd aan de winkelwagen.",
        icon: "success"
      })
    }
  }

  public EmptyCartAfterCheckout() {
    this.ProductsCart = [];
    localStorage.setItem('productsCart', JSON.stringify(this.ProductsCart));
  }



}
