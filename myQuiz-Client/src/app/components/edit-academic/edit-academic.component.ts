import { Component, OnInit } from '@angular/core';
import { AcademicYear } from '../../models/Academicyear';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { AcademicyearService } from '../../services/academicyear.service';
import 'rxjs/add/operator/toPromise';
import { School } from '../../models/school';
import { SchoolService } from '../../services/school.service';
import { Observable } from 'rxjs/Observable';
import { Academic } from '../../models/academic';
import { LoginService } from '../../services/login.service';
import { FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-academic',
  templateUrl: './edit-academic.component.html',
  styleUrls: ['./edit-academic.component.css']
})
export class EditAcademicComponent implements OnInit {
  scholControl = new FormControl(undefined, [Validators.required]);
  private loggedIn = false;
  private id: number;
  private academicYear: AcademicYear = {
    id: 0,
    academicname: '',
    year: '',
    school_id: 0
  }
  private academic: Academic = new Academic();
  private schools: Observable<School[]>;
  private quizUpdated: boolean;
  // private School = new School;
  school: School = new School();
  private selected = '';
  constructor(public flashMessagesService: FlashMessagesService,
    public router: Router, public academicService: AcademicyearService,
    public schoolService: SchoolService,
    private route: ActivatedRoute,
    private loginService: LoginService) { }
  result: any;
  ngOnInit() {
    this.checkSession();
    this.getAllSchools();
    this.id = this.route.snapshot.params['id'];

    // console.log(this.id);
    this.academicService.getAcademicById(this.id).subscribe(academic => {

      this.school = academic.school;
      this.selected = this.school.id.toString();
      this.academic = academic;
      this.academicYear.academicname = this.academic.academicname;
      this.academicYear.id = this.academic.id;
      this.academicYear.year = this.academic.year;
      this.academicYear.school_id = this.academic.school.id;

      // console.log(this.selected);
    });
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
  onSubmit({ value, valid }: { value: AcademicYear, valid: boolean }) {
    var flashMessagesService = this.flashMessagesService;
    if (!valid) {
      console.log('onSubmit error');

      this.flashMessagesService.show('Please fill the data', { cssClass: 'alert-danger', timeout: 4000 });
      this.router.navigate(['edit-academic/' + this.id]);
    }
    else {

      this.academicService.updateAcademic(this.id, value);
      this.flashMessagesService.show('Academic Updated', { cssClass: 'alert-success', timeout: 4000 });

      this.router.navigate(['/academiclist']);
    }

  }

}
