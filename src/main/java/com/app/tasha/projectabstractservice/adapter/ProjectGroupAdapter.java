package com.app.tasha.projectabstractservice.adapter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.app.tasha.projectabstractservice.pojo.ProjectGroup;

@Component
public class ProjectGroupAdapter {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<ProjectGroup> getProjectGroupDetails() {
		String url = "http://192.168.1.6:9012/groups/summary";
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Authorization", "Simple");
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity<List<ProjectGroup>> httpEntity = new HttpEntity<List<ProjectGroup>>(requestHeaders);
		
		try {
			ResponseEntity<List<ProjectGroup>> response = restTemplate.exchange(
					url, 
					HttpMethod.GET, 
					httpEntity, 
					new ParameterizedTypeReference<List<ProjectGroup>>() {}
			);
			if(response.getStatusCode().is2xxSuccessful())
				return response.getBody();
		}catch (Exception e) {
			System.out.println("Error in fetching project group details");
			e.printStackTrace();
		}	
		return null;
	}
}
