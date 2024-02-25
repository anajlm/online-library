package tech.ada.onlinelibrary.advice.exception;

public class UserNotFoundException extends NullPointerException {

    public UserNotFoundException(String username){ super("Could not find user with username " + username); }
}
