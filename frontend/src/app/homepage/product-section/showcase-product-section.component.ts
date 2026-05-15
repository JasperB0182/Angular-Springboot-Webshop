import { Component } from '@angular/core';
import {ListProductShowcaseComponent} from '../list-product-showcase/list-product-showcase.component';

@Component({
  selector: 'app-product-section',
  imports: [
    ListProductShowcaseComponent
  ],
  templateUrl: './showcase-product-section.component.html',
  styleUrl: './showcase-product-section.component.scss'
})
export class ShowcaseProductSectionComponent {

}
