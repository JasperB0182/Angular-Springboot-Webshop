import { Component } from '@angular/core';
import {CategorySectionComponent} from './category-section/category-section.component';

@Component({
  selector: 'app-category-page',
  imports: [
    CategorySectionComponent
  ],
  templateUrl: './category.component.html',
  styleUrl: './category.component.scss'
})
export class CategoryComponent {

}
