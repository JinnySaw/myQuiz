import { Component, OnInit } from '@angular/core';
import { AcademicYear } from '../../models/Academicyear';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Router } from '@angular/router';
import { AcademicyearService } from '../../services/academicyear.service';
import 'rxjs/add/operator/toPromise';
import { School } from '../../models/school';
import {SchoolService } from '../../services/school.service';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-add-academicyear',
  templateUrl: './add-academicyear.component.html',
  styleUrls: ['./add-academicyear.component.css']
})
export class AddAcademicyearComponent implements OnInit {

 academicyear : AcademicYear={
  id:0,
  academicname:'',
  year:'',
  school_id:0
 }  
private schools: Observable<School[]>;
  constructor(public flashMessagesService: FlashMessagesService,
    public router: Router, public academicService: AcademicyearService,
    public schoolService: SchoolService
  ) { }

  ngOnInit() {
    this.getAllSchools();
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

       this.academicService.newAcademic(value);  
      this.flashMessagesService.show('New Academic Added', { cssClass: 'alert-success', timeout: 4000 });

      this.router.navigate(['/academiclist']);
    }
  }

}
