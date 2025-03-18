import {Component, Input, numberAttribute} from '@angular/core';

@Component({
  selector: 'app-product-overview-card',
  imports: [],
  templateUrl: './product-overview-card.component.html',
  styleUrl: './product-overview-card.component.scss'
})
export class ProductOverviewCardComponent {
  @Input() productnaam : string = '';
  @Input() productimg : string = '';
  @Input() productbrandimg : string = '';
  @Input({transform: numberAttribute}) productprijs : number = 0;

}
