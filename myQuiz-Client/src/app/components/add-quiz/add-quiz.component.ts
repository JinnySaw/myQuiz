import { Component, OnInit } from '@angular/core';
import { Quiz } from '../../models/quiz';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Router } from '@angular/router';
import { QuizService } from '../../services/quiz.service';
import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent implements OnInit {

  quiz = new Quiz;
  constructor(public flashMessagesService:FlashMessagesService,
    public router:Router,public quizService:QuizService,
    ) { }

  ngOnInit() {
  }

  onSubmit({value,valid}:{value:Quiz,valid:boolean}){
    if(!valid){
      // console.log('onSubmit error');
      
      this.flashMessagesService.show('Please fill the Title',{cssClass:'alert-danger', timeout:4000});
      this.router.navigate(['add-quiz']);
    }
    else{
     // console.log('onSubmit save');
      
      this.quizService.newQuiz(value); 
      this.flashMessagesService.show('New Quiz Added',{cssClass:'alert-success',timeout:4000});
     
      this.router.navigate(['/quiz']);
    }

  }
}
