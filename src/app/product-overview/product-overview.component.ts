import {Component, DestroyRef, inject, Input, OnInit} from '@angular/core';
import {HeaderComponent} from '../global/header/header.component';
import {FooterComponent} from '../global/footer/footer.component';
import {ProductOverviewHeadComponent} from './product-overview-head/product-overview-head.component';
import {ProductOverviewCardComponent} from './product-overview-card/product-overview-card.component';
import {Product} from '../models/product-model';
import {HttpClient} from '@angular/common/http';
import {ProductShowcaseComponent} from '../homepage/product-showcase/product-showcase.component';
import {Subscription} from 'rxjs';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-product-overview',
  imports: [
    HeaderComponent,
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
  public APIlink: string = '';

  ngOnInit() {

    this.routeSub = this.route.params.subscribe(params => {
      this.test = params['id']
    });

    if (this.test == "videokaarten") {
      this.APIlink = "http://localhost:8080/api/products/category/Videokaarten";
    } else if (this.test == "processoren") {
      this.APIlink = "http://localhost:8080/api/products/category/Processoren";
    } else if (this.test == "moederborden") {
      this.APIlink = "http://localhost:8080/api/products/category/Moederborden";
    } else {
      this.APIlink = "http://localhost:8080/api/products";
    }

    const subscription = this.httpClient.get<{Product : Product}>(this.APIlink).subscribe({
      next: (resData) => {
        this.Products = resData;
      }
    });



    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe();
    })



  }

}
