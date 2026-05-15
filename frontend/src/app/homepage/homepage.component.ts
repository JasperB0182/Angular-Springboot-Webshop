import { Component } from '@angular/core';
import {ShowcaseProductSectionComponent} from "./product-section/showcase-product-section.component";
import {WelcomeScreenComponent} from "./welcome-screen/welcome-screen.component";
import {FooterComponent} from '../global/footer/footer.component';

@Component({
  selector: 'app-homepage',
  imports: [
    ShowcaseProductSectionComponent,
    WelcomeScreenComponent,
    FooterComponent
  ],
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.scss'
})
export class HomepageComponent {

}
