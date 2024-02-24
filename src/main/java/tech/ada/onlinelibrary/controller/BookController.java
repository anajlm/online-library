package tech.ada.onlinelibrary.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.onlinelibrary.domain.Book;
import tech.ada.onlinelibrary.dto.BookPostRequest;
import tech.ada.onlinelibrary.repository.BookRepository;
import tech.ada.onlinelibrary.service.BookService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Book> createBook(@RequestBody BookPostRequest bookRequest){
        Book newbook = bookService.createBook(bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newbook);
    }

    @DeleteMapping("/library/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> optionalBook = bookService.getBookById(id);
        if (optionalBook.isPresent()) {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
