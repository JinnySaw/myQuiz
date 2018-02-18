import { Injectable } from '@angular/core';
import { Quiz } from '../models/quiz';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Observable';
import { AppConst } from '../constants/app-const';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class QuizService {
    private apiUrl = AppConst.serverApiPath + 'quiz';
    private headers = new Headers({ 'Content-Type': 'application/json' });
    private options = { headers: this.headers };
    // quizzes: Observable<any[]>;

    constructor(private http: Http) {
        //  this.quizzes = thi
    }
    getAllQuiz(): Observable<any[]> {
         return this.http.get(this.apiUrl).map((res: Response) => res.json())
            .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
    }

    getQuizById(id: number): Promise<Quiz> {
        return this.http.get(this.apiUrl + '/' + id).toPromise().then(res => res.json() as Quiz)
            .catch(this.handleError);
    }

    newQuiz(quiz: Quiz): Promise<Quiz> {
        return this.http.post(this.apiUrl, JSON.stringify(quiz), this.options).toPromise()
            .then(res => res.json() as Quiz)
            .catch(this.handleError);
    }
    updateQuiz(id: number, quiz: Quiz) {
        return this.http.put(this.apiUrl + '/' + id, JSON.stringify(quiz), this.options).toPromise()
            .then(res => res.json() as Quiz)
            .catch(this.handleError);
    }
    deleteQuiz(id: number): Promise<void> {
        return this.http.delete(this.apiUrl + '/' + id, this.options)
            .toPromise().then(() => null).catch(this.handleError);
    }
    private handleError(error: any): Promise<any> {
        console.log('Error', error);
        return Promise.reject(error.message || error);
    }
}
