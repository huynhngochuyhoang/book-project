import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BookItem} from "../model/book-item";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class BookService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) {
  }

  getBooks() {
    if (!this.httpOptions.headers.has('Authorization')) {
      this.httpOptions.headers = this.httpOptions.headers.append('Authorization',
        'Bearer ' + localStorage.getItem('accessToken'))
    }
    return this.http.get<BookItem[]>(`${environment.apiUrl}/book/books`, this.httpOptions)
  }

  getBook(id: number) {
    if (!this.httpOptions.headers.has('Authorization')) {
      this.httpOptions.headers = this.httpOptions.headers.append('Authorization',
        'Bearer ' + localStorage.getItem('accessToken'))
    }
    return this.http.get<BookItem>(`${environment.apiUrl}/book/${id}`, this.httpOptions)
  }
}
