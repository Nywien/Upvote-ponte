import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

const BASE_URL = "http://localhost:8080";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit{


  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit() {
    this.http.get(BASE_URL + '/api/users/me').subscribe(
      (response) => {
        localStorage.setItem('user', JSON.stringify(response));
      },
      (error) => {
        localStorage.removeItem('user');

      });

  }

  hasRoles(expectedRoles: string[]): boolean {
    const user = localStorage.getItem('user');
    if (user) {
      const userRoles = JSON.parse(user);
      const roles = userRoles.role;
      for (const expectedRole of expectedRoles) {
        if (roles.includes(expectedRole)) {
          return true;
        }
      }
      return false;
    }

    return false;
  }

  isLoggedIn() {
    return localStorage.getItem('user');
  }

  logout() {
    this.http.get(BASE_URL + '/logout').subscribe(() => {
      localStorage.removeItem('user');
    });
  }
}
