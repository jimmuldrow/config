import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HeroesComponent }      from './heroes.component';

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);

const appRoutes: Routes = [
  {
    path: 'heroes',
    component: HeroesComponent
  },
  
  {
  path: 'detail/:id',
  component: HeroDetailComponent
  },
  
 {
  path: '',
  redirectTo: '/dashboard',
  pathMatch: 'full'
}, 

{
  path: 'detail/:id',
  component: HeroDetailComponent
},
  
{
  path: 'dashboard',
  component: DashboardComponent
} 
];



