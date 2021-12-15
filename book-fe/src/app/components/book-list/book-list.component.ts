import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  @Input() book!: string

  constructor() { }

  ngOnInit(): void {
  }

}
