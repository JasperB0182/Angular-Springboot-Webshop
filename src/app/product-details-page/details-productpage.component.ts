import {Component, DestroyRef, inject, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Subscription} from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import {Product} from '../models/product-model';
import {FooterComponent} from '../global/footer/footer.component';
import {Location} from '@angular/common';
import {ShoppingcartService} from '../services/shoppingcart.service';
import {LoginService} from '../services/login.service';
import {environment} from '../../environments/environment';
import {TranslatePipe, TranslateService} from '@ngx-translate/core';

@Component({
  selector: 'app-product-details-page',
  imports: [
    FooterComponent,
    TranslatePipe
  ],
  templateUrl: './details-productpage.component.html',
  styleUrl: './details-productpage.component.scss'
})
export class DetailsProductpageComponent implements OnInit{
  protected translate = inject(TranslateService);
  private httpClient = inject(HttpClient)
  private destroyRef = inject(DestroyRef)
  protected shoppingcart = inject(ShoppingcartService);
  protected LoginService = inject(LoginService);
  Products: any;
  private routeSub!: Subscription;
  webId! : string;
  apiLink!: string;


  constructor(private route: ActivatedRoute, private location: Location) { }



  public get currentLanguage(): string {
    return this.translate.currentLang;
  }


  backClicked() {
    this.location.back();
  }


  ngOnInit() {
    this.routeSub = this.route.params.subscribe(params => {
      this.webId = params['id'];
      this.apiLink = environment.apiUrl +"/products/" + this.webId;


      const subscription = this.httpClient.get<{ Product: Product }>(this.apiLink).subscribe({
        next: (resData) => {
          this.Products = resData;

        },
        error: (error : 401) => {
          this.LoginService.resetToken();
          this.LoginService.loggedIn = false;
        }
      });


      this.destroyRef.onDestroy(() => {
        subscription.unsubscribe();
      });
    });
  }


}
