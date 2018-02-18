import { Component, OnInit } from '@angular/core';
import { AcademicYear } from '../../models/Academicyear';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Router } from '@angular/router';
import { AcademicyearService } from '../../services/academicyear.service';
import 'rxjs/add/operator/toPromise';
import { School } from '../../models/school';
import {SchoolService } from '../../services/school.service';
import { Observable } from 'rxjs/Observable';
import { LoginService } from '../../services/login.service'; 
@Component({
  selector: 'app-add-academicyear',
  templateUrl: './add-academicyear.component.html',
  styleUrls: ['./add-academicyear.component.css']
})
export class AddAcademicyearComponent implements OnInit {
  private loggedIn = false;
 private academicAdded : boolean
 private academicyear : AcademicYear={
  id:0,
  academicname:'',
  year:'',
  school_id:0
 }  
private schools: Observable<School[]>;
  constructor(private flashMessagesService: FlashMessagesService,
    private router: Router, private academicService: AcademicyearService,
    private schoolService: SchoolService, private loginService: LoginService
  ) { }

  ngOnInit() {
    this.checkSession();
    this.academicAdded = false;
    this.getAllSchools();
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
  getAllSchools() {
    this.schools = this.schoolService.getAllSchool();

  }
  onSubmit({ value, valid }: { value: AcademicYear, valid: boolean }) {
    if (!valid) {
      this.flashMessagesService.show('Please fill the Academic Name', { cssClass: 'alert-danger', timeout: 4000 });
      this.router.navigate(['add-academic']);
    }
    else {

     // console.log(value.);
     // value.
      // this.academicyear.academicname = value.academicname;
      // this.academicyear.year = value.year;
      this.academicAdded = true;
       this.academicService.newAcademic(value);  
      this.flashMessagesService.show('New Academic Added', { cssClass: 'alert-success', timeout: 4000 });

      this.router.navigate(['/academiclist']);
    }
  }

}
