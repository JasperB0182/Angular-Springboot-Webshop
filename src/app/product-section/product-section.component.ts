import { Component } from '@angular/core';
import {ProductShowcaseComponent} from '../product-showcase/product-showcase.component';
import {ListProductShowcaseComponent} from '../list-product-showcase/list-product-showcase.component';

@Component({
  selector: 'app-product-section',
  imports: [
    ListProductShowcaseComponent
  ],
  templateUrl: './product-section.component.html',
  styleUrl: './product-section.component.scss'
})
export class ProductSectionComponent {

}
