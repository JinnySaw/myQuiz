import { Component, OnInit } from '@angular/core';
import { School } from '../../models/school';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Router } from '@angular/router';
import { SchoolService } from '../../services/school.service';
import 'rxjs/add/operator/toPromise';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-add-school',
  templateUrl: './add-school.component.html',
  styleUrls: ['./add-school.component.css']
})
export class AddSchoolComponent implements OnInit {
  private loggedIn = false;
  school = new School;
  constructor(public flashMessagesService: FlashMessagesService,
    public router: Router, public schoolService: SchoolService,
    private loginService: LoginService
  ) { }

  ngOnInit() {
    this.checkSession();
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
  onSubmit({ value, valid }: { value: School, valid: boolean }) {
    if (!valid) {
      // console.log('onSubmit error');

      this.flashMessagesService.show('Please fill the School Name', { cssClass: 'alert-danger', timeout: 4000 });
      this.router.navigate(['add-school']);
    }
    else {
      
      this.schoolService.newSchool(value);  
      this.flashMessagesService.show('New School Added', { cssClass: 'alert-success', timeout: 4000 });

      this.router.navigate(['/school']);

    }
  }
}
