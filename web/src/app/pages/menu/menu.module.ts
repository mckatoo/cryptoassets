import { PortfolioPage } from './../portfolio/portfolio.page';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { MenuPage } from './menu.page';

const routes: Routes = [
  {
    path: 'menu',
    component: MenuPage,
    children: [
      {
        path: 'portifolio',
        loadChildren: '../portfolio/portfolio.module#PortfolioPageModule'
      },
      {
        path: 'graphics',
        loadChildren: '../graphics/graphics.module#GraphicsPageModule'
      },
      {
        path: 'alerts',
        loadChildren: '../alerts/alerts.module#AlertsPageModule'
      }
    ]
  },
  {
    path: '',
    redirectTo: '/menu/portifolio'
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [MenuPage]
})
export class MenuPageModule { }
