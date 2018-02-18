import { Component, OnInit } from '@angular/core';
import { AcademicYear } from '../../models/academicyear';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { Http } from '@angular/http';
import { AcademicyearService } from '../../services/academicyear.service';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Observable } from 'rxjs/Observable'; 
import {AppConst} from '../../constants/app-const';
import { LoginService } from '../../services/login.service';


@Component({
  selector: 'app-academicyear',
  templateUrl: './academicyear.component.html',
  styleUrls: ['./academicyear.component.css']
})
export class AcademicyearComponent implements OnInit {

  private loggedIn = false;
  private serverApiPath = AppConst.serverApiPath;
  private dataFetched = false;
  private loginError: boolean; 
  private credential={'username':'','password':''}
  private academicyears: Observable<any[]>;
  
  constructor(private academicyearService: AcademicyearService,
    private router: Router,
    private http: Http,
    private flashMessagesService: FlashMessagesService,
    private loginService: LoginService
  ) { }

  ngOnInit() {

    this.checkSession();
    this.getAllAcademic();
  }
  checkSession(){
    this.loginService.checkSession().subscribe(
      result => {
        this.loggedIn = true;
      },
      error => {
        this.loggedIn = false;
      }
    );
  }
  getAllAcademic(){
    console.log("get all Academic");
    
   this.academicyears =this.academicyearService.getAllAcademic();
  //  this.academicyearService.getAllAcademic().subscribe(
  //   res => {
  //         this.academicyears = JSON.parse(JSON.parse(JSON.stringify(res))._body);
  //       },
  //       error => console.log(error)
  // )
  // console.log(this.academicyears.);
  
  }
  
  onDeleteClick(id: number) {
    if (confirm("Are you sure to delete?")) {
      this.academicyearService.deleteAcademic(id);
      this.flashMessagesService.show("Academic Deleted", { cssClass: 'alert-success', timeout: 4000 });
      this.router.navigate(['/academic']);
    }
  }
}
