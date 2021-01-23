import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable, of } from 'rxjs';
import { RouterAuthenticationService } from '../_services/router-authentication.service';
 
@Injectable({
  providedIn: 'root'
})
export class CustomerGuardGuard implements CanActivate {
  constructor(private routeAuth: RouterAuthenticationService){}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
      if(this.routeAuth.isCustomerAuthenticated()){
        return of(true)
      }
      else{
        return of(false)
      }
  }
  
}
