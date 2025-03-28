import {Component, DestroyRef, inject, Input, OnInit} from '@angular/core';
import {FooterComponent} from '../global/footer/footer.component';
import {ProductOverviewHeadComponent} from './product-overview-head/product-overview-head.component';
import {ProductOverviewCardComponent} from './product-overview-card/product-overview-card.component';
import {Product} from '../models/product-model';
import {HttpClient} from '@angular/common/http';
import {Subscription} from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import {LoginService} from '../services/login.service';
import {environment} from '../../environments/environment';

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
  private httpClient = inject(HttpClient)
  private destroyRef = inject(DestroyRef)
  Products: any;
  private routeSub!: Subscription;
  constructor(private route: ActivatedRoute) { }
  public test: string = '';
  protected api_link = ""
  protected LoginService = inject(LoginService)

  ngOnInit() {

    this.routeSub = this.route.params.subscribe(params => {
      this.test = params['id']
    });


    // 24-3-2025, ik besef me nu pas dat ik ook gewoon de category had kunnen pakken en daar de producten uit..... Jammer dit
    if (this.test == "videokaarten") {
      this.api_link = (environment.apiUrl + "/products/category/Videokaarten");
    } else if (this.test == "processoren") {
      this.api_link = (environment.apiUrl + "/products/category/Processoren");
    } else if (this.test == "moederborden") {
      this.api_link = (environment.apiUrl + "/products/category/Moederborden");
    } else {
      this.api_link = (environment.apiUrl + "/products");
    }


    //TODO: maak de error handling een funcite PLS
    const subscription = this.httpClient.get<{Product : Product}>(this.api_link).subscribe({
      next: (resData) => {
        this.Products = resData;
      },
      error: (err : 401) => {
        this.LoginService.resetToken();
        this.LoginService.loggedIn = false;
        window.location.reload()
      }
    });



    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe();
    })



  }

}
