package tech.ada.onlinelibrary.advice.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String username){ super("Could not find user with username " + username); }
}
