package com.app.tasha.projectabstractservice.service;

import java.util.List;
import com.app.tasha.projectabstractservice.pojo.ProjectAbstract;

public interface ProjectAbstractService {
	
	public List<ProjectAbstract> getAllProjectAbstracts();
	
	public ProjectAbstract getProjectAbstract(Long abstractId);
	
	public ProjectAbstract createProjectAbstract(ProjectAbstract projectAbstract);
	
	public ProjectAbstract updateProjectAbstract(ProjectAbstract projectAbstract);
	
	public String deleteProjectAbstract(ProjectAbstract projectAbstract);
	
}
