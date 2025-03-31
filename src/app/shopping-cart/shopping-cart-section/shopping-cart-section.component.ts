import {Component, DestroyRef, inject, OnInit} from '@angular/core';
import {ShoppingCartProductComponent} from './shopping-cart-product/shopping-cart-product.component';
import {ShoppingcartService} from '../../services/shoppingcart.service';
import {Router, RouterLink} from '@angular/router';
import {TranslatePipe} from '@ngx-translate/core';
import {UserDetails} from '../../models/user.details.model';
import {environment} from '../../../environments/environment';
import {LoginService} from '../../services/login.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-shopping-cart-section',
  imports: [
    ShoppingCartProductComponent,
    RouterLink,
    TranslatePipe
  ],
  templateUrl: './shopping-cart-section.component.html',
  styleUrl: './shopping-cart-section.component.scss'
})
export class ShoppingCartSectionComponent implements OnInit{

  protected destroyRef = inject(DestroyRef)

  protected shoppingcart = inject(ShoppingcartService);

  protected Products = this.shoppingcart.ProductsCart

  protected LoginService = inject(LoginService)

  protected router = inject(Router)

  protected httpClient = inject(HttpClient)

  ngOnInit() {
    this.shoppingcart.CalculateTotalCost()

    const subscription = this.httpClient.get<UserDetails>(environment.apiUrl + "/user/me").subscribe({
      next: (resData) => {
      },
      error: () => {
        this.LoginService.resetToken();
        this.LoginService.loggedIn = false;
        this.router.navigate(["/login"]);
      }
    })

    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe();
    })
  }




}
