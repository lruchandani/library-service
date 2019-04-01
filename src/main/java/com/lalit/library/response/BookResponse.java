package com.lalit.library.response;

import com.lalit.library.entity.Book;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
public class BookResponse extends ResourceSupport {
    String bookId;
    String title;
    AuthorResponse author;

    public BookResponse(Book book) {
        this.bookId = book.getBookId().toString();
        this.title = book.getTitle();
        this.author = new AuthorResponse(book.getAuthor());
    }

    public BookResponse() {
    }
}
