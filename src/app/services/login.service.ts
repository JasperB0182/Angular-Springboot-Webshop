import {inject, Injectable} from '@angular/core';
import {Login} from '../models/login-model';
import {HttpClient} from '@angular/common/http';
import {tap} from 'rxjs';
import {LoginResponse} from '../models/login-response-model';
import {Register} from '../models/register-model';
import {Router} from '@angular/router';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private router = inject(Router)
  private httpClient = inject(HttpClient)
  loggedIn = false;
  private token: string | null = null;
  protected api_link = environment.apiUrl

  public logOut(){
    this.resetToken();
    this.loggedIn = false;
    this.router.navigate(["/"])
  }

  public isLoggedIn() {
    return this.loggedIn;
  }

  public resetToken(){
    this.token = "";
    this.saveTokenInLocalStorage(this.token)
  }

  public getToken() {
    return this.token;
  }

  public login(login: Login) {
    const subscription = this.httpClient.post<LoginResponse>(
      (this.api_link + '/auth/login'),
      login
    ).pipe(
      tap(responseData => {
        if (responseData.token) {
          this.loggedIn = true;
          this.token = responseData.token;
          this.saveTokenInLocalStorage(responseData.token)
        }
      })
    );
    return subscription;
  }

  public register(login: Register) {
    const subscription = this.httpClient.post<LoginResponse>(
      (this.api_link + '/auth/register'),
      login
    ).pipe(
      tap(responseData => {
        if (responseData.token) {
          this.loggedIn = true;
          this.token = responseData.token;
          this.saveTokenInLocalStorage(responseData.token)
        }
      })
    );
    return subscription;
  }

  private saveTokenInLocalStorage(token: string) {
    localStorage.setItem('authToken', token)
  }

  private loadTokenFromLocalStorage() {
    this.token = localStorage.getItem('authToken')
  }

  constructor() {
    this.loadTokenFromLocalStorage();
    if (this.token != null) {
      this.loggedIn = true;
    }
  }
}
