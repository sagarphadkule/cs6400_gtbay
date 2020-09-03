import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient} from '@angular/common/http';


import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { RegistrationComponent } from './registration/registration.component';
import { NewItemComponent } from './new-item/new-item.component';
import { SearchItemComponent } from './search-item/search-item.component';
import { AppRoutingModule } from './/app-routing.module';
import { HttpClientModule} from '@angular/common/http';
import { AccountService } from './account.service';
import {CategoryService} from './category.service';
import {ItemConditionService} from './itemCondition.service';
import {AuctionService} from './auction.service';
import { ReportComponent } from './report/report.component';
import {ReportService} from './report/report.service';
import { SearchResultComponent } from './search-result/search-result.component';
import {SearchItemService} from './search-item/search-item.service';
import { ItemComponent } from './item/item.component';
import { RatingsComponent } from './ratings/ratings.component';
import {RatingsService} from './ratings/ratings.service';
import { AuctionResultsComponent } from './auction-results/auction-results.component';
import {AuctionResultsService} from './auction-results/auction-results.service';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    MainMenuComponent,
    RegistrationComponent,
    NewItemComponent,
    SearchItemComponent,
    ReportComponent,
    SearchResultComponent,
    ItemComponent,
    RatingsComponent,
    AuctionResultsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    // HttpClient,
    FormsModule,
  ],
  providers: [AccountService, CategoryService, ItemConditionService, AuctionService, ReportService,
              SearchItemService, RatingsService, AuctionResultsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
