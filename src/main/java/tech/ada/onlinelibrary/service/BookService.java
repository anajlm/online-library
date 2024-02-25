package tech.ada.onlinelibrary.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import tech.ada.onlinelibrary.advice.exception.BookNotFoundException;
import tech.ada.onlinelibrary.domain.Book;
import tech.ada.onlinelibrary.dto.request.CreateBookRequest;
import tech.ada.onlinelibrary.repository.BookRepository;

import java.util.List;
=======
import tech.ada.onlinelibrary.domain.Book;
import tech.ada.onlinelibrary.dto.BookPostRequest;
import tech.ada.onlinelibrary.repository.BookRepository;

import java.util.List;
import java.util.Optional;
>>>>>>> andressa

@Service
public class BookService {

    private BookRepository bookRepository;
    private ModelMapper modelMapper;

    @Autowired
    public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

<<<<<<< HEAD
    public Book createBook(CreateBookRequest bookRequest) {
=======
    public Book createBook(BookPostRequest bookRequest) {
>>>>>>> andressa
        Book book = modelMapper.map(bookRequest, Book.class);
        return bookRepository.save(book);
    }

<<<<<<< HEAD
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public void deleteBook(Long id) {
        getBookById(id);
        bookRepository.deleteById(id);
    }

}
=======
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
>>>>>>> andressa
