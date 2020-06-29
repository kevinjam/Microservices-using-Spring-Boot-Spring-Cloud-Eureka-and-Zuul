package com.kevinjanvier.stock.dbservice.repository;

import com.kevinjanvier.stock.dbservice.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote,Integer > {
    List<Quote> findByUsername(String username);
}
