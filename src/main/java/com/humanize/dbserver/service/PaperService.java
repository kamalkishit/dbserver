package com.humanize.dbserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.data.Contents;
import com.humanize.dbserver.data.Paper;
import com.humanize.dbserver.exception.ContentNotFoundException;
import com.humanize.dbserver.exception.PaperCreationException;
import com.humanize.dbserver.exception.PaperNotFoundException;
import com.humanize.dbserver.exception.PaperUpdationException;

@Service
public class PaperService {
	
	@Autowired
	PaperRepositoryService repositoryService;
	
	@Autowired
	ContentService contentService;

	public Paper create(Paper paper) throws PaperCreationException {
		return repositoryService.create(paper);
	}
	
	public Paper update(Paper paper) throws PaperUpdationException {
		return repositoryService.update(paper);
	}
	
	public Contents findByDate(String paperDate) throws PaperNotFoundException, ContentNotFoundException {
		Paper paper = repositoryService.findByDate(paperDate);
		
		return contentService.findByIds(paper.getContentIds());
	}
}
