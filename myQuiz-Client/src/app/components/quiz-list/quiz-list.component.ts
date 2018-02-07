import { Component, OnInit } from '@angular/core';
import { Quiz } from '../../models/quiz';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { Http } from '@angular/http';
import { QuizService } from '../../services/quiz.service';
import { FlashMessagesService } from 'angular2-flash-messages';

@Component({
  selector: 'app-quiz-list',
  templateUrl: './quiz-list.component.html',
  styleUrls: ['./quiz-list.component.css']
})
export class QuizListComponent implements OnInit {

  private quizzes: Quiz[];
  //@Input() quiz: Quiz;
  constructor(private quizService: QuizService,
    private router: Router,
    private http: Http,
  private flashMessagesService:FlashMessagesService
) { }

  // When component is loading get all quizzes and set the quizzed[]
  ngOnInit() {
    this.getAllQuizzes();
  }

  getAllQuizzes() {
    console.log('list');
    // this.quizService.getAllQuiz().then(quizzes=> {
    //   this.quizzes = quizzes}
    // );
    this.quizService.getAllQuiz().subscribe((quizzes) => {

      this.quizzes = quizzes;
     // console.log(this.quizzes);
      
    }
      , err => {
        console.log('quizlist: getAll' + err);
      }
    );
  }
  onDeleteClick(id:number){
    if(confirm("Are you sure to delete?")){
      this.quizService.deleteQuiz(id);
      this.flashMessagesService.show("Client Deleted", { cssClass: 'alert-success', timeout: 4000 });
      this.router.navigate(['/']);
    }
  }
 
}
