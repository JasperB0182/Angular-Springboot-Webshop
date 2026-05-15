import {Component, inject, OnInit} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {LoginService} from '../../services/login.service';
import {Router} from '@angular/router';
import {TranslatePipe} from '@ngx-translate/core';

@Component({
  selector: 'app-login-form',
  imports: [
    FormsModule,
    TranslatePipe
  ],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.scss'
})
export class LoginFormComponent implements OnInit {

  protected email : string = "";
  protected password : string = "";

  protected loginService = inject(LoginService);
  protected router = inject(Router);

  ngOnInit(){
    if (this.loginService.isLoggedIn()){
      this.router.navigate(["user"]);
    }
  }

  protected login(){
    const loginData = {email: this.email, password : this.password}
    this.loginService.login(loginData).subscribe({
      next: (responseData) =>{
        this.router.navigate(["user"]);
      },
      error: (error) => {
        if (error.status == 403){
          console.log("error")
        }
      }
    })

  }

}
