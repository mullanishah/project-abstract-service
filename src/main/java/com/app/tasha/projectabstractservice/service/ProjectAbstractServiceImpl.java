package com.app.tasha.projectabstractservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.tasha.projectabstractservice.adapter.ProjectGroupAdapter;
import com.app.tasha.projectabstractservice.adapter.WorkflowAdapter;
import com.app.tasha.projectabstractservice.dao.ProjectAbstractServiceDao;
import com.app.tasha.projectabstractservice.pojo.ProjectAbstract;
import com.app.tasha.projectabstractservice.pojo.ProjectGroup;
import com.app.tasha.projectabstractservice.utils.ProjectAbstractConstants;

@Service
public class ProjectAbstractServiceImpl implements ProjectAbstractService {
	
	@Autowired
	private ProjectAbstractServiceDao projectAbstractDao;
	
	@Autowired
	private ProjectGroupAdapter groupAdapter;
	
	@Autowired
	private WorkflowAdapter workflowAdapter;
	
	/*
	 * call service to get groups
	 * call DAO and get abstract details from DB
	 * populate details 
	*/
	@Override
	public List<ProjectAbstract> getAllProjectAbstracts() {
		 
		Map<Long, ProjectGroup> projectGroupMap = getGroupDetails();
		List<ProjectAbstract> projectAbstracts = projectAbstractDao.getAllProjectAbstracts();
		projectAbstracts.forEach(projectAbstract -> {
			ProjectGroup group = projectGroupMap.get(projectAbstract.getGroupId());
			projectAbstract.setProjectGuide(group.getGuide());
			projectAbstract.setProjectGroupMembers(group.getProjectMembers());
			group.setGuide(null);
			group.setProjectMembers(null);
			projectAbstract.setProjectGroup(group);
		});
		return projectAbstracts;
	}
	
	/*
	 * call service to get groups
	 * call DAO and get abstract details from DB
	 * populate details 
	*/
	@Override
	public ProjectAbstract getProjectAbstract(Long abstractId) {
		ProjectAbstract projectAbstract = projectAbstractDao.getProjectAbstract(abstractId);
		Map<Long, ProjectGroup> projectGroupMap = getGroupDetails();
		ProjectGroup group = projectGroupMap.get(projectAbstract.getGroupId());
		projectAbstract.setProjectGuide(group.getGuide());
		projectAbstract.setProjectGroupMembers(group.getProjectMembers());
		group.setGuide(null);
		group.setProjectMembers(null);
		projectAbstract.setProjectGroup(group);
		return projectAbstract;
	}
	
	/*
	 * update correct workflow status 
	 * call DAO method
	 * return created object with id added
	 */
	@Override
	public ProjectAbstract createProjectAbstract(ProjectAbstract projectAbstract) {
		String nextStatus = getNextWorkflowStatus(ProjectAbstractConstants.STATUS_WIP, projectAbstract.getAction());
		projectAbstract.setStatus(nextStatus);
		ProjectAbstract abstractDao = projectAbstractDao.createProjectAbstract(projectAbstract);
		return abstractDao;
	}

	/*
	 * update correct status 
	 * call DAO method
	 * return updated object
	 */
	@Override
	public ProjectAbstract updateProjectAbstract(ProjectAbstract projectAbstract) {
		String nextStatus = getNextWorkflowStatus(projectAbstract.getStatus(), projectAbstract.getAction());
		projectAbstract.setStatus(nextStatus);
		ProjectAbstract abstractDao = projectAbstractDao.updateProjectAbstract(projectAbstract);
		return abstractDao;
	}

	@Override
	public String deleteProjectAbstract(ProjectAbstract projectAbstract) {
		String deleteStatus = projectAbstractDao.deleteProjectAbstract(projectAbstract.getId(), projectAbstract.getTopicName());
		return deleteStatus;
	}
	
	//call project-group service
	//map key and values
	private Map<Long, ProjectGroup> getGroupDetails() {
		Map<Long, ProjectGroup> projectGroupMap = new HashMap<Long, ProjectGroup>();
		List<ProjectGroup> projectGroups = groupAdapter.getProjectGroupDetails();
		projectGroups.forEach(group -> {
			projectGroupMap.put(group.getGroupId(), group);
		});
		return projectGroupMap;
	}
	
	private String getNextWorkflowStatus(String currentState, String action) {
		String status = workflowAdapter.getNextWorkflowStatus(currentState, action);
		return status;
	}

}
