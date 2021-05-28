import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment as env} from 'src/environments/environment';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(username:string, password:string): Observable<User>{
    let loginInfo = {
      username:username, 
      password:password
    }
    return this.http.post(`${env.API_URL}/auth`, loginInfo).pipe(
      map(response => response as User)
    );
  }
}
