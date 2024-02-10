package tech.ada.onlinelibrary.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.ada.onlinelibrary.domain.enums.Genre;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;
    private Genre genre;

}
