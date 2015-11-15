package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.dao.PaperRepository;
import com.humanize.dbserver.data.Paper;

@Service
public class PaperRepositoryService {

	@Autowired
	PaperRepository repository;
	
	public Paper create(Paper paper) {
		paper = repository.save(paper);
		
		if (paper == null) {
			
		}
		
		return paper;
	}
	
	public Paper findByDate(String paperDate) {
		Paper paper = repository.findByPaperDate(paperDate);
		
		if (paper == null) {
			
		}
		
		return paper;
	}
}
