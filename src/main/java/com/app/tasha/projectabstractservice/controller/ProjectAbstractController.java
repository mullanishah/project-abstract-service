package com.app.tasha.projectabstractservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.tasha.projectabstractservice.pojo.ProjectAbstract;
import com.app.tasha.projectabstractservice.service.ProjectAbstractService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "project")
public class ProjectAbstractController {

	@Autowired
	private ProjectAbstractService projectAbstractService;
	
	@GetMapping(value = "summary")
	@ApiOperation(value = "Api tests connection to application")
	public List<ProjectAbstract> getAllProjectAbstract() {
		return projectAbstractService.getAllProjectAbstracts();
	}
	
	@GetMapping(value = "hello")
	@ApiOperation(value = "Api tests connection to application")
	public ResponseEntity<String> testApi() {
		return new ResponseEntity<String>("Hello from boot", HttpStatus.OK);
	}
}
