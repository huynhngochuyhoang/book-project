import {Component, Input, OnInit} from '@angular/core';
import {BookItem} from "../../model/book-item";
import {User} from "../../model/user";
import {UserService} from "../../service/user.service";
import {MatDialog} from "@angular/material/dialog";
import {PurchaseDialogComponent} from "../purchase-dialog/purchase-dialog.component";
import {BookService} from "../../service/book.service";
import {BookOrder} from "../../model/book-order";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  @Input() book!: BookItem
  currentUser!: User

  constructor(private userService: UserService, private dialog: MatDialog, private bookService: BookService) { }

  ngOnInit(): void {
  }

  purchase() {
    this.userService.currentUser.subscribe(user => this.currentUser = user)
    let bookOder: BookOrder = {
      userId: this.currentUser.userId,
      bookId: this.book.id
    }
    this.bookService.buyBook(bookOder).subscribe(() => {
      this.dialog.open(PurchaseDialogComponent, {
        data: {
          name: this.book.name
        }
      })
    })
  }

}
