import { Component, OnInit } from '@angular/core';
import { School } from '../../models/school';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { Http } from '@angular/http';
import { SchoolService } from '../../services/school.service';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Observable } from 'rxjs/Observable';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-schools',
  templateUrl: './schools.component.html',
  styleUrls: ['./schools.component.css']
})
export class SchoolsComponent implements OnInit {
  private loggedIn = false;
  private schools: Observable<School[]>;
  constructor(private schoolService: SchoolService,
    private router: Router,
    private http: Http,
    private flashMessagesService: FlashMessagesService,
    private loginService: LoginService
  ) { }

  ngOnInit() {
    this.checkSession();
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
  onDeleteClick(id: number) {
    if (confirm("Are you sure to delete?")) {
      this.schoolService.deleteSchool(id);
      this.flashMessagesService.show("School Deleted", { cssClass: 'alert-success', timeout: 4000 });
      this.router.navigate(['/school']);
    }
  }

}
