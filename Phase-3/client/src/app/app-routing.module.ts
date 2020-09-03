import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { NewItemComponent } from './new-item/new-item.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchItemComponent } from './search-item/search-item.component';
import {ReportComponent} from './report/report.component';
import {SearchResultComponent} from './search-result/search-result.component';
import {ItemComponent} from './item/item.component';
import {RatingsComponent} from './ratings/ratings.component';
import {AuctionResultsComponent} from './auction-results/auction-results.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'main', component: MainMenuComponent},
  {path: 'new', component: NewItemComponent},
  {path: 'register', component: RegistrationComponent},
  {path: 'search', component: SearchItemComponent},
  {path: 'searchResult', component: SearchResultComponent},
  {path: 'item/:id', component: ItemComponent},
  {path: 'categoryReport', component: ReportComponent},
  {path: 'userReport', component: ReportComponent},
  {path: 'ratings/:id', component: RatingsComponent},
  {path: 'auctionResults', component: AuctionResultsComponent}];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [RouterModule]
})
export class AppRoutingModule { }
