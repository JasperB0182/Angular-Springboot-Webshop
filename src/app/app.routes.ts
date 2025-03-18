import { Routes } from '@angular/router';
import {HomepageComponent} from './homepage/homepage.component';
import {CategoryComponent} from './CategoryPage/category.component';

export const routes: Routes = [
  {
    path: "",
    component: HomepageComponent
  },
  {
    path: "category",
    component: CategoryComponent
  }
];
