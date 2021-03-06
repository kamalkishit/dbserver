package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.ExceptionConfig;
import com.humanize.dbserver.dao.PaperRepository;
import com.humanize.dbserver.data.Paper;
import com.humanize.dbserver.exception.PaperCreationException;
import com.humanize.dbserver.exception.PaperNotFoundException;
import com.humanize.dbserver.exception.PaperUpdationException;

@Service
public class PaperRepositoryService {

	@Autowired
	PaperRepository repository;
	
	public Paper create(Paper paper) throws PaperCreationException {
		paper = repository.save(paper);
		
		if (paper == null) {
			throw new PaperCreationException(ExceptionConfig.PAPER_CREATION_ERROR_CODE, ExceptionConfig.PAPER_CREATION_EXCEPTION);
		}
		
		return paper;
	}
	
	public Paper update(Paper paper) throws PaperUpdationException {
		Paper tempPaper = repository.findByPaperDate(paper.getPaperDate());
		
		if (tempPaper == null) {
			throw new PaperUpdationException(ExceptionConfig.PAPER_UPDATION_ERROR_CODE, ExceptionConfig.PAPER_UPDATION_EXCEPTION);
		}
		
		tempPaper.setContentIds(paper.getContentIds());
		
		tempPaper = repository.save(tempPaper);
		
		if (tempPaper == null) {
			throw new PaperUpdationException(ExceptionConfig.PAPER_UPDATION_ERROR_CODE, ExceptionConfig.PAPER_UPDATION_EXCEPTION);
		}
		
		return tempPaper;
	}
	
	public Paper findByDate(String paperDate) throws PaperNotFoundException {
		Paper paper = repository.findByPaperDate(paperDate);
		
		if (paper == null) {
			throw new PaperNotFoundException(ExceptionConfig.PAPER_NOT_FOUND_ERROR_CODE, ExceptionConfig.PAPER_NOT_FOUND_EXCEPTION);
		}
		
		return paper;
	}
}
