package edu.cmu.mis.iccfb;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.cmu.mis.iccfb.model.Quote;
import edu.cmu.mis.iccfb.service.QuoteService;

@Configuration
public class SeedData {
    
    @Autowired
    private QuoteService quoteService;

    @Bean
    public SeedData getBean() throws SQLException {
    	
        Quote q1 = new Quote(
                "The world is a thing of utter inordinate complexity and richness " +
                "and strangeness that is absolutely awesome",
                "https://en.wikiquote.org/wiki/Douglas_Adams", 
                1L);
        
        Quote q2 = new Quote(
                "As rain breaks through an ill-thatched house, passion will break through an unreflecting mind.", 
                "https://en.wikiquote.org/wiki/Gautama_Buddha", 
                2L);
        
        Quote q3 = new Quote(
                "I think that only daring speculation can lead us further and not accumulation of facts.", 
                "https://en.wikiquote.org/wiki/Albert_Einstein", 
                3L);
        
        quoteService.save(q1);
        quoteService.save(q2);
        quoteService.save(q3);
        
//        log.info("Quoates found with findAll():");
//        log.info("-------------------------------");
//        for (Quote m : quoteService.findAll()) {
//            log.info(m.toString());
//        }
        return new SeedData();
    }
}
