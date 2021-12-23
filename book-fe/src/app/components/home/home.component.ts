import {Component, OnDestroy, OnInit} from '@angular/core';
import {BookItem} from "../../model/book-item";
import {BookService} from "../../service/book.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {

  books!: BookItem[]

  constructor(private bookService: BookService) {
  }

  ngOnInit(): void {
    console.log('Home component init')
    this.bookService.getBooks().subscribe(books => this.books = books)
  }

  ngOnDestroy(): void {
    console.log('Home component destroy')
  }

}
