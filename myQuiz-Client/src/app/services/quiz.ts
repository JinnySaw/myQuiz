import { Injectable } from '@angular/core';
import {Quiz} from '../models/quiz';
import {Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Observable';
import { AppConst } from '../constants/app-const';

@Injectable()
export class QuizService{
    private apiUrl = AppConst.serverPath + '/quiz';
    constructor(private http:Http){
        
    }
    getAllQuiz(): Observable<Quiz[]>{
        console.log('Service :getAllQuizes');
        
        return this.http.get(this.apiUrl).map((res:Response) => res.json()).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }

    getQuizById(id:number): Observable<Quiz>{
        return  null;
    }
}