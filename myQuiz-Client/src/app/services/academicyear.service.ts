import { Injectable } from '@angular/core';
import { AcademicYear } from '../models/academicyear';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Observable';
import { AppConst } from '../constants/app-const';
import 'rxjs/add/operator/toPromise'; 
import { Academic} from '../models/academic';

@Injectable()
export class AcademicyearService {
  private apiUrl = AppConst.serverApiPath + 'academic';
  private headers = new Headers({ 
    'Content-Type': 'application/json',
    'x-auth-token': localStorage.getItem("xAuthToken")
  });
  private options = { headers: this.headers };

  constructor(private http: Http) { }
  // private school: School = new School();
  getAllAcademic(): Observable<any[]> { 
    localStorage.clear();
      return this.http.get(this.apiUrl).map((res: Response) =>
      JSON.parse(JSON.parse(JSON.stringify(res))._body)) 
      .catch((error: any) =>
      Observable.throw(error.json().error || 'Server error'));
      
  }

  // getAcademicById(id: number): Promise<Academic> {
  //   // console.log("get academic by id");
    
  //   return this.http.get(this.apiUrl + '/' + id).toPromise().then(res =>
      
  //     JSON.parse(JSON.parse(JSON.stringify(res))._body) as Academic
  //   )
  //     .catch(this.handleError);
  // }
 getAcademicById(id: number): Observable<any> {
    // console.log("get academic by id");
    
    return this.http.get(this.apiUrl + '/' + id).map(res =>
      
      res.json()
    )
      .catch(this.handleError);
  }
  newAcademic(AcademicYear: AcademicYear): Promise<AcademicYear> { 
   
    let tokenHeader = new Headers()
    return this.http.post(this.apiUrl+'?schoolId='+AcademicYear.school_id, JSON.stringify(
      
      AcademicYear 
    
    ), this.options).toPromise()
      .then(res => res.json() as AcademicYear)
      .catch(this.handleError);
  }
  updateAcademic(id: number, Academic: AcademicYear) {
    return this.http.put(this.apiUrl + '/' + id +'?schoolId='+Academic.school_id, JSON.stringify(Academic), this.options).toPromise()
      .then(res => res.json() as AcademicYear)
      .catch(this.handleError);
  }
  deleteAcademic(id: number): Promise<void> {
    return this.http.delete(this.apiUrl + '/' + id, this.options)
      .toPromise().then(() => null).catch(this.handleError);
  }
  private handleError(error: any): Promise<any> {
    console.log('Error', error);
    return Promise.reject(error.message || error);
  }

}
