package com.kevinjanvier.stock.dbservice.model;

import java.util.List;

public class Quotes {

    private String username;
    private List<String> quotes;

    public Quotes() {
    }

    public Quotes(String username, List<String> quotes) {
        this.username = username;
        this.quotes = quotes;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getQuotes() {
        return quotes;
    }
}
