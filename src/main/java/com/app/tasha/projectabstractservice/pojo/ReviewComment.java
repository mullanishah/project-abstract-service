package com.app.tasha.projectabstractservice.pojo;

import java.sql.Date;
import lombok.Data;

@Data
public class ReviewComment {
	private Long id;
	private Long abstractId;
	private String commentText;
	private String insertId;
	private Date insertTimestamp;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getAbstractId() {
		return abstractId;
	}
	
	public void setAbstractId(Long abstractId) {
		this.abstractId = abstractId;
	}
	
	public String getCommentText() {
		return commentText;
	}
	
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
	public String getInsertId() {
		return insertId;
	}
	
	public void setInsertId(String insertId) {
		this.insertId = insertId;
	}
	
	public Date getInsertTimestamp() {
		return insertTimestamp;
	}
	
	public void setInsertTimestamp(Date insertTimestamp) {
		this.insertTimestamp = insertTimestamp;
	}
	
	@Override
	public String toString() {
		return "ReviewComment [id=" + id + ", abstractId=" + abstractId + ", commentText=" + commentText + ", insertId="
				+ insertId + ", insertTimestamp=" + insertTimestamp + "]";
	}
	
}