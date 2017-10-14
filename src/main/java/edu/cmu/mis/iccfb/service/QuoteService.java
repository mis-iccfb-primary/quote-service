package edu.cmu.mis.iccfb.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.cmu.mis.iccfb.model.Quote;

public interface QuoteService extends CrudRepository<Quote, Long>, QuoteServiceCustom {
	public List<Quote> findByAuthorId(Long authorId);
}
