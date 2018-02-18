import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private credential ={'username': '', 'password': ''};
  private loggedIn = false;
  constructor(private loginService: LoginService) { }

  onSubmit(){
    // this.loginService.sendCredential(this.credential.username,this.credential.password).subscribe(
    //  result =>{
    //   console.log(result);
    //   localStorage.setItem("xAuthToken",result.json().token);
    //   this.loggedIn = true;
    //    location.reload();
    //  },
    //  error =>{
    //     console.log(error);
        
    //  }
    // );
  }


  ngOnInit() { 
  this.loggedIn = true; // need to comment this after remove Session commented
    // this.loginService.checkSession().subscribe(
    //   result => {
    //     this.loggedIn = true;
    //   },
    //   error => {
    //     this.loggedIn = false;
    //   }
    // );
  }

}
