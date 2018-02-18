import { Injectable } from '@angular/core';
import { School } from '../models/school';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Observable';
import { AppConst } from '../constants/app-const';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class SchoolService {
  private apiUrl = AppConst.serverPath + 'school';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = { headers: this.headers };
  constructor(private http: Http) { }

  getAllSchool(): Observable<any[]> {
    return this.http.get(this.apiUrl).map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  getSchoolById(id: number): Promise<School> {
    return this.http.get(this.apiUrl + '/' + id).toPromise().then(res => res.json() as School)
      .catch(this.handleError);
  }

  newSchool(school: School): Promise<School> {
   
    return this.http.post(this.apiUrl, JSON.stringify(school), this.options).toPromise()
      .then(res => res.json() as School)
      .catch(this.handleError);
  }
  updateSchool(id: number, school: School) {
   
    return this.http.put(this.apiUrl + '/' + id, JSON.stringify(school), this.options).toPromise()
      .then(res => res.json() as School)
      .catch(this.handleError);
  }
  deleteSchool(id: number): Promise<void> {
    return this.http.delete(this.apiUrl + '/' + id, this.options)
      .toPromise().then(() => null).catch(this.handleError);
  }
  private handleError(error: any): Promise<any> {
    console.log('Error', error);
    return Promise.reject(error.message || error);
  }
}
