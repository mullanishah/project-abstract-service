package com.app.tasha.projectabstractservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "project")
public class ProjectAbstractController {

	@GetMapping(value = "hello")
	@ApiOperation(value = "Api tests connection to application")
	public ResponseEntity<String> testApi() {
		return new ResponseEntity<String>("Hello from boot", HttpStatus.OK);
	}
}
