package com.xyl.web;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;

import com.xyl.SpringBootBootstrapApplication;
import com.xyl.persistence.model.Book;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootBootstrapApplication.class }, webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BookControllerTest {


    private static final String API_ROOT = "http://localhost:8081/api/books";


    private Book createRandomBook() {
        Book book = new Book();
        book.setTitle(randomAlphabetic(10));
        book.setAuthor(randomAlphabetic(15));
        return book;
    }

    private String createBookAsUri(Book book) {
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }

    @Test
    public void getAllBooks(){

        Response response = RestAssured.get(API_ROOT);

        log.info("getAllBooks {}", response.getBody());

    }

    @Test
    public void createBook(){
        Book book = createRandomBook();
        Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(book).post(API_ROOT);


        log.info("Response {}", response.getBody().prettyPrint());
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

}
