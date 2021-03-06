package com.humanize.dbserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.humanize.dbserver.data.Content;
import com.humanize.dbserver.data.Contents;
import com.humanize.dbserver.exception.ContentCreationException;
import com.humanize.dbserver.exception.ContentNotFoundException;
import com.humanize.dbserver.exception.ContentUpdationException;
import com.humanize.dbserver.service.ContentService;

public class ContentController {

	@Autowired
	ContentService contentService;

	@RequestMapping("/content/create")
	public ResponseEntity<Content> create(@RequestBody Content content) throws ContentCreationException {
		return new ResponseEntity<Content>(contentService.create(content), HttpStatus.OK);
	}
	
	@RequestMapping("/content/update")
	public ResponseEntity<Content> update(@RequestBody Content content) throws ContentUpdationException {
		return new ResponseEntity<Content>(contentService.update(content), HttpStatus.OK);
	}
	
	@RequestMapping("/content/find/categories")
	public ResponseEntity<Contents> findByCategories(@RequestParam List<String> categories, @RequestParam(value= "createdDate", required= false) long createdDate, @RequestParam(value= "refresh", required= false, defaultValue= "false") boolean refresh) 
		throws ContentNotFoundException {
		return new ResponseEntity<Contents>(contentService.findByCategories(categories, createdDate, refresh), HttpStatus.OK);
	}
}
