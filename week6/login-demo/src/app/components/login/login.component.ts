import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';

  constructor(private authServ: AuthService, private router:Router) { }

  ngOnInit(): void {
  }

  login(){
    this.authServ.login(this.username, this.password).subscribe(
      response =>{
        console.log(response);
        // Have to define logic if not successful.. etc
        this.router.navigate(['dashboard']);
      },
      err =>{
        console.log('In error block! err: ' + err );
      },
      () => {
        console.log("Observable is complete!");
      }
    )
  }
}
