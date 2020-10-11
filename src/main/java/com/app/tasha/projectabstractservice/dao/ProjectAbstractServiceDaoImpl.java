package com.app.tasha.projectabstractservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.app.tasha.projectabstractservice.pojo.ProjectAbstract;
import com.app.tasha.projectabstractservice.utils.DatabaseUtils;
import com.app.tasha.projectabstractservice.utils.ProjectAbstractConstants;

@Repository
public class ProjectAbstractServiceDaoImpl implements ProjectAbstractServiceDao {
	
	private Connection connection;
	private PreparedStatement pst_getAllAbstracts;
	
	public ProjectAbstractServiceDaoImpl() throws Exception {
		connection = DatabaseUtils.getConnection();
		pst_getAllAbstracts = connection.prepareStatement(ProjectAbstractConstants.GET_ALL_PROJECT_ABSTRACTS);
	}

	// CRUD methods
	@Override
	public List<ProjectAbstract> getAllProjectAbstracts() {
		List<ProjectAbstract> projectAbstracts = new ArrayList<ProjectAbstract>(10);
		try {
			ResultSet rst = pst_getAllAbstracts.executeQuery();
			while(rst.next()) {
				ProjectAbstract projectAbstract = new ProjectAbstract();
				projectAbstract.setId(rst.getLong("id"));
				projectAbstract.setGroupId(rst.getLong("project_group_id"));
				projectAbstract.setTopicName(rst.getString("topic_name"));
				projectAbstract.setProblemStatement(rst.getString("problem_statement"));
				projectAbstract.setCategory(rst.getString("topic_category"));
				projectAbstract.setAbstractDescription(rst.getString("abstract_data"));
				projectAbstract.setStatus(rst.getString("status"));
				projectAbstracts.add(projectAbstract);
			}
		} catch (Exception e) {
			System.out.println("Error in getting project abstract details");
		}
		return projectAbstracts;
	}
	

}
