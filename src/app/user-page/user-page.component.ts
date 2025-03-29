import {Component, DestroyRef, inject, OnInit} from '@angular/core';
import {LoginService} from '../services/login.service';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {UserDetails} from '../models/user.details.model';
import {TranslatePipe} from '@ngx-translate/core';

@Component({
  selector: 'app-user-page',
  imports: [
    TranslatePipe
  ],
  templateUrl: './user-page.component.html',
  styleUrl: './user-page.component.scss'
})
export class UserPageComponent implements OnInit{

  protected LoginService = inject(LoginService);

  protected router = inject(Router);

  protected httpClient = inject(HttpClient);

  public userDetail? : UserDetails;

  protected destroyRef = inject(DestroyRef);

  ngOnInit() {
    if (!this.LoginService.isLoggedIn()){
      this.router.navigate(["/login"]);
    }

    const subscription = this.httpClient.get<UserDetails>("http://localhost:8080/api/user/me").subscribe({
      next: (resData) => {
        this.userDetail = resData;

      },
      //401
      error: (error: 401) => {
        this.LoginService.resetToken();
        this.LoginService.loggedIn = false;
        this.router.navigate(["/login"]);
      }
    });

    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe();
    })
  }

}
