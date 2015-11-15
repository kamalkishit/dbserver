package com.humanize.dbserver.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.humanize.dbserver.data.Content;

public interface ContentRepository extends MongoRepository<Content, String> {
	
	@Query("{ 'category': ?0 }")
	public List<Content> findByCategory(String category, Pageable pageRequest);
	
	@Query("{ 'category': ?0, 'createdDate': { $gt : ?1 }}")
	public List<Content> findNewByCategory(String category, long createdDate,
			Pageable pageRequest);
	
	@Query("{ 'category': ?0, 'createdDate': { $lt : ?1 }}")
	public List<Content> findMoreByCategory(String category, long createdDate,
			Pageable pageRequest);

	@Query("{ 'category': { $in: ?0 }}")
	public List<Content> findByCategories(List<String> categories, Pageable pageRequest);
	
	@Query("{ 'category': { $in: ?0 }, 'createdDate': { $gt : ?1 }}")
	public List<Content> findNewByCategories(List<String> categories, long createdDate,
			Pageable pageRequest);
	
	@Query("{ 'category': { $in: ?0 }, 'createdDate': { $lt : ?1 }}")
	public List<Content> findMoreByCategories(List<String> categories, long createdDate,
			Pageable pageRequest);
	
	public List<Content> findAll(Iterable<String> ids);
	

}
