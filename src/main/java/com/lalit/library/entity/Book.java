package com.lalit.library.entity;

import com.lalit.library.repository.AuthorRepository;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Book {

    @Transient
    AuthorRepository authorRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private UUID bookId;
    private String title ;

    @ManyToOne(cascade = CascadeType.DETACH , fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;


    public Book() {
    }

    public static final class BookBuilder {
        AuthorRepository authorRepository;
        com.lalit.library.command.BookCommand bookCommand;

        private BookBuilder() {
        }

        public static BookBuilder aBook() {
            return new BookBuilder();
        }

        public BookBuilder withAuthorRepository(AuthorRepository authorRepository) {
            this.authorRepository = authorRepository;
            return this;
        }

        public BookBuilder withBookCommand(com.lalit.library.command.BookCommand bookCommand){
            this.bookCommand = bookCommand;
            return this;
        }

        public Book build() {
            Book book = new Book();
            book.setAuthorRepository(authorRepository);
            book.intialize(bookCommand);
            return book;
        }
    }

    private Book intialize(com.lalit.library.command.BookCommand bookCommand) {
        if(bookCommand!=null && authorRepository!=null) {
            this.title = bookCommand.getTitle();
            this.author = authorRepository.findByAuthorName(bookCommand.getAuthor());
        }
        return this;
    }
}
