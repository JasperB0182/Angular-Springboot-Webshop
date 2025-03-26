import { Routes } from '@angular/router';
import {HomepageComponent} from './homepage/homepage.component';
import {CategoryComponent} from './CategoryPage/category.component';
import {ProductOverviewComponent} from './product-overview/product-overview.component';
import {DetailsProductpageComponent} from './details-productpage/details-productpage.component';
import {ShoppingCartComponent} from './shopping-cart/shopping-cart.component';
import {LoginComponent} from './login/login.component';
import {UserPageComponent} from './user-page/user-page.component';
import {RegisterComponent} from './register/register.component';

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
  },
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "register",
    component: RegisterComponent
  },
  {
    path: "user",
    component: UserPageComponent
  }

];
