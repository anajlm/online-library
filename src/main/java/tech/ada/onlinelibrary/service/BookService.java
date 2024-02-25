package tech.ada.onlinelibrary.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.onlinelibrary.advice.exception.BookNotFoundException;
import tech.ada.onlinelibrary.domain.Book;
import tech.ada.onlinelibrary.dto.request.CreateBookRequest;
import tech.ada.onlinelibrary.repository.BookRepository;

import java.util.List;

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

    public Book createBook(CreateBookRequest bookRequest) {
        Book book = modelMapper.map(bookRequest, Book.class);
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public void deleteBook(Long id) {
        getBookById(id);
        bookRepository.deleteById(id);
    }
    
}
