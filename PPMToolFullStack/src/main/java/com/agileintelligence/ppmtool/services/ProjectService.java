package com.agileintelligence.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agileintelligence.ppmtool.domain.Project;
import com.agileintelligence.ppmtool.exception.ProjectIdException;
import com.agileintelligence.ppmtool.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	// store project in the database
	public Project  saveOrUpdateProject(Project project)
	{
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			
			return projectRepository.save(project);
		}catch(Exception ex)
		{
			throw new ProjectIdException("Project Id "+ex.getMessage() +" " + project.getProjectIdentifier().toUpperCase() + " already Exist." );
			
		}
		
	}
	
	// Get one project based on project id
	public Project findbyProjectIdentifier(String projectId)
	{
		
		Project project=projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null)
			throw new ProjectIdException("ProjectId "+ projectId + " does not Exist.");
		
		
		return project;
	}
	
	// Find all project return all project
	public Iterable<Project> findAllProjects()
	{
		return projectRepository.findAll();		
	}
	
	// Deleting project based on ID
	public void deleteProjectByIdentifier(String projectId)
	{
		Project project=projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null)
			throw new ProjectIdException("Can not delete project  "+ projectId + " does not Exist.");
		
		projectRepository.delete(project);
	}
}
