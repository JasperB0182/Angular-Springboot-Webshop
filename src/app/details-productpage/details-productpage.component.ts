import {Component, DestroyRef, inject, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Subscription} from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import {Product} from '../models/product-model';
import {FooterComponent} from '../global/footer/footer.component';
import {Location} from '@angular/common';
import {ShoppingcartService} from '../services/shoppingcart.service';
import {LoginService} from '../services/login.service';

@Component({
  selector: 'app-details-productpage',
  imports: [
    FooterComponent
  ],
  templateUrl: './details-productpage.component.html',
  styleUrl: './details-productpage.component.scss'
})
export class DetailsProductpageComponent implements OnInit{
  private httpClient = inject(HttpClient)
  private destroyRef = inject(DestroyRef)
  Products: any;
  private routeSub!: Subscription;
  constructor(private route: ActivatedRoute, private location: Location) { }
  webId : any;
  apiLink!: string;
  protected shoppingcart = inject(ShoppingcartService);
  protected LoginService = inject(LoginService);


  backClicked() {
    this.location.back();
  }


  ngOnInit() {
    this.routeSub = this.route.params.subscribe(params => {
      this.webId = params['id'];
      this.apiLink = "http://localhost:8080/api/products/" + this.webId;


      const subscription = this.httpClient.get<{ Product: Product }>(this.apiLink).subscribe({
        next: (resData) => {
          this.Products = resData;

        },
        error: (error : 401) => {
          this.LoginService.resetToken();
          this.LoginService.loggedIn = false;
          window.location.reload()
        }
      });

      this.destroyRef.onDestroy(() => {
        subscription.unsubscribe();
      });
    });
  }


}
