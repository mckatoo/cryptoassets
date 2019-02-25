import { Component, OnInit } from '@angular/core';
import { Router, RouterEvent } from '@angular/router';

@Component({
  selector: 'app-tabs',
  templateUrl: 'tabs.page.html',
  styleUrls: ['tabs.page.scss']
})
export class TabsPage implements OnInit {
  tabs = [
    {
      title: 'Portifolio Balance',
      url: '/menu/portifolio'
    },
    {
      title: 'Graphics',
      url: '/menu/graphics'
    },
    {
      title: 'Alerts Programing',
      url: '/menu/alerts'
    },
  ];

  selectedPath = '';

  constructor(private router: Router) {
    this.router.events.subscribe((event: RouterEvent) => {
      this.selectedPath = event.url;
    });
  }

  ngOnInit(): void {
  }
}
