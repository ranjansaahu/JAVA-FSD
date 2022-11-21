import { Component, OnInit } from "@angular/core";
import { BookService } from "./book.service";
import { Book } from "src/model/Book";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  books: Book[] = [];
  book: Book = new Book();
  errorMessage: String = "";

  constructor(private bookService: BookService) {}

  ngOnInit() {
    this.getBooksFromServer();
  }

  getBooksFromServer() {
    // get the books by calling the appropriate BookService function
    // subscribe to the observable returned and assign the received books to the books array
    this.bookService.getBooks().subscribe((result) => (this.books = result));
  }

  newBook() {
    // newBook() will add the new book details, entered in the form, to the server
    // if any of the form field is empty, set the errorMessage "Fields cannot be empty", else,
    // call the appropriate BookService function to add the book
    // if the book is added successfully,
    //    - update the books array with the newly added book,
    //    - set the book to new book object
    //    - set the errorMessage to ""

    if (
      this.book.name == "" ||
      this.book.author == "" ||
      this.book.year == 0 ||
      this.book.language == ""
    ) {
      this.errorMessage = "Fields cannot be empty";
    } else {
      this.bookService.addBook(this.book).subscribe((result) => {
        this.book = new Book();
        this.errorMessage = "";
        this.getBooksFromServer();
      });
    }
  }
  onSubmit() {
    this.newBook();
  }
}
