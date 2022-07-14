import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthFilterGuard } from 'src/services/auth-filter.guard';
import { AppModule } from './app.module';
import { ErrorComponent } from './pages/error/error.component';
import { FavouriteComponent } from './pages/favourite/favourite.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { LandComponent } from './pages/land/land.component';
import { LoginComponent } from './pages/login/login.component';
import { RegistrationComponent } from './pages/registration/registration.component';

const routes: Routes = [
  { path: '', component: HomepageComponent, canActivate: [AuthFilterGuard] },
  { path: 'home', component: LandComponent },
  {
    path: 'favorite',
    component: FavouriteComponent,
    canActivate: [AuthFilterGuard],
  },
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'not-found', component: ErrorComponent },
  { path: '**', redirectTo: '/not-found', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
