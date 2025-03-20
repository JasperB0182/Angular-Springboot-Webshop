import { Routes } from '@angular/router';
import {HomepageComponent} from './homepage/homepage.component';
import {CategoryComponent} from './CategoryPage/category.component';
import {ProductOverviewComponent} from './product-overview/product-overview.component';
import {DetailsProductpageComponent} from './details-productpage/details-productpage.component';
import {ShoppingCartComponent} from './shopping-cart/shopping-cart.component';

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
  },
  {
    path: "products/alles/:id",
    component: DetailsProductpageComponent
  },
  {
    path: "shopping-cart",
    component: ShoppingCartComponent
  }

];
