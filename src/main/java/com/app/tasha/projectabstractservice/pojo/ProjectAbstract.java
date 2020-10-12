package com.app.tasha.projectabstractservice.pojo;

import java.util.List;

import lombok.Data;

@Data
public class ProjectAbstract {
	private Long id;
	private Long groupId;
	private String topicName;
	private String problemStatement;
	private String category;
	private String abstractDescription;
	private String status;
	private String action;
	private ProjectGroup projectGroup;
	private List<Student> projectGroupMembers;
	private Faculty projectGuide;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getGroupId() {
		return groupId;
	}
	
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	public String getTopicName() {
		return topicName;
	}
	
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	public String getProblemStatement() {
		return problemStatement;
	}
	
	public void setProblemStatement(String problemStatement) {
		this.problemStatement = problemStatement;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getAbstractDescription() {
		return abstractDescription;
	}
	
	public void setAbstractDescription(String abstractDescription) {
		this.abstractDescription = abstractDescription;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public ProjectGroup getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(ProjectGroup projectGroup) {
		this.projectGroup = projectGroup;
	}

	public List<Student> getProjectGroupMembers() {
		return projectGroupMembers;
	}

	public void setProjectGroupMembers(List<Student> projectGroupMembers) {
		this.projectGroupMembers = projectGroupMembers;
	}

	public Faculty getProjectGuide() {
		return projectGuide;
	}

	public void setProjectGuide(Faculty projectGuide) {
		this.projectGuide = projectGuide;
	}

	@Override
	public String toString() {
		return "ProjectAbstract [id=" + id + ", groupId=" + groupId + ", topicName=" + topicName + ", problemStatement="
				+ problemStatement + ", category=" + category + ", abstractDescription=" + abstractDescription + ", status=" + status 
				+ ", action=" + action + ", projectGroup=" + projectGroup + ", projectGroupMembers=" + projectGroupMembers 
				+ ", projectGuide=" + projectGuide + "]";
	}
}
