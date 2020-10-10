package com.app.tasha.projectabstractservice.pojo;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ProjectGroup {
	private Long id;
	private Long groupId;
	private String groupName;
	private ArrayList<Student> projectMembers;
	private Faculty guide;
	
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
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public ArrayList<Student> getProjectMembers() {
		return projectMembers;
	}
	
	public void setProjectMembers(ArrayList<Student> projectMembers) {
		this.projectMembers = projectMembers;
	}
	
	public Faculty getGuide() {
		return guide;
	}
	
	public void setGuide(Faculty guide) {
		this.guide = guide;
	}
	
	@Override
	public String toString() {
		return "ProjectGroup [id=" + id + ", groupId=" + groupId + ", groupName=" + groupName + ", projectMembers="
				+ projectMembers + ", guide=" + guide + "]";
	}
}

