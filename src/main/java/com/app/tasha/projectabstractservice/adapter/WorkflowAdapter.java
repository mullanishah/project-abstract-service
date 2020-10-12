package com.app.tasha.projectabstractservice.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.app.tasha.projectabstractservice.pojo.Workflow;
import com.app.tasha.projectabstractservice.utils.ProjectAbstractConstants;

@Component
public class WorkflowAdapter {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String serviceUrl = "http://192.168.1.6:9010/workflow/nextState";
	
	public String getNextWorkflowStatus(String currentStatus, String action) {
		Workflow workflow = populateWorkflow(currentStatus, action);
		//httpHeaders
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		requestHeaders.add("Authorization", "Simple");
		//httpEntity
		HttpEntity<Workflow> httpEntity = new HttpEntity<Workflow>(workflow, requestHeaders);
		//exchange method call
		try {
			ResponseEntity<String> responseEntity = restTemplate.exchange(
						serviceUrl, 
						HttpMethod.POST, 
						httpEntity, 
						String.class
			);
			if(responseEntity.getStatusCode().equals(HttpStatus.OK)) {
				return responseEntity.getBody();
			}
		}catch (Exception e) {
			System.out.println("Error in fetching workflow details");
			e.printStackTrace();
		}
		return null;
	}
	
	private Workflow populateWorkflow(String currentStatus, String action) {
		Workflow workflow = new Workflow();
		workflow.setFeatureName(ProjectAbstractConstants.ABSTRACT_FEATURE);
		workflow.setCurrentStatus(currentStatus);
		workflow.setAction(action);
		return workflow;
	}
}
