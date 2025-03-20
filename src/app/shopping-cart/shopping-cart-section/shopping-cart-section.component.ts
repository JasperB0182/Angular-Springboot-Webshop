import {Component, inject} from '@angular/core';
import {ShoppingCartProductComponent} from './shopping-cart-product/shopping-cart-product.component';
import {ShoppingcartService} from '../../services/shoppingcart.service';

@Component({
  selector: 'app-shopping-cart-section',
  imports: [
    ShoppingCartProductComponent
  ],
  templateUrl: './shopping-cart-section.component.html',
  styleUrl: './shopping-cart-section.component.scss'
})
export class ShoppingCartSectionComponent {

  protected service = inject(ShoppingcartService);

  protected Products = this.service.ProductsCart



}
