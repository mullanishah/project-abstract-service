package com.app.tasha.projectabstractservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.app.tasha.projectabstractservice.pojo.ProjectAbstract;
import com.app.tasha.projectabstractservice.utils.DatabaseUtils;
import com.app.tasha.projectabstractservice.utils.ProjectAbstractConstants;

@Repository
public class ProjectAbstractServiceDaoImpl implements ProjectAbstractServiceDao {
	
	private Connection connection;
	private PreparedStatement pst_getAllAbstracts, pst_getAbstract, pst_addAbstract, pst_updateAbstract, pst_deleteAbstract;
	
	public ProjectAbstractServiceDaoImpl() throws Exception {
		connection = DatabaseUtils.getConnection();
		pst_getAllAbstracts = connection.prepareStatement(ProjectAbstractConstants.GET_ALL_PROJECT_ABSTRACTS);
		pst_getAbstract = connection.prepareStatement(ProjectAbstractConstants.GET_PROJECT_ABSTRACT);
		pst_addAbstract = connection.prepareStatement(ProjectAbstractConstants.CREATE_PROJECT_ABSTRACT, Statement.RETURN_GENERATED_KEYS);
		pst_updateAbstract = connection.prepareStatement(ProjectAbstractConstants.UPDATE_PROJECT_ABSTRACT, Statement.RETURN_GENERATED_KEYS);
		pst_deleteAbstract = connection.prepareStatement(ProjectAbstractConstants.DELETE_PROJECT_ABSTRACT);
	}
	
	public void cleanUp() throws Exception {
		if(null != pst_deleteAbstract)
			pst_deleteAbstract.close();
		if(null != pst_updateAbstract)
			pst_updateAbstract.close();
		if(null != pst_addAbstract)
			pst_addAbstract.close();
		if(null != pst_getAbstract)
			pst_getAbstract.close();
		if(null != pst_getAllAbstracts)
			pst_getAllAbstracts.close();
		if(null != connection)
			connection.close();
	}

	//--------------- CRUD methods ------------------//
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
			e.printStackTrace();
		}
		return projectAbstracts;
	}

	@Override
	public ProjectAbstract getProjectAbstract(Long abstractId) {
		ProjectAbstract projectAbstract = new ProjectAbstract();
		try {
			pst_getAbstract.setLong(1, abstractId);
			ResultSet rst = pst_getAbstract.executeQuery();
			while(rst.next()) {
				projectAbstract.setId(rst.getLong("id"));
				projectAbstract.setGroupId(rst.getLong("project_group_id"));
				projectAbstract.setTopicName(rst.getString("topic_name"));
				projectAbstract.setProblemStatement(rst.getString("problem_statement"));
				projectAbstract.setCategory(rst.getString("topic_category"));
				projectAbstract.setAbstractDescription(rst.getString("abstract_data"));
				projectAbstract.setStatus(rst.getString("status"));
			}
		} catch (Exception e) {
			System.out.println("Error in getting project abstract");
			e.printStackTrace();
		}
		return projectAbstract;
	}

	@Override
	public ProjectAbstract createProjectAbstract(ProjectAbstract projectAbstract) {
		long generatedAbstractId;
		try {
			pst_addAbstract.setLong(1, projectAbstract.getGroupId());
			pst_addAbstract.setString(2, projectAbstract.getTopicName());
			pst_addAbstract.setString(3, projectAbstract.getProblemStatement());
			pst_addAbstract.setString(4, projectAbstract.getCategory());
			pst_addAbstract.setString(5, projectAbstract.getAbstractDescription());
			pst_addAbstract.setString(6, projectAbstract.getStatus());
			int status = pst_addAbstract.executeUpdate();
			if(status == 1) {
				ResultSet rst = pst_addAbstract.getGeneratedKeys();
				if(rst.next()) {
					generatedAbstractId = rst.getLong(1);
					projectAbstract.setId(generatedAbstractId);
				}
			}
		}catch (Exception e) {
			System.out.println("Error in adding project abstract");
			e.printStackTrace();
		}
		return projectAbstract;
	}

	@Override
	public ProjectAbstract updateProjectAbstract(ProjectAbstract projectAbstract) {
		long generatedAbstractId;
		try {
			pst_updateAbstract.setLong(1, projectAbstract.getGroupId());
			pst_updateAbstract.setString(2, projectAbstract.getTopicName());
			pst_updateAbstract.setString(3, projectAbstract.getProblemStatement());
			pst_updateAbstract.setString(4, projectAbstract.getCategory());
			pst_updateAbstract.setString(5, projectAbstract.getAbstractDescription());
			pst_updateAbstract.setString(6, projectAbstract.getStatus());
			pst_updateAbstract.setLong(7, projectAbstract.getGroupId());
			int status = pst_updateAbstract.executeUpdate();
			if(status == 1) {
				ResultSet rst = pst_updateAbstract.getGeneratedKeys();
				if(rst.next()) {
					generatedAbstractId = rst.getLong(1);
					projectAbstract.setId(generatedAbstractId);
				}
			}
		}catch (Exception e) {
			System.out.println("Error in updating project abstract");
			e.printStackTrace();
		}
		return projectAbstract;
	}

	@Override
	public String deleteProjectAbstract(Long abstractId, String topicName) {
		String deleteResult = null;
		try {
			pst_deleteAbstract.setLong(1, abstractId);
			pst_deleteAbstract.setString(2, topicName);
			int status = pst_deleteAbstract.executeUpdate();
			if(status == 1)
				deleteResult = ProjectAbstractConstants.DELETE_SUCCESS;
			else
				deleteResult = ProjectAbstractConstants.DELETE_FAILURE;
		}catch (Exception e) {
			System.out.println("Error in deleting project abstract");
			if (e instanceof SQLException) 
				e.printStackTrace();
			else
				e.printStackTrace();
		}
		return deleteResult;
	}
	
}
