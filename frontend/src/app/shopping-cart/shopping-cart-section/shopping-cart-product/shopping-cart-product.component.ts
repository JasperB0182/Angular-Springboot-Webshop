import {Component, inject, Input} from '@angular/core';
import {ShoppingcartService} from '../../../services/shoppingcart.service';

@Component({
  selector: 'app-shopping-cart-product',
  imports: [],
  templateUrl: './shopping-cart-product.component.html',
  styleUrl: './shopping-cart-product.component.scss'
})
export class ShoppingCartProductComponent {
  @Input() productNaam! : string;
  @Input() productImg! : string;
  @Input() productPrijs! : number;
  @Input() productWinkelwagen! : number;

  protected shoppingcartService = inject(ShoppingcartService)

  protected removefromcart(){
    this.shoppingcartService.RemoveFromCart(this.productNaam)
  }


}
