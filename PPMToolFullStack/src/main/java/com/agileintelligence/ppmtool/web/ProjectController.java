package com.agileintelligence.ppmtool.web;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agileintelligence.ppmtool.domain.Project;
import com.agileintelligence.ppmtool.services.MapValidationErrorService;
import com.agileintelligence.ppmtool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
			public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result)
			{// <?> define means any type of return object either ResonSe entity of project type or string type
		// @valid anotation is for enableing validation which introduced in Project entity
		// Binding result contain the result message came from backend
				
				ResponseEntity<?> errorMap=mapValidationErrorService.MapValidationService(result);
				
				if(errorMap !=null)
					return errorMap;
		
		
				Project project1=projectService.saveOrUpdateProject(project);
				return new ResponseEntity<Project>(project,HttpStatus.CREATED);
		
			}
	
	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable String projectId)
	{
		
		Project project= projectService.findbyProjectIdentifier(projectId);
		
		return new ResponseEntity<Project>(project,HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public Iterable<Project> getAllProjects()
	{
		return projectService.findAllProjects();
	}
	
	@DeleteMapping("/{projectId}")
	public ResponseEntity<?> deleteProject(@PathVariable String projectId)
	{
		projectService.deleteProjectByIdentifier(projectId);
		return new ResponseEntity<String>("Project with Id " +projectId +" deleted successfully", HttpStatus.OK);
	}
	
}
