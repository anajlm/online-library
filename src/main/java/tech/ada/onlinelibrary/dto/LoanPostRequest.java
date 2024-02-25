package tech.ada.onlinelibrary.dto;


import tech.ada.onlinelibrary.domain.Book;
import tech.ada.onlinelibrary.domain.User;
import tech.ada.onlinelibrary.domain.enums.Genre;

import java.time.LocalDate;
import java.time.Year;
import java.util.Objects;

public class LoanPostRequest {

    private Long userId;
    private Long bookId;

    public LoanPostRequest(Long userId, Long bookId) {
        this.userId = Objects.requireNonNull(userId);
        this.bookId = Objects.requireNonNull(bookId);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }


}
