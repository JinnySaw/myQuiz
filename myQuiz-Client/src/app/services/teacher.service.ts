import { Injectable } from '@angular/core';
import { AppConst } from '../constants/app-const';
import { Http, Response, Headers } from '@angular/http';
import { Teacher } from '../models/teacher';

@Injectable()
export class TeacherService { 
  private apiUrl = AppConst.serverApiPath + 'teacher';
  private headers = new Headers({
    'Content-Type': 'application/json',
    'x-auth-token': localStorage.getItem("xAuthToken")
  });
  private options = { headers: this.headers };

  constructor(private http: Http) { }

  getAllTeachers() {
    return this.http.get(this.apiUrl, {headers: this.headers});
  }

  newTeacher(teacher : Teacher) {
    return this.http.post(this.apiUrl, JSON.stringify(teacher), {headers: this.headers});
  }

}
