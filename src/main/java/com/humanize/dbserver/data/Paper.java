package com.humanize.dbserver.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

public class Paper {
	
	@Id
	private String id;
	
	@NotEmpty
	@Indexed(unique = true)
	private String paperDate;
	
	private List<String> contentIds;
	
	@CreatedDate
	private long createdDate; 

	@LastModifiedDate
	private long lastModifiedDate;
	
	public Paper() {
		paperDate = null;
		contentIds = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getContentIds() {
		return contentIds;
	}

	public void setContentIds(List<String> contentIds) {
		this.contentIds = contentIds;
	}

	public String getPaperDate() {
		return paperDate;
	}

	public void setPaperDate(String paperDate) {
		this.paperDate = paperDate;
	}

	public long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}

	public long getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(long lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}