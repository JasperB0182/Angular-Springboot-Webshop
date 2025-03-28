import {Component, DestroyRef, inject, OnInit} from '@angular/core';
import {ProductShowcaseComponent} from "../product-showcase/product-showcase.component";
import {HttpClient} from '@angular/common/http';
import {Product} from '../../models/product-model';
import {LoginService} from '../../services/login.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-list-product-showcase',
  imports: [
    ProductShowcaseComponent
  ],
  templateUrl: './list-product-showcase.component.html',
  styleUrl: './list-product-showcase.component.scss',
})
export class ListProductShowcaseComponent implements OnInit{
  private httpClient = inject(HttpClient)
  private destroyRef = inject(DestroyRef)
  ShowcaseProducts: any;
  private LoginService = inject(LoginService)
  protected router = inject(Router)


  ngOnInit() {
    const subscription = this.httpClient.get<{Product : Product}>("http://localhost:8080/api/products").subscribe({
      next: (resData) => {
        this.ShowcaseProducts = resData;
      },
      error: (err : 401)=>{
        this.LoginService.resetToken();
        this.LoginService.loggedIn = false;


    }
    });

    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe();
    })


  }




}
