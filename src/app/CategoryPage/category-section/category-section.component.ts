import { Component } from '@angular/core';
import {CategoryBlockComponent} from './category-block/category-block.component';

@Component({
  selector: 'app-category-section',
  imports: [
    CategoryBlockComponent
  ],
  templateUrl: './category-section.component.html',
  styleUrl: './category-section.component.scss'
})
export class CategorySectionComponent {

}
