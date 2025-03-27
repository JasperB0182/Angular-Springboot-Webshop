import {Component, inject, OnInit} from '@angular/core';
import {ShoppingCartProductComponent} from './shopping-cart-product/shopping-cart-product.component';
import {ShoppingcartService} from '../../services/shoppingcart.service';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-shopping-cart-section',
  imports: [
    ShoppingCartProductComponent,
    RouterLink
  ],
  templateUrl: './shopping-cart-section.component.html',
  styleUrl: './shopping-cart-section.component.scss'
})
export class ShoppingCartSectionComponent implements OnInit{

  protected service = inject(ShoppingcartService);

  protected Products = this.service.ProductsCart

  ngOnInit() {
    this.service.CalculateTotalCost()
  }


}
