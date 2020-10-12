package com.app.tasha.projectabstractservice.utils;

public class ProjectAbstractConstants {

	public static String GET_ALL_PROJECT_ABSTRACTS = "select * from project_abstract";
	
	public static String GET_PROJECT_ABSTRACT = "select * from project_abstract where project_group_id=?";
	
	public static String CREATE_PROJECT_ABSTRACT = "insert into project_abstract(project_group_id, topic_name, "
			+ "problem_statement, topic_category, abstract_data, status) values(?, ?, ?, ?, ?, ?)";
	
	public static String UPDATE_PROJECT_ABSTRACT = "update project_abstract set project_group_id=?, topic_name=?, problem_statement=?, "
			+ "topic_category=?, abstract_data=?, status=? where project_group_id=?";
	
	public static String DELETE_PROJECT_ABSTRACT = "delete from project_abstract where project_group_id=? and topic_name=?";
	
	// ------------------- Task Status ------------------- // 
	public final static String WIP = "Work In Progress";
	
	public final static String AWAITING_APPROVAL = "Awaiting Approval";
	
	public final static String APPROVED = "Approved";
	
	public final static String REWORK_NEEDED = "Rework Needed";
	
	// ------------------- Task Delete ------------------- //
	public static String DELETE_SUCCESS = "Abstract deleted successfully";

	public static String DELETE_FAILURE = "Error occurred while deleting abstract";

}
