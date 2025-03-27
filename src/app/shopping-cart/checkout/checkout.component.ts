import {Component, inject, OnInit} from '@angular/core';
import {ShoppingcartService} from '../../services/shoppingcart.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';
import {LoginService} from '../../services/login.service';

@Component({
  selector: 'app-checkout',
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './checkout.component.html',
  styleUrl: './checkout.component.scss'
})
export class CheckoutComponent implements OnInit{

  protected shoppingcart = inject(ShoppingcartService);

  protected router = inject(Router)

  protected LoginService = inject(LoginService)

  protected address = ""
  protected fullname = ""
  protected city = ""
  protected postcode = ""

  ngOnInit() {
    if (!this.LoginService.isLoggedIn()){
      this.router.navigate(['/login']);
    }
    this.shoppingcart.CalculateTotalCost()
  }

  checkout() {
    this.shoppingcart.setAddress(this.address)
    this.shoppingcart.setFullname(this.fullname)
    this.shoppingcart.setCity(this.city)
    this.shoppingcart.setPostcode(this.postcode)
    this.shoppingcart.checkout()
    this.router.navigate(['/user']);
    Swal.fire({
      title: "Succes!",
      text: "Items zijn succesvol besteld!",
      icon: "success"
    })

  }


}
