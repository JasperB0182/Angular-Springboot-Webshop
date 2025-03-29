import {Component, inject} from '@angular/core';
import {NgOptimizedImage} from '@angular/common';
import {RouterLink} from '@angular/router';
import {LoginService} from '../../services/login.service';
import {TranslatePipe, TranslateService} from '@ngx-translate/core';
import {AppComponent} from '../../app.component';


@Component({
  selector: 'app-header',
  imports: [
    RouterLink,
    TranslatePipe
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {

  protected translate = inject(TranslateService);

  protected LoginService = inject(LoginService);

  protected AppComponent = inject(AppComponent);

  protected useLanguage(language : string){
    this.AppComponent.useLanguage(language)
  }

  public get currentLanguage(): string {
    return this.translate.currentLang;
  }


}
