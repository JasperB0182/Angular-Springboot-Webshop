import { Component } from '@angular/core';
import {HeaderComponent} from '../global/header/header.component';
import {FooterComponent} from '../global/footer/footer.component';
import {CategorySectionComponent} from './category-section/category-section.component';

@Component({
  selector: 'app-CategoryPage',
  imports: [
    FooterComponent,
    CategorySectionComponent
  ],
  templateUrl: './category.component.html',
  styleUrl: './category.component.scss'
})
export class CategoryComponent {

}
