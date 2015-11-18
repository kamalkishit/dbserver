package com.humanize.dbserver;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.humanize.dbserver.exception.Exception;
import com.humanize.dbserver.exception.NullPaperDateException;
import com.humanize.dbserver.exception.NullPaperException;
import com.humanize.dbserver.exception.PaperCreationException;
import com.humanize.dbserver.exception.PaperNotFoundException;
import com.humanize.dbserver.exception.PaperUpdationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NullPaperException.class)
	@ResponseBody
	public Exception handleNullEmailIdException(NullPaperException exception) {
		return new Exception(exception.getErrorCode(), exception.getErrorMsg());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NullPaperDateException.class)
	@ResponseBody
	public Exception handleNullEmailIdException(NullPaperDateException exception) {
		return new Exception(exception.getErrorCode(), exception.getErrorMsg());
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(PaperCreationException.class)
	@ResponseBody
	public Exception handleNullEmailIdException(PaperCreationException exception) {
		return new Exception(exception.getErrorCode(), exception.getErrorMsg());
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(PaperUpdationException.class)
	@ResponseBody
	public Exception handleNullEmailIdException(PaperUpdationException exception) {
		return new Exception(exception.getErrorCode(), exception.getErrorMsg());
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(PaperNotFoundException.class)
	@ResponseBody
	public Exception handleNullEmailIdException(PaperNotFoundException exception) {
		return new Exception(exception.getErrorCode(), exception.getErrorMsg());
	}
}