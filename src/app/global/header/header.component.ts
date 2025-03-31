import {Component, inject} from '@angular/core';
import {NgOptimizedImage} from '@angular/common';
import {Router, RouterLink} from '@angular/router';
import {LoginService} from '../../services/login.service';
import {TranslatePipe, TranslateService} from '@ngx-translate/core';
import {AppComponent} from '../../app.component';
import {FormsModule} from '@angular/forms';
import {ProductOverviewComponent} from '../../product-overview/product-overview.component';


@Component({
  selector: 'app-header',
  imports: [
    RouterLink,
    TranslatePipe,
    FormsModule
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {

  protected search : string = "";

  protected translate = inject(TranslateService);

  protected router = inject(Router);

  protected LoginService = inject(LoginService);

  protected AppComponent = inject(AppComponent);


  protected useLanguage(language : string){
    this.AppComponent.useLanguage(language)
  }

  public get currentLanguage(): string {
    return this.translate.currentLang;
  }

  protected async zoekfunctie() {
    const searchstring: string = "/products/" + this.search;
    await this.router.navigate([searchstring]);


    await new Promise(resolve => setTimeout(resolve, 100));


    window.location.reload();
  }


}
