import { Component, OnInit } from '@angular/core';
import { Quiz } from '../../models/quiz';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { Http } from '@angular/http';
import { QuizService } from '../../services/quiz.service';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Observable } from 'rxjs/Observable';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-quiz-list',
  templateUrl: './quiz-list.component.html',
  styleUrls: ['./quiz-list.component.css']
})
export class QuizListComponent implements OnInit {
  private loggedIn = false;
  private quizzes: Observable<Quiz[]>; 
  constructor(private quizService: QuizService,
    private router: Router,
    private http: Http,
    private flashMessagesService: FlashMessagesService, 
    private loginService: LoginService
  ) { }

  // When component is loading get all quizzes and set the quizzed[]
  ngOnInit() {
   this.checkSession();
    this.getAllQuizzes();
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
  getAllQuizzes() { 
    this.quizzes = this.quizService.getAllQuiz();
  }
  onDeleteClick(id: number) {
    if (confirm("Are you sure to delete?")) {
      this.quizService.deleteQuiz(id);
      this.flashMessagesService.show("Quiz Deleted", { cssClass: 'alert-success', timeout: 4000 });
      this.router.navigate(['/quiz']);
    }
  }

}
