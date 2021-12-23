import {Component, OnInit} from '@angular/core';
import {Location} from "@angular/common";
import {ActivatedRoute} from "@angular/router";
import {BookItem} from "../../../model/book-item";
import {BookService} from "../../../service/book.service";

@Component({
  selector: 'app-book-item',
  templateUrl: './book-item.component.html',
  styleUrls: ['./book-item.component.scss']
})
export class BookItemComponent implements OnInit {

  book!: BookItem

  constructor(private location: Location,
              private route: ActivatedRoute,
              private bookService: BookService) {
  }

  ngOnInit(): void {
    let bookId: number = 0
    this.route.paramMap.subscribe(params => bookId = ~~params.get('id')!)
    this.bookService.getBook(bookId).subscribe(book => {
      this.book = book
    })
  }

  goBack() {
    this.location.back()
  }
}
