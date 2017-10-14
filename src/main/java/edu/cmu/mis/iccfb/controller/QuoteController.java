package edu.cmu.mis.iccfb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.cmu.mis.iccfb.model.Quote;
import edu.cmu.mis.iccfb.service.QuoteService;

@RestController
public class QuoteController {
    
    @Autowired
    private QuoteService quoteService;
    
    
    @RequestMapping("/api/quote/random")
    public Quote random() {
        return quoteService.randomQuote();
    }
    
    @RequestMapping(value = "/api/quote", method = RequestMethod.POST)
    public void saveQuote(@RequestBody Quote quote) {        
        quoteService.save(quote);
    }
    
    @RequestMapping("/api/quote/author/{authorId}")
    public Iterable<Quote> getAuthor(@PathVariable Long authorId) {
        return this.quoteService.findByAuthorId(authorId);
    }

}
