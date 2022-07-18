package com.example.mybookstore2.entity;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String bookname;
    private String pub;
    private double price;
    private String date;
    private Integer count;
    private String kind;

}
