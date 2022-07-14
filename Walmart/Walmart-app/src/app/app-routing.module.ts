import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthFilterGuard } from 'src/services/auth-filter.guard';
import { CartComponent } from './cart/cart.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { ErrorComponent } from './error/error.component';
import { LoginComponent } from './login/login.component';
import { MidSectionComponent } from './mid-section/mid-section.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  { path: '', component: MidSectionComponent },
  { path: 'cart', component: CartComponent, canActivate: [AuthFilterGuard] },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'signup',
    component: SignupComponent,
  },
  {
    path: 'edit-profile',
    component: EditProfileComponent,
  },
  {
    path: 'not-found',
    component: ErrorComponent,
  },
  { path: '**', redirectTo: '/not-found', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
