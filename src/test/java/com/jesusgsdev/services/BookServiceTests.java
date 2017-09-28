package com.jesusgsdev.services;


import com.jesusgsdev.entities.Book;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookServiceTests {

    @Autowired
    BookService bookService;

    @Test
    @DisplayName("Add a new book in the Bookshop")
    public void saveTest(){
        Book book = new Book("Book Name", 9.99, "Author Name Test", 200);
        Book savedBook = bookService.save(book);

        assertNotNull(savedBook);
    }


    @Test
    @DisplayName("Find all books for a given author name")
    public void findBooksByAuthor(){
        String author = UUID.randomUUID().toString().substring(0,10);
        Book book1 = new Book("Book Name", 9.99, author, 200);
        Book book2 = new Book("Book Name 2", 9.99, "Author Name 2", 200);
        Book book3 = new Book("Book Name 3", 9.99, author, 200);
        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);

        List<Book> booksByAuthor = bookService.findBooksByAuthor(author);

        assertAll( "Books found",
                () -> assertThat(booksByAuthor, not(IsEmptyCollection.empty())),
                () -> assertThat(booksByAuthor, hasSize(2))
            );
    }

}
