import {Component, Input} from '@angular/core';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-product-showcase',
  imports: [
    RouterLink
  ],
  templateUrl: './product-showcase.component.html',
  styleUrl: './product-showcase.component.scss'
})
export class ProductShowcaseComponent {
  @Input() productnaam: string = '';
  @Input() fotolocatie: string = '';
  @Input() productId: string = '';
}
