import { NgModule } from '@angular/core';
import { Routes, RouterModule} from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { CustomerComponent } from './customer/customer.component';
//import { ProfileComponent } from './profile/profile.component';
//import { ResetPasswordComponent } from './reset-password/reset-password.component';
//import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { AdminGuardGuard } from './_helpers/admin-guard.guard';
import { CustomerGuardGuard } from './_helpers/customer-guard.guard';

const routes: Routes = [
  {path:'register',component:RegisterComponent},
  {path:'login',component:LoginComponent},
  {path:'home',component:HomeComponent},
  {path:'admin',
    component:AdminComponent,
    canActivate: [AdminGuardGuard] },
  {path:'customer',
  component:CustomerComponent,
  canActivate: [CustomerGuardGuard]},
 // {path:'profile',component:ProfileComponent},
 // {path:'resetpass',component:ResetPasswordComponent},
  //{path:'editprofile',component:EditProfileComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
