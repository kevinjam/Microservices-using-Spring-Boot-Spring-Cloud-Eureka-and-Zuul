package com.kevinjanvier.stock.dbservice.resource;

import com.kevinjanvier.stock.dbservice.model.Quote;
import com.kevinjanvier.stock.dbservice.model.Quotes;
import com.kevinjanvier.stock.dbservice.repository.QuoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {


    private final QuoteRepository quotesRepository;

    public DbServiceResource(QuoteRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username")
                                          String username) {

        return getQuotesByUserName(username);

    }

    private List<String> getQuotesByUserName(@PathVariable("username") String username) {
        return quotesRepository.findByUsername(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList())

                ;
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes) {
        quotes.getQuotes()
                .stream()
                .map(quote -> new Quote(quotes.getUsername(), quote))
                .forEach(quotesRepository::save);
        return getQuotesByUserName(quotes.getUsername());
    }

    @DeleteMapping("delete/{username}")
    public List<String> delete(@PathVariable("username") final String username) {
        List<Quote> quotes = quotesRepository.findByUsername(username);
        quotesRepository.deleteInBatch(quotes);
        return getQuotesByUserName(username);
    }
}
