package com.lalit.library.response;

import com.lalit.library.entity.Author;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
public class AuthorResponse extends ResourceSupport {
    String authorId;
    String authorName;

    public AuthorResponse(Author author) {
        this.authorId = author.getAuthorId().toString();
        this.authorName = author.getAuthorName();
    }

    public AuthorResponse() {
    }
}
