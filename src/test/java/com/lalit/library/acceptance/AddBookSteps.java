package com.lalit.library.acceptance;


import com.lalit.library.command.AuthorCommand;
import com.lalit.library.command.BookCommand;
import com.lalit.library.common.ApiRunTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static io.restassured.RestAssured.given;

public class AddBookSteps extends ApiRunTest {

    String bookId;
    String authorId;
    BookCommand bookCommand;
    AuthorCommand authorCommand;

    @Given("a following new book has arrived")
    public void a_following_new_book_has_arrived(List<BookCommand> books) {
        this.bookCommand = books.get(0);
    }

    @When("its added")
    public void its_added() {
        bookId = given().contentType("application/json")
                        .port(port).body(bookCommand).when().post("/books")
                .then().statusCode(200).and()
                .extract().jsonPath().getString("bookId");
    }

    @Then("I should be able to find the added book")
    public void i_should_be_able_to_find_the_added_book() {
        given().port(port)
                .get("/books/"+ bookId)
                    .then()
                .statusCode(200);
    }

    @Given("a following new Author is added")
    public void aFollowingNewAuthorIsAdded(List<AuthorCommand> authorCommand) {
        this.authorCommand = authorCommand.get(0);
    }

    @Then("I should be able to find the added Author")
    public void iShouldBeAbleToFindTheAddedAuthor() {
        given().port(port)
                .get("/authors/"+ authorId)
                .then()
                .statusCode(200);
    }

    @When("its author is added")
    public void itsAuthorIsAdded() {
        authorId = given().contentType("application/json")
                .port(port).body(authorCommand).when().post("/authors")
                .then().statusCode(200).and()
                .extract().jsonPath().getString("authorId");
    }
}
