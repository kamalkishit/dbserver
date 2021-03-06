package com.humanize.dbserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.ExceptionConfig;
import com.humanize.dbserver.dao.ContentRepository;
import com.humanize.dbserver.data.Content;
import com.humanize.dbserver.data.Contents;
import com.humanize.dbserver.exception.ContentCreationException;
import com.humanize.dbserver.exception.ContentNotFoundException;
import com.humanize.dbserver.exception.ContentUpdationException;

@Service
public class ContentRepositoryService {
	
	@Autowired
	ContentRepository repository;
	
	public Content create(Content content) throws ContentCreationException {
		content = repository.save(content);
		
		if (content == null) {
			throw new ContentCreationException(ExceptionConfig.CONTENT_CREATION_ERROR_CODE, ExceptionConfig.CONTENT_CREATION_EXCEPTION);
		}
		
		return content;
	}
	
	public Content update(Content content) throws ContentUpdationException {
		content = repository.save(content);
		
		if (content == null) {
			throw new ContentUpdationException(ExceptionConfig.CONTENT_UPDATION_ERROR_CODE, ExceptionConfig.CONTENT_UPDATION_EXCEPTION);
		}
		
		return content;
	}
	
	public Contents findByCategories(List<String> categories) throws ContentNotFoundException {
		Pageable pageRequest = createPagination(Direction.DESC, "createdDate");
		
		List<Content> contents = repository.findByCategories(categories, pageRequest);
		
		if (contents != null && contents.size() > 0) {
			return new Contents(contents);
		}
		
		throw new ContentNotFoundException(ExceptionConfig.CONTENT_NOT_FOUND_ERROR_CODE, ExceptionConfig.CONTENT_NOT_FOUND_EXCEPTION);
	}
	
	public Contents findNewByCategories(List<String> categories, long createdDate) throws ContentNotFoundException {
		Pageable pageRequest = createPagination(Direction.DESC, "createdDate");
		
		List<Content> contents = repository.findNewByCategories(categories, createdDate, pageRequest);
		
		if (contents != null && contents.size() > 0) {
			return new Contents(contents);
		}
		
		throw new ContentNotFoundException(ExceptionConfig.CONTENT_NOT_FOUND_ERROR_CODE, ExceptionConfig.CONTENT_NOT_FOUND_EXCEPTION);
	}
	
	public Contents findMoreByCategories(List<String> categories, long createdDate) throws ContentNotFoundException {
		Pageable pageRequest = createPagination(Direction.DESC, "createdDate");
		
		List<Content> contents = repository.findMoreByCategories(categories, createdDate, pageRequest);
		
		if (contents != null && contents.size() > 0) {
			return new Contents(contents);
		}
		
		throw new ContentNotFoundException(ExceptionConfig.CONTENT_NOT_FOUND_ERROR_CODE, ExceptionConfig.CONTENT_NOT_FOUND_EXCEPTION);
	}
	
	public Contents findByIds(List<String> ids) throws ContentNotFoundException {
		List<Content> contents = repository.findAll(ids);
		
		if (contents != null && contents.size() >0) {
			return new Contents(contents);
		}
		
		throw new ContentNotFoundException(ExceptionConfig.CONTENT_NOT_FOUND_ERROR_CODE, ExceptionConfig.CONTENT_NOT_FOUND_EXCEPTION);
	}
	
	private Pageable createPagination(Direction direction, String field) {
		Pageable pageRequest = new PageRequest(0, 20, new Sort(direction,
				field));
		
		return pageRequest;
	}

}
