package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.data.Contents;
import com.humanize.dbserver.data.Paper;

@Service
public class PaperService {
	
	@Autowired
	PaperRepositoryService repositoryService;
	
	@Autowired
	ContentService contentService;
	
	@Autowired
	InputValidationService inputValidator;

	public Paper create(Paper paper) {
		inputValidator.validatePaper(paper);
		return repositoryService.create(paper);
	}
	
	public Paper update(Paper paper) {
		inputValidator.validatePaper(paper);
		return repositoryService.update(paper);
	}
	
	public Contents findByDate(String paperDate) {
		inputValidator.validatePaperDate(paperDate);
		Paper paper = repositoryService.findByDate(paperDate);
		
		return contentService.findByIds(paper.getContentIds());
	}
}
