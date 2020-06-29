package com.kevinjanvier.stock.dbservice.model;

import javax.persistence.*;

@Entity
@Table(name = "quotes", catalog = "test")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private  String username;
    private  String quote;

    public Quote() {
    }

    public Quote(String userName, String quote) {
        this.username = userName;
        this.quote = quote;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getQuote() {
        return quote;
    }
}
