package tech.ada.onlinelibrary.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String userPassword;
    private String email;

    @OneToMany//(mappedBy = "user", cascade = CascadeType.REMOVE)
    //@JsonIgnoreProperties("user")
    private List<Loan> loans;

}
