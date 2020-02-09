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
	
	public Project findbyProjectIdentifier(String projectId)
	{
		
		Project project=projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null)
			throw new ProjectIdException("ProjectId "+ projectId + " does not Exist.");
		
		
		return project;
	}
	
	public Iterable<Project> findAllProjects()
	{
		return projectRepository.findAll();		
	}
}
