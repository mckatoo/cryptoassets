import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', loadChildren: './pages/menu/menu.module#MenuPageModule' },
  // { path: '', loadChildren: './tabs/tabs.module#TabsPageModule' },
  // { path: 'menu', loadChildren: './pages/menu/menu.module#MenuPageModule' },
  // { path: 'portfolio', loadChildren: './pages/portfolio/portfolio.module#PortfolioPageModule' },
  // { path: 'graphics', loadChildren: './pages/graphics/graphics.module#GraphicsPageModule' },
  // { path: 'alerts', loadChildren: './pages/alerts/alerts.module#AlertsPageModule' },
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
