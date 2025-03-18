import { Routes } from '@angular/router';
import {HomepageComponent} from './homepage/homepage.component';
import {CategoryComponent} from './CategoryPage/category.component';
import {ProductOverviewComponent} from './product-overview/product-overview.component';

export const routes: Routes = [
  {
    path: "",
    component: HomepageComponent
  },
  {
    path: "products",
    component: CategoryComponent
  },
  {
    path: "products/:id",
    component: ProductOverviewComponent
  }

];
