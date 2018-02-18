import { Component, OnInit } from '@angular/core';
import { School } from '../../models/school';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Router ,ActivatedRoute} from '@angular/router';
import { SchoolService } from '../../services/school.service';
import 'rxjs/add/operator/toPromise';
@Component({
  selector: 'app-edit-school',
  templateUrl: './edit-school.component.html',
  styleUrls: ['./edit-school.component.css']
})
export class EditSchoolComponent implements OnInit {

  private id: number;
  private school: School = new School();
  private schoolUpdated: boolean;

  constructor(private flashMessagesService:FlashMessagesService,
    private router:Router,public schoolService:SchoolService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    
    this.schoolService.getSchoolById(this.id).then(school=>{
      this.school = school;
    });
    
  }
  onSubmit({value,valid}:{value:School,valid:boolean}){
    var flashMessagesService = this.flashMessagesService;
    if(!valid){
      console.log('onSubmit error');
      
      this.flashMessagesService.show('Please fill the Title',{cssClass:'alert-danger', timeout:4000});
      this.router.navigate(['edit-school/'+ this.id]);
    }
    else{
      
      
       this.schoolService.updateSchool(this.id,value);
       this.flashMessagesService.show('School Updated',{cssClass:'alert-success',timeout:4000});
      
      this.router.navigate(['/school']);
    }

  }

}
