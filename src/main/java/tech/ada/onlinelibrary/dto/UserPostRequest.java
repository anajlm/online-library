package tech.ada.onlinelibrary.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
public class UserPostRequest{
    private String username;
    private String userPassword;
    private String email;

    public UserPostRequest(Long userId, String username, String userPassword, String email) {
        this.username = Objects.requireNonNull(username);
        this.userPassword = Objects.requireNonNull(userPassword);
        this.email = Objects.requireNonNull(email);
    }
}
