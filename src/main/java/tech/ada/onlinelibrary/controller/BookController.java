package tech.ada.onlinelibrary.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.onlinelibrary.domain.Book;
import tech.ada.onlinelibrary.dto.BookPostRequest;
import tech.ada.onlinelibrary.repository.BookRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    // teste
    private BookRepository bookRepository;

    private ModelMapper modelMapper;

    @Autowired
    public BookController(BookRepository bookRepository, ModelMapper modelMapper){
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }


    @GetMapping(value = "/library/books", params = {"title"})
    public ResponseEntity<List<Book>> getBooksByTitle(@RequestParam String title){
        return ResponseEntity.ok(bookRepository.findByTitleContainingIgnoreCase(title));
    }

    //GET Retrieve book by author.
    //GET Retrieve book by genre.

    @PostMapping("/library/books")
    public ResponseEntity<Book> createBook(@RequestBody BookPostRequest bookRequest){
        Book book = modelMapper.map(bookRequest, Book.class);
        Book newBook = bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @DeleteMapping("/library/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            bookRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
