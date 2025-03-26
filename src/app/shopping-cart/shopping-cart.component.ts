import {Component, inject} from '@angular/core';
import {ShoppingCartSectionComponent} from './shopping-cart-section/shopping-cart-section.component';
import {ShoppingcartService} from '../services/shoppingcart.service';

@Component({
  selector: 'app-shopping-cart',
  imports: [
    ShoppingCartSectionComponent
  ],
  templateUrl: './shopping-cart.component.html',
  styleUrl: './shopping-cart.component.scss'
})
export class ShoppingCartComponent {

  protected shoppingcart = inject(ShoppingcartService)

}
