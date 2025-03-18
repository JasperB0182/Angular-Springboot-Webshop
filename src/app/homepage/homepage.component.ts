import { Component } from '@angular/core';
import {HeaderComponent} from "../global/header/header.component";
import {ShowcaseProductSectionComponent} from "./product-section/showcase-product-section.component";
import {WelcomeScreenComponent} from "./welcome-screen/welcome-screen.component";
import {FooterComponent} from '../global/footer/footer.component';

@Component({
  selector: 'app-homepage',
  imports: [
    HeaderComponent,
    ShowcaseProductSectionComponent,
    WelcomeScreenComponent,
    FooterComponent
  ],
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.scss'
})
export class HomepageComponent {

}
