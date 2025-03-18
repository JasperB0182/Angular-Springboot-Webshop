import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-product-showcase',
  imports: [],
  templateUrl: './product-showcase.component.html',
  styleUrl: './product-showcase.component.scss'
})
export class ProductShowcaseComponent {
  @Input() productnaam: string = '';
  @Input() fotolocatie: string = '';
}
