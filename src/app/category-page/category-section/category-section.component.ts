import { Component } from '@angular/core';
import {CategoryBlockComponent} from './category-block/category-block.component';
import {RouterLink} from '@angular/router';
import {TranslatePipe} from '@ngx-translate/core';

@Component({
  selector: 'app-category-section',
  imports: [
    CategoryBlockComponent,
    RouterLink,
    TranslatePipe
  ],
  templateUrl: './category-section.component.html',
  styleUrl: './category-section.component.scss'
})
export class CategorySectionComponent {

}
