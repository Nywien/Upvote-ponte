import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router} from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class HasRoleGuard implements CanActivate {
    constructor( public router: Router) {}
    canActivate(route: ActivatedRouteSnapshot): boolean {

        const expectedRoles = route.data['expectedRoles'];
        const localStorageUser = localStorage.getItem('user');
        // @ts-ignore
      const localStorageRoles = JSON.parse(localStorageUser).roles;

        for (const expectedRole of expectedRoles) {
            if (this.isAuthenticated() && localStorageRoles.includes(expectedRole)) {
                return true;
            }
        }

        return false;
    }
  isAuthenticated() {
    return localStorage.getItem('user');
  }
}
