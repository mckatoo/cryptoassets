import { Component, OnInit } from '@angular/core';
import { Router, RouterEvent } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.page.html',
  styleUrls: ['./menu.page.scss'],
})
export class MenuPage implements OnInit {

  pages = [
    {
      title: '',
      url: ''
    },
    // {
    //   title: 'Portifolio Balance',
    //   url: '/menu/portifolio'
    // },
    // {
    //   title: 'Graphics',
    //   url: '/menu/graphics'
    // },
    // {
    //   title: 'Alerts Programing',
    //   url: '/menu/alerts'
    // },
  ];

  selectedPath = '';

  constructor(private router: Router) {
    this.router.events.subscribe((event: RouterEvent) => {
      this.selectedPath = event.url;
    });
  }

  ngOnInit() {
  }

}
