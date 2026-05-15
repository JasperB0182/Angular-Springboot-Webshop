import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeaderComponent} from './global/header/header.component';
import {TranslateModule, TranslateService} from '@ngx-translate/core';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderComponent, TranslateModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Webshop';
  constructor(public translate: TranslateService) {
    this.translate.addLangs(['nl', 'en']);
    this.translate.setDefaultLang('nl');
    this.translate.use('nl');
  }

  public useLanguage(language: string): void {
    this.translate.use(language);
  }
}
