import { Component, OnInit } from '@angular/core';
import { Quiz } from '../../models/quiz';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Router,ActivatedRoute, Params } from '@angular/router';
import { QuizService } from '../../services/quiz.service';
import 'rxjs/add/operator/toPromise';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-edit-quiz',
  templateUrl: './edit-quiz.component.html',
  styleUrls: ['./edit-quiz.component.css']
})
export class EditQuizComponent implements OnInit {

  private loggedIn = false;
  private id: number;
  private quiz: Quiz = new Quiz();
  private quizUpdated: boolean;

  constructor(private flashMessagesService:FlashMessagesService,
    private router:Router,public quizService:QuizService,
    private route: ActivatedRoute,private loginService: LoginService
  ) { }

  ngOnInit() {
    this.checkSession();
    this.id = this.route.snapshot.params['id'];
    
    this.quizService.getQuizById(this.id).then(quiz=>{
      this.quiz = quiz;
    }) 
    
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
  onSubmit({value,valid}:{value:Quiz,valid:boolean}){
    var flashMessagesService = this.flashMessagesService;
    if(!valid){
      console.log('onSubmit error');
      
      this.flashMessagesService.show('Please fill the Title',{cssClass:'alert-danger', timeout:4000});
      this.router.navigate(['edit-quiz/'+ this.id]);
    }
    else{
      this.quizService.updateQuiz(this.id,value);
       this.flashMessagesService.show('Quiz Updated',{cssClass:'alert-success',timeout:4000});
      
      this.router.navigate(['/quiz']);
    }

  }

}
