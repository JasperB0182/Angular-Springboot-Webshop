import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-category-block',
  imports: [],
  templateUrl: './category-block.component.html',
  styleUrl: './category-block.component.scss'
})
export class CategoryBlockComponent {
  @Input() categorieNaam: string = '';
  @Input() ImgLocatie: string = '';
}
