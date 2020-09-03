import {Component, OnInit} from '@angular/core';
import {ReportService} from './report.service';
import {CategoryReport} from './category.report';
import {UserReport} from './user.report';
import {Router} from '@angular/router';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  constructor(private reportService: ReportService, private router: Router) {
  }

  categoryReport: CategoryReport[];
  userReport: UserReport[];
  currentUrl: string;

  ngOnInit() {
    this.generateCategoryReport();
    this.generateUserReport();
    this.currentUrl = this.router.url;
  }

  generateCategoryReport(): void {
    this.reportService.generateCategoryReport()
      .subscribe(categoryReport => this.categoryReport = categoryReport);
  }

  generateUserReport(): void {
    this.reportService.generateUserReport()
      .subscribe(userReport => this.userReport = userReport);
  }

}
