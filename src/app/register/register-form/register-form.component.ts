import {Component, inject, OnInit} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {LoginService} from '../../services/login.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register-form',
    imports: [
        FormsModule,
        ReactiveFormsModule
    ],
  templateUrl: './register-form.component.html',
  styleUrl: './register-form.component.scss'
})
export class RegisterFormComponent implements OnInit{

  protected voornaam : string = "";
  protected email : string = "";
  protected password : string = "";

  protected loginService = inject(LoginService);
  protected router = inject(Router);

  protected register() {
    const registerData = {email: this.email, password : this.password, voornaam: this.voornaam}
    this.loginService.register(registerData).subscribe({
      next: (responseData) =>{
        this.router.navigate(["/user"]);
      },
      error: (error) => {
        if (error.status == 403){
          //To redirect back to login page
          this.router.navigate(["/register"])
        }
      }
    })
  }

  ngOnInit(){
    if (this.loginService.isLoggedIn()){
      this.router.navigate(["user"]);
    }
  }

}
