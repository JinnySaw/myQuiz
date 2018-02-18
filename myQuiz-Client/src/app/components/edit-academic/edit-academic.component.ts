import { Component, OnInit } from '@angular/core';
import { AcademicYear } from '../../models/Academicyear';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Router,ActivatedRoute, Params } from '@angular/router';
import { AcademicyearService } from '../../services/academicyear.service';
import 'rxjs/add/operator/toPromise';
import { School } from '../../models/school';
import {SchoolService } from '../../services/school.service';
import { Observable } from 'rxjs/Observable';
import { Academic} from '../../models/academic';

@Component({
  selector: 'app-edit-academic',
  templateUrl: './edit-academic.component.html',
  styleUrls: ['./edit-academic.component.css']
})
export class EditAcademicComponent implements OnInit {
  private id: number;
  private academicYear : AcademicYear={
    id:0,
    academicname:'',
    year:'',
    school_id:0
   } 
   private academic: Academic =new Academic();
   private schools: Observable<School[]>;
  private quizUpdated: boolean;
  // private School = new School;
   school: School =new School();
  constructor(public flashMessagesService: FlashMessagesService,
    public router: Router, public academicService: AcademicyearService,
    public schoolService: SchoolService,
    private route: ActivatedRoute) { } 
  result : any;
  ngOnInit() {
    this.getAllSchools();
    this.id = this.route.snapshot.params['id'];

    // console.log(this.id);
    this.academicService.getAcademicById(this.id).subscribe(academic=>{
      // console.log(academic);
       
     this.school= academic.school; 
     this.academic = academic; 
     this.academicYear.academicname = this.academic.academicname;
     this.academicYear.id = this.academic.id;
     this.academicYear.year = this.academic.year;
     this.academicYear.school_id = this.academic.school.id;
    // console.log(this.academic); 
    // console.log(this.school);
    }); 
 
    // console.log(this.school);
  }
  getAllSchools() {
    this.schools = this.schoolService.getAllSchool();

  }
  onSubmit({value,valid}:{value:AcademicYear,valid:boolean}){
    var flashMessagesService = this.flashMessagesService;
    if(!valid){
      console.log('onSubmit error');
      
      this.flashMessagesService.show('Please fill the data',{cssClass:'alert-danger', timeout:4000});
      this.router.navigate(['edit-academic/'+ this.id]);
    }
    else{
      console.log("Schooid" +value);
      
      // this.academicYear = value;
      // this.academicYear.academicname = value.academicname;
      // this.academicYear.id = value.id;
      // this.academicYear.year = value.year;
      // this.academicYear.school_id = value.school.id;
      // this.academic.school = value.school
      // console.log("adddddd ... "+value.academicname + " aca .." + this.academicYear);
      this.academicService.updateAcademic(this.id,value);
       this.flashMessagesService.show('Academic Updated',{cssClass:'alert-success',timeout:4000});
     
      this.router.navigate(['/academiclist']);
    }

  }

}
