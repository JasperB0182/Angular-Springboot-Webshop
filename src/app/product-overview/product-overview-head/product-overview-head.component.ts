import { Component } from '@angular/core';
import {TranslatePipe} from "@ngx-translate/core";

@Component({
  selector: 'app-product-overview-head',
    imports: [
        TranslatePipe
    ],
  templateUrl: './product-overview-head.component.html',
  styleUrl: './product-overview-head.component.scss'
})
export class ProductOverviewHeadComponent {

}
