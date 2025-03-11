import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeaderComponent} from './header/header.component';
import {WelcomeScreenComponent} from './welcome-screen/welcome-screen.component';
import {ProductSectionComponent} from './product-section/product-section.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderComponent, WelcomeScreenComponent, ProductSectionComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Webshop';
}
