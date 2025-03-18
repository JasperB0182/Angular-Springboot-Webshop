import { Component } from '@angular/core';
import {CategoryBlockComponent} from './category-block/category-block.component';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-category-section',
  imports: [
    CategoryBlockComponent,
    RouterLink
  ],
  templateUrl: './category-section.component.html',
  styleUrl: './category-section.component.scss'
})
export class CategorySectionComponent {

}
