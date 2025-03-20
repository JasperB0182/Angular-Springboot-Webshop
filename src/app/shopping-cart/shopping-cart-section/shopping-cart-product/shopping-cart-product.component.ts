import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-shopping-cart-product',
  imports: [],
  templateUrl: './shopping-cart-product.component.html',
  styleUrl: './shopping-cart-product.component.scss'
})
export class ShoppingCartProductComponent {
  @Input() productNaam? : string;
  @Input() productImg? : string;
  @Input() productPrijs? : number;

}
