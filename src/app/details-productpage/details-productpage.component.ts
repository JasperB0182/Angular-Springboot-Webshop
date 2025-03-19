import {Component, DestroyRef, inject, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Subscription} from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import {Product} from '../models/product-model';
import {HeaderComponent} from '../global/header/header.component';
import {FooterComponent} from '../global/footer/footer.component';
import {Location} from '@angular/common';

@Component({
  selector: 'app-details-productpage',
  imports: [
    HeaderComponent,
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
        error: (error) => {
          console.error("API Error:", error);
        }
      });

      this.destroyRef.onDestroy(() => {
        subscription.unsubscribe();
      });
    });
  }


}
