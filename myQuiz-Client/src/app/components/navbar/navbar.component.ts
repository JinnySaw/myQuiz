import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  private loggedIn = false;
  constructor(private loginService: LoginService,
  private router: Router) { }

  ngOnInit() {
    this.loginService.checkSession().subscribe(
      result => {
        this.loggedIn = true;
      },
      error => {
        this.loggedIn = false;
      }
    );
  }
  logout(){
    this.loginService.logout().subscribe(
      result =>{
        location.reload();
      },
      error=>{
        console.log(error);
        
      }
    );
    this.router.navigate(['/']);
  }

}
