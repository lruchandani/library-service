package com.lalit.library.entity;

import com.lalit.library.command.AuthorCommand;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID authorId;
    private String authorName;

    public Author(AuthorCommand authorCommand) {
        this.authorName = authorCommand.getAuthor();
    }

    public Author() {
    }
}
