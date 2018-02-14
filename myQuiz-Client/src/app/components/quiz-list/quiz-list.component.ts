import { Component, OnInit } from '@angular/core';
import { Quiz } from '../../models/quiz';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { Http } from '@angular/http';
import { QuizService } from '../../services/quiz.service';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-quiz-list',
  templateUrl: './quiz-list.component.html',
  styleUrls: ['./quiz-list.component.css']
})
export class QuizListComponent implements OnInit {

  private quizzes: Observable<Quiz[]>;
  //@Input() quiz: Quiz;
  constructor(private quizService: QuizService,
    private router: Router,
    private http: Http,
  private flashMessagesService:FlashMessagesService
) { }

  // When component is loading get all quizzes and set the quizzed[]
  ngOnInit() {
   // this.getAllQuizzes();
    //location.reload();
  this.getAllQuizzes();
  }

  getAllQuizzes() {
    // console.log('list');
   this.quizzes = this.quizService.getAllQuiz();
  //  .subscribe(quizzes=> {
  //     this.quizzes = quizzes.join()}
  //   );
   
  }
  onDeleteClick(id:number){
    if(confirm("Are you sure to delete?")){
      this.quizService.deleteQuiz(id);
      this.flashMessagesService.show("Quiz Deleted", { cssClass: 'alert-success', timeout: 4000 });
      this.router.navigate(['/quiz']);
    }
  }
 
}
