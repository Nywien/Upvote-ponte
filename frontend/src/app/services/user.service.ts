import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {RegisterFormDataModel} from "../models/RegisterFormData.model";
import {Observable} from "rxjs";

const BASE_URL = "http://localhost:8080/api/users"

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) {
  }

  saveNewUser(data: RegisterFormDataModel) {
    return this.httpClient.post(BASE_URL, data);
  }

  authenticate(credentials: { username: string, password: string }): Observable<any> {
    const headers = new HttpHeaders(credentials
      ? {authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password)}
      : {});
    return this.httpClient.get(BASE_URL + '/me', {headers: headers});
  }
}
