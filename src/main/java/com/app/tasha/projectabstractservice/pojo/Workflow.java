package com.app.tasha.projectabstractservice.pojo;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Workflow {
	private int id;
	@NotNull
	private String featureName;
	@NotNull
	private String currentStatus;
	@NotNull
	private String action;
	private String nextStatus;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFeatureName() {
		return featureName;
	}
	
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	
	public String getCurrentStatus() {
		return currentStatus;
	}
	
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public String getNextStatus() {
		return nextStatus;
	}
	
	public void setNextStatus(String nextStatus) {
		this.nextStatus = nextStatus;
	}
	
	@Override
	public String toString() {
		return "Workflow [id=" + id + ", featureName=" + featureName + ", currentStatus=" + currentStatus + ", action="
				+ action + ", nextStatus=" + nextStatus + "]";
	}
}
