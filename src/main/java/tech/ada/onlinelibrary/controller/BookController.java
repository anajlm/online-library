package tech.ada.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.onlinelibrary.domain.Book;
<<<<<<< HEAD
import tech.ada.onlinelibrary.dto.request.CreateBookRequest;
=======
import tech.ada.onlinelibrary.dto.BookPostRequest;
import tech.ada.onlinelibrary.repository.BookRepository;
>>>>>>> andressa
import tech.ada.onlinelibrary.service.BookService;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/library/books", params = {"title"})
    public ResponseEntity<List<Book>> getBooksByTitle(@RequestParam String title){
        List<Book> books = bookService.getBooksByTitle(title);
        return ResponseEntity.ok(books);
    }

    //GET Retrieve book by author.
    //GET Retrieve book by genre.

    @PostMapping("/library/books")
<<<<<<< HEAD
    public ResponseEntity<Book> createBook(@RequestBody CreateBookRequest bookRequest){
=======
    public ResponseEntity<Book> createBook(@RequestBody BookPostRequest bookRequest){
>>>>>>> andressa
        Book newbook = bookService.createBook(bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newbook);
    }

    @DeleteMapping("/library/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
<<<<<<< HEAD
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
=======
        Optional<Book> optionalBook = bookService.getBookById(id);
        if (optionalBook.isPresent()) {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
>>>>>>> andressa
    }
}
