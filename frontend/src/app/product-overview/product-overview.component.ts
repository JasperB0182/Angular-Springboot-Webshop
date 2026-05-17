import {Component, DestroyRef, inject, OnInit} from '@angular/core';
import {FooterComponent} from '../global/footer/footer.component';
import {ProductOverviewHeadComponent} from './product-overview-head/product-overview-head.component';
import {ProductOverviewCardComponent} from './product-overview-card/product-overview-card.component';
import {Product} from '../models/product-model';
import {HttpClient} from '@angular/common/http';
import {Subscription} from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import {LoginService} from '../services/login.service';
import {environment} from '../../environments/environment';
import {TranslateService} from '@ngx-translate/core';


@Component({
  selector: 'app-product-overview',
  imports: [
    FooterComponent,
    ProductOverviewHeadComponent,
    ProductOverviewCardComponent,
  ],
  templateUrl: './product-overview.component.html',
  styleUrl: './product-overview.component.scss'
})
export class ProductOverviewComponent implements OnInit{
  protected translate = inject(TranslateService);
  private httpClient = inject(HttpClient)
  private destroyRef = inject(DestroyRef)
  Products!: Product[];
  private routeSub!: Subscription;
  public urlParameter: string = '';
  protected api_link = ""
  protected LoginService = inject(LoginService)


  constructor(private route: ActivatedRoute) { }

  ngOnInit() {

    this.routeSub = this.route.params.subscribe(params => {
      this.urlParameter = params['id']
    });


    if (this.urlParameter == "videokaarten") {
      this.api_link = (environment.apiUrl + "/products/category/Videokaarten");
    } else if (this.urlParameter == "processoren") {
      this.api_link = (environment.apiUrl + "/products/category/Processoren");
    } else if (this.urlParameter == "moederborden") {
      this.api_link = (environment.apiUrl + "/products/category/Moederborden");
    } else if (this.urlParameter == "alles") {
      this.api_link = (environment.apiUrl + "/products");
    } else {
      this.api_link = (environment.apiUrl + "/products/search/" + this.urlParameter);
    }


    const subscription = this.httpClient.get<Product[]>(this.api_link).subscribe({
      next: (resData) => {
        this.Products = resData;
      },
      error: () => {
        this.LoginService.resetToken();
        this.LoginService.loggedIn = false;
      }
    });



    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe();
    })



  }

  public get currentLanguage(): string {
    return this.translate.currentLang;
  }

}
