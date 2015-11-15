package com.humanize.dbserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.dao.ContentRepository;
import com.humanize.dbserver.data.Content;
import com.humanize.dbserver.data.Contents;

@Service
public class ContentRepositoryService {
	
	@Autowired
	ContentRepository repository;
	
	public Content create(Content content) {
		content = repository.save(content);
		
		if (content == null) {
			
		}
		
		return content;
	}
	
	public Content update(Content content) {
		content = repository.save(content);
		
		if (content == null) {
			
		}
		
		return content;
	}
	
	public Contents findByCategory(String category) {
		Pageable pageRequest = createPagination(Direction.DESC, "createdDate");
		
		List<Content> contents = repository.findByCategory(category, pageRequest);
		
		if (contents != null && contents.size() > 0) {
			return new Contents(contents);
		}
		
		return null;
	}
	
	public Contents findNewByCategory(String category, long createdDate) {
		Pageable pageRequest = createPagination(Direction.DESC, "createdDate");
		
		List<Content> contents = repository.findNewByCategory(category, createdDate, pageRequest);
		
		if (contents != null && contents.size() > 0) {
			return new Contents(contents);
		}
		
		return null;
	}
	
	public Contents findMoreByCategory(String category, long createdDate) {
		Pageable pageRequest = createPagination(Direction.DESC, "createdDate");
		
		List<Content> contents = repository.findMoreByCategory(category, createdDate, pageRequest);
		
		if (contents != null && contents.size() > 0) {
			return new Contents(contents);
		}
		
		return null;
	}
	
	public Contents findByCategories(List<String> categories) {
		Pageable pageRequest = createPagination(Direction.DESC, "createdDate");
		
		List<Content> contents = repository.findByCategories(categories, pageRequest);
		
		if (contents != null && contents.size() > 0) {
			return new Contents(contents);
		}
		
		return null;
	}
	
	public Contents findNewByCategories(List<String> categories, long createdDate) {
		Pageable pageRequest = createPagination(Direction.DESC, "createdDate");
		
		List<Content> contents = repository.findNewByCategories(categories, createdDate, pageRequest);
		
		if (contents != null && contents.size() > 0) {
			return new Contents(contents);
		}
		
		return null;
	}
	
	public Contents findMoreByCategories(List<String> categories, long createdDate) {
		Pageable pageRequest = createPagination(Direction.DESC, "createdDate");
		
		List<Content> contents = repository.findMoreByCategories(categories, createdDate, pageRequest);
		
		if (contents != null && contents.size() > 0) {
			return new Contents(contents);
		}
		
		return null;
	}
	
	public Contents findByIds(List<String> ids) {
		List<Content> contents = repository.findAll(ids);
		
		if (contents != null && contents.size() >0) {
			return new Contents(contents);
		}
		
		return null;
	}
	
	private Pageable createPagination(Direction direction, String field) {
		Pageable pageRequest = new PageRequest(0, 20, new Sort(direction,
				field));
		
		return pageRequest;
	}

}
