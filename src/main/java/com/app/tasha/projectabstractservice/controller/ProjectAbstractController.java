package com.app.tasha.projectabstractservice.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.tasha.projectabstractservice.pojo.ProjectAbstract;
import com.app.tasha.projectabstractservice.service.ProjectAbstractService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "abstract")
public class ProjectAbstractController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProjectAbstractController.class);

	@Autowired
	private ProjectAbstractService projectAbstractService;
	
	@GetMapping(value = "summary", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get all project abstracts")
	public ResponseEntity<List<ProjectAbstract>> getAllProjectAbstract(@RequestHeader Map<String, String> requestHeaders) {
		
		LOG.info("event=GET_ALL_PROJECT_ABSTRACT_DETAILS");
		List<ProjectAbstract> projectAbstracts = projectAbstractService.getAllProjectAbstracts();
		ResponseEntity<List<ProjectAbstract>> responseEntity = new ResponseEntity<List<ProjectAbstract>>(projectAbstracts, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value = "byId", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get a project abstract by Id provided")
	public ResponseEntity<Object> getProjectAbstract(@RequestHeader Map<String, String> requestHeaders, 
															  @RequestParam(required = true) Long abstractId) {
		LOG.info("event=GET_PROJECT_ABSTRACT_BY_ID");
		if(abstractId == null) {
			return new ResponseEntity<Object>("Abstract Id should not be null", HttpStatus.OK);
		}
		ProjectAbstract projectAbstract = projectAbstractService.getProjectAbstract(abstractId);
		return new ResponseEntity<Object>(projectAbstract, HttpStatus.OK);
	}
	
	@PostMapping(value = "create", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create new project abstract")
	public ResponseEntity<ProjectAbstract> createProjectAbstract(@RequestHeader Map<String, String> requestHeaders,
																 @RequestBody ProjectAbstract projectAbstract) {
		LOG.info("event=CREATE_PROJECT_ABSTRACT");
		return null;
	}
	
	@PutMapping(value = "update", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update project abstract")
	public ResponseEntity<ProjectAbstract> updateProjectAbstract(@RequestHeader Map<String, String> requestHeaders,
			 													 @RequestBody ProjectAbstract projectAbstract){
		return null;
	}
	
	@DeleteMapping(value = "delete/{abstractId}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Delete project abstract")
	public ResponseEntity<ProjectAbstract> deleteProjectAbstract(@RequestHeader Map<String, String> requestHeaders,
																 @PathVariable(value = "abstractId") Long abstractId){
		return null;
	}
	
	@GetMapping(value = "hello")
	@ApiOperation(value = "Api tests connection to application")
	public ResponseEntity<String> testApi() {
		return new ResponseEntity<String>("Hello from boot", HttpStatus.OK);
	}
}
