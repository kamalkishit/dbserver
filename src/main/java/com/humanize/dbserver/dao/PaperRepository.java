package com.humanize.dbserver.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.humanize.dbserver.data.Paper;
import com.humanize.dbserver.data.User;

public interface PaperRepository extends MongoRepository<Paper, String> {

	public Paper findByPaperDate(String paperDate);
}