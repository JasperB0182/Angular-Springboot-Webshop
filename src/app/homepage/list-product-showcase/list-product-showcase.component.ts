import {Component, DestroyRef, inject} from '@angular/core';
import {ProductShowcaseComponent} from "../product-showcase/product-showcase.component";
import {HttpClient} from '@angular/common/http';
import {Product} from '../models/product-model';

@Component({
  selector: 'app-list-product-showcase',
  imports: [
    ProductShowcaseComponent
  ],
  templateUrl: './list-product-showcase.component.html',
  styleUrl: './list-product-showcase.component.scss',
})
export class ListProductShowcaseComponent {
  private httpClient = inject(HttpClient)
  private destroyRef = inject(DestroyRef)
  ShowcaseProducts: any;


  ngOnInit() {
    const subscription = this.httpClient.get<{Product : Product}>("http://localhost:8080/api/products").subscribe({
      next: (resData) => {
        this.ShowcaseProducts = resData;
      }
    });

    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe();
    })


  }




}
