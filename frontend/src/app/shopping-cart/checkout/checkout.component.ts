import {Component, DestroyRef, inject, OnInit} from '@angular/core';
import {ShoppingcartService} from '../../services/shoppingcart.service';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';
import {LoginService} from '../../services/login.service';
import {UserDetails} from '../../models/user.details.model';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {TranslatePipe, TranslateService} from '@ngx-translate/core';

@Component({
  selector: 'app-checkout',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    TranslatePipe
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
  protected zipcode = ""
  protected httpClient = inject(HttpClient);
  protected userDetail? : UserDetails;
  protected destroyRef = inject(DestroyRef)
  protected translate = inject(TranslateService);

  ngOnInit() {
    const subscription = this.httpClient.get<UserDetails>(environment.apiUrl + "/user/me").subscribe({
      next: (resData) => {
        this.userDetail = resData;

      },
      //401
      error: (error: 401) => {
        this.LoginService.resetToken();
        this.LoginService.loggedIn = false;
        this.router.navigate(["/login"]);
      }
    });

    this.shoppingcart.CalculateTotalCost()

    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe();
    })
  }

  checkout() {
    this.shoppingcart.setAddress(this.address)
    this.shoppingcart.setFullname(this.fullname)
    this.shoppingcart.setCity(this.city)
    this.shoppingcart.setzipcode(this.zipcode.replace(" ", ""))
    this.shoppingcart.checkout()
    this.router.navigate(['/']);
    if (this.currentLanguage == "nl") {
      Swal.fire({
        title: "Succes!",
        text: "Items zijn succesvol besteld! Ga naar je account pagina om je bestelling te bekijken.",
        icon: "success"
      })
    } else {
      Swal.fire({
        title: "Success!",
        text: "Items have been successfully ordered! Go to your account page to view your order.",
        icon: "success"
      })
    }
    this.shoppingcart.EmptyCartAfterCheckout()
  }

  public get currentLanguage(): string {
    return this.translate.currentLang;
  }


}
