import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

const BASE_URL = "http://localhost:8080";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {


  constructor(private http: HttpClient, private router: Router) {
  }

  isLoggedIn() {
    return localStorage.getItem('user');
  }

  logout() {
    this.http.get(BASE_URL + '/api/users/logout').subscribe(() => {
      localStorage.removeItem('user');
      this.router.navigate(["/login"]);
    });
  }
}
