import {Component, Input} from '@angular/core';
import {ProductShowcaseComponent} from "../product-showcase/product-showcase.component";
import {DUMMY_PRODUCTS} from '../DUMMY_PRODUCTS';

@Component({
  selector: 'app-list-product-showcase',
  imports: [
    ProductShowcaseComponent
  ],
  templateUrl: './list-product-showcase.component.html',
  styleUrl: './list-product-showcase.component.scss'
})
export class ListProductShowcaseComponent {
  protected readonly DummyProducts = DUMMY_PRODUCTS;
}
