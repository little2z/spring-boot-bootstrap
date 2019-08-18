package com.xyl.persistence;


import com.xyl.SpringBootBootstrapApplication;
import com.xyl.persistence.model.Book;
import com.xyl.persistence.repo.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootBootstrapApplication.class)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;


    @Test
    public void test(){
        Book book = new Book();
        book.setTitle("test");
        book.setAuthor("testAuthor");
        book = bookRepository.save(book);

        System.out.println(book);

        assertEquals(book.getAuthor(), "testAuthor");
    }

}
