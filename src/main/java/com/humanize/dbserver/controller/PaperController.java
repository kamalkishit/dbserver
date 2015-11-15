package com.humanize.dbserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.humanize.dbserver.data.Contents;
import com.humanize.dbserver.data.Paper;
import com.humanize.dbserver.service.PaperService;

@RestController
public class PaperController {
	
	@Autowired
	PaperService paperService;

	@RequestMapping("/paper/create")
	public ResponseEntity<Paper> create(@RequestBody Paper paper) {
		return new ResponseEntity<Paper>(paperService.create(paper), HttpStatus.OK);
	}
	
	@RequestMapping("/paper/find")
	public ResponseEntity<Contents> findByDate(@RequestParam("paperDate") String paperDate) {
		return new ResponseEntity<Contents>(paperService.findByDate(paperDate), HttpStatus.OK);
	}
}
