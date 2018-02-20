import { Component, OnInit } from '@angular/core';
import { Teacher } from '../../models/teacher';
import { TeacherService } from '../../services/teacher.service';
import { School } from '../../models/school';
import { SchoolService } from '../../services/school.service';
import { Observable } from 'rxjs/Observable';
import { LoginService } from '../../services/login.service';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-teacher',
  templateUrl: './add-teacher.component.html',
  styleUrls: ['./add-teacher.component.css']
})
export class AddTeacherComponent implements OnInit {

  private loggedIn = false;
  private schools: Observable<School[]>;
  private teacher: Teacher = new Teacher();
  private teacherAdded: boolean;	

  constructor(
    private teacherService: TeacherService, 
    private schoolService : SchoolService,
    private loginService: LoginService
  ) { }

  ngOnInit() {
    this.checkSession();
  	this.teacherAdded=false;
  }
  onSubmit() {
  	this.teacherService.newTeacher(this.teacher).subscribe(
  		res => {
  			
  			this.teacherAdded=true;
  			this.teacher = new Teacher(); 
  		},
  		error => {
  			console.log(error);
  		}
  	);
  }
  checkSession() {
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
}
