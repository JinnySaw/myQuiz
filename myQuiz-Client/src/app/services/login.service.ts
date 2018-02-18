import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { AppConst } from '../constants/app-const';

@Injectable()
export class LoginService {

  private headers = new Headers({
    'x-auth-token': localStorage.getItem('xAuthToken')
   }); 
  constructor(private http: Http) { }

  sendCredential(username: string, password: string){
 let apiUrl = AppConst.serverPath + 'token'; 
    let encodeCredentials = btoa(username+":"+password);
    let basicHeader="Basic "+ encodeCredentials;
    let headers = new Headers({
      'Content-Type' : 'application/x-www-form-urlencoded',
      'Authorization' : basicHeader
    });
    return this.http.get(apiUrl,{headers: headers});
  }

  checkSession(){
    let url = AppConst.serverPath+'checkSession';
    return this.http.get(url,{headers: this.headers});
  }

  logout(){
    let url=AppConst.serverPath+'user/logout';
    return this.http.post(url,'', {headers: this.headers});
  }

}
