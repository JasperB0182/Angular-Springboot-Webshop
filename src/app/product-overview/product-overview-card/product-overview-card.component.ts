import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-product-overview-card',
  imports: [],
  templateUrl: './product-overview-card.component.html',
  styleUrl: './product-overview-card.component.scss'
})
export class ProductOverviewCardComponent {
  @Input() productnaam : string = '';
  @Input() productimg : string = '';

}
