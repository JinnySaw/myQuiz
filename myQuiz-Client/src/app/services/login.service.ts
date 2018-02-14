import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { AppConst } from '../constants/app-const';

@Injectable()
export class LoginService {

  constructor(private http: Http) { }

  sendCredential(username: string, password: string){
   // let apiUrl = AppConst.serverPath + 'token';
   let apiUrl = 'http://localhost:8080/token'
    let encodeCredentials = btoa(username+":"+password);
    let basicHeader="Basic "+ encodeCredentials;
    let headers = new Headers({
      'Content-Type' : 'application/x-www-form-urlencoded',
      'Authorization' : basicHeader
    });
    return this.http.get(apiUrl,{headers: headers});
  }

  checkSession(){
    let url = "http://localhost:8080/checkSession";

    let headers = new Headers({
     'x-auth-token': localStorage.getItem('xAuthToken')
    });
  //  console.log("ss");
   
    return this.http.get(url,{headers: headers});
  }

  logout(){
    let url= "http://localhost:8080/user/logout";

    let headers =new Headers({
      'x-auth-token' : localStorage.getItem('xAuthToken')
    }); 
    

    return this.http.post(url,'', {headers: headers});
  }

}
