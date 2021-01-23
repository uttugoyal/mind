import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable, of } from 'rxjs';
import { RouterAuthenticationService } from '../_services/router-authentication.service';
 
@Injectable({
  providedIn: 'root'
})
export class AdminGuardGuard implements CanActivate {
 
  constructor(private routeAuth: RouterAuthenticationService){}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean>{
 
      if(this.routeAuth.isAdminAuthenticated()){
        return of(true)
      }
      else{
        return of(false)
      }
  }
  
}