import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root',
})
export class UserApiService {

  private readonly url = 'http://localhost:8080/employees';

  constructor(private http: HttpClient) { }
  
  getAllUsers(): Observable<User[]>{
    const listUsers = this.http.get<any>(this.url);
    return listUsers;
  }
}