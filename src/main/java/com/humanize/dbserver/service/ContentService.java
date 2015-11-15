package com.humanize.dbserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanize.dbserver.data.Content;
import com.humanize.dbserver.data.Contents;

@Service
public class ContentService {
	
	@Autowired
	private ContentRepositoryService repositoryService;

	public Content create(Content content) {
		return repositoryService.create(content);
	}
	
	public Content update(Content content) {
		return repositoryService.update(content);
	}
	
	public Contents findByCategory(String category) {
		return repositoryService.findByCategory(category);
	}
	
	public Contents findByCategory(String category, long createdDate, boolean refresh) {
		if (refresh) {
			return repositoryService.findNewByCategory(category, createdDate);
		}
		
		return repositoryService.findMoreByCategory(category, createdDate);
	}
	
	public Contents findByCategories(List<String> categories) {
		return repositoryService.findByCategories(categories);
	}
	
	public Contents findByCategories(List<String> categories, long createdDate, boolean refresh) {
		if (refresh) {
			return repositoryService.findNewByCategories(categories, createdDate);
		}
		
		return repositoryService.findMoreByCategories(categories, createdDate);
	}
	
	public Contents findByIds(List<String> ids) {
		return repositoryService.findByIds(ids);
	}

/*
	
	public List<Content> findByCategory(String category) {
		Pageable pageRequest = createPagination(Direction.DESC, "createdDate");
		
		return repository.findAllByCategory(category, pageRequest);
	}
	
	public List<Content> findByCategoryCreatedDateLessThan(String category, long createdDate) {
		Pageable pageRequest = createPagination(Direction.DESC, "createdDate");
		
		return repository.findAllByCategoryCreatedDateLessThan(category, createdDate, pageRequest);
	}
	
	public List<Content> findByCategories(ArrayList<String> categories) {
		Pageable pageRequest = createPagination(Direction.DESC, "createdDate");
		
		return repository.findAllByCategories(categories, pageRequest);
	}

	public ArrayList<Content> getContent() {
		Pageable pageRequest = createPagination(Direction.DESC, "createdDate");
		Page<Content> contents = repository.findAll(pageRequest);

		if (contents != null) {
			return new ArrayList<Content>(contents.getContent());
		}

		return null;
	}
	
	public ArrayList<Content> getContents(List<String> categories) {
		Pageable pageRequest = new PageRequest(0, 20, new Sort(new Order(
				Direction.DESC, "createdDate")));
		List<Content> contents = repository.findAllByCategories(categories, pageRequest);

		if (contents != null) {
			return new ArrayList<Content>(contents);
		}

		return null;
	}

	public List<Content> getMoreContent(long startDate) {
		Pageable pageRequest = new PageRequest(0, 20, new Sort(Direction.DESC,
				"createdDate"));
		List<Content> contents = repository.findByCreatedDateLessThan(
				startDate, pageRequest);

		if (contents != null) {
			return contents;
		}

		return null;
	}
	
	public List<Content> getMoreContents(List<String> categories, long startDate) {
		Pageable pageRequest = new PageRequest(0, 20, new Sort(Direction.DESC,
				"createdDate"));
		List<Content> contents = repository.findAllByCategoriesCreatedDateLessThan(categories, 
				startDate, pageRequest);

		if (contents != null) {
			return contents;
		}

		return null;
	}

	public List<Content> getNewContent(long endDate) {
		Pageable pageRequest = new PageRequest(0, 20, new Sort(Direction.DESC,
				"createdDate"));
		List<Content> contents = repository.findByCreatedDateGreaterThan(
				endDate, pageRequest);

		if (contents != null) {
			return contents;
		}

		return null;
	}
	
	public List<Content> getNewContents(List<String> categories, long endDate) {
		Pageable pageRequest = createPagination(Direction.DESC, "createdDate");
		List<Content> contents = repository.findAllByCategoriesCreatedDateGreaterThan(categories, 
				endDate, pageRequest);

		if (contents != null) {
			return contents;
		}

		return null;
	}
	
	private Pageable createPagination(Direction direction, String field) {
		Pageable pageRequest = new PageRequest(0, 20, new Sort(direction,
				field));
		
		return pageRequest;
	}*/
}
