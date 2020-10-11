package com.app.tasha.projectabstractservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.tasha.projectabstractservice.adapter.ProjectGroupAdapter;
import com.app.tasha.projectabstractservice.dao.ProjectAbstractServiceDao;
import com.app.tasha.projectabstractservice.pojo.ProjectAbstract;
import com.app.tasha.projectabstractservice.pojo.ProjectGroup;

@Service
public class ProjectAbstractServiceImpl implements ProjectAbstractService {
	@Autowired
	private ProjectAbstractServiceDao projectAbstractDao;
	@Autowired
	private ProjectGroupAdapter groupAdapter;
	
	@Override
	public List<ProjectAbstract> getAllProjectAbstracts() {
		//call service to get groups 
		Map<Long, ProjectGroup> projectGroupMap = getGroupDetails();
		//get abstract details calling dao
		List<ProjectAbstract> projectAbstracts = projectAbstractDao.getAllProjectAbstracts();
		//populate details
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
	
	private Map<Long, ProjectGroup> getGroupDetails() {
		Map<Long, ProjectGroup> projectGroupMap = new HashMap<Long, ProjectGroup>();
		//call project-group service
		List<ProjectGroup> projectGroups = groupAdapter.getProjectGroupDetails();
		//map key and values
		projectGroups.forEach(group -> {
			projectGroupMap.put(group.getGroupId(), group);
		});
		return projectGroupMap;
	}

}
