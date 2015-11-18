package com.humanize.dbserver.service;

import org.springframework.stereotype.Service;

import com.humanize.dbserver.ExceptionConfig;
import com.humanize.dbserver.data.Paper;
import com.humanize.dbserver.exception.NullPaperDateException;
import com.humanize.dbserver.exception.NullPaperException;

@Service
public class InputValidationService {

	public void validatePaper(Paper paper) {
		if (paper == null) {
			throw new NullPaperException(ExceptionConfig.NULL_PAPER_ERROR_CODE, ExceptionConfig.NULL_PAPER_EXCEPTION);
		}
		
		validatePaperDate(paper.getPaperDate());
	}
	
	public void validatePaperDate(String paperDate) {
		if (paperDate == null) {
			throw new NullPaperDateException(ExceptionConfig.NULL_PAPER_DATE_ERROR_CODE, ExceptionConfig.NULL_PAPER_DATE_EXCEPTION);
		}
	}
}
