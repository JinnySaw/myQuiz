import { Component, OnInit } from '@angular/core';
import { Quiz } from '../../models/quiz';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { Http } from '@angular/http';
import { QuizService } from '../../services/quiz';

@Component({
  selector: 'app-quiz-list',
  templateUrl: './quiz-list.component.html',
  styleUrls: ['./quiz-list.component.css']
})
export class QuizListComponent implements OnInit {

  private quizzes: Quiz[];
  constructor(private quizService: QuizService,
    private router: Router,
    private http: Http) { }

  // When component is loading get all quizzes and set the quizzed[]
  ngOnInit() {
    this.getAllQuizzes();
  }

  getAllQuizzes() {

    this.quizService.getAllQuiz().subscribe((quizzes) => {
      this.quizzes = quizzes;
    }
      , err => {
        console.log('quizlist: getAll' + err);
      }
    );
  }
}
