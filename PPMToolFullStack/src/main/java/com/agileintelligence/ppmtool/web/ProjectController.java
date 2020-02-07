package com.agileintelligence.ppmtool.web;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agileintelligence.ppmtool.domain.Project;
import com.agileintelligence.ppmtool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping("")
			public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result)
			{// <?> define means any type of return object either ResonSe entity of project type or string type
		// @valid anotation is for enableing validation which introduced in Project entity
		// Binding result contain the result message came from backend
				if(result.hasErrors())
				{
					// Logic to map the error in show properly in the Json response
					Map<String, String> errorMap=new HashMap<>();					
					for(FieldError error:result.getFieldErrors())
					{
						errorMap.put(error.getField(), error.getDefaultMessage());
					}
					// Returing the map
					return new ResponseEntity<Map<String, String>>(errorMap , HttpStatus.BAD_REQUEST);
					
					
					// Below request is returing string
//					return new ResponseEntity<String>("Invalid Project Request" , HttpStatus.BAD_REQUEST);
					
				}
				Project project1=projectService.saveOrUpdateProject(project);
				return new ResponseEntity<Project>(project,HttpStatus.CREATED);
		
			}
	
}
