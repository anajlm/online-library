package tech.ada.onlinelibrary.advice.exception;

public class BookNotFoundException extends Exception {

    public  BookNotFoundException(String title){ super("Could not find movie with title " + title); }
}
