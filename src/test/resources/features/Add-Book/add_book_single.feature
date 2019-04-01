Feature: Add Book
  Scenario: Add Author
    Given a following new Author is added
      |author|
      |"Bob Martin"|
    When its author is added
    Then I should be able to find the added Author

  Scenario: Add New Book (Single)
    Given a following new book has arrived
      |title|author|
      |"Clean Code"|"Bob Martin"|
    When its added
    Then I should be able to find the added book


