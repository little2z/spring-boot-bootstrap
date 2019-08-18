package com.xyl.persistence.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;


    @Column(nullable = false)
    private String author;

    public Book(){

    }

    public Book(String title, String author){
        super();
        this.title = title;
        this.author = author;
    }

}
