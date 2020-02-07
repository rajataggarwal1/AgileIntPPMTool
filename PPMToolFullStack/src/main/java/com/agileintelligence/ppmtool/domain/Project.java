package com.agileintelligence.ppmtool.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Project {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Project Name is must.")
	private String projectName;
	
	@NotBlank(message = "Project Identifier is Must.")
	@Size(min=4, max = 5, message = "Please eneter project Identifier between 4 to 5")
	@Column(updatable = false,unique = true)
	private String projectIdentifier;
	
	@NotBlank(message = "Please enter description")
	private String description;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date start_date;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date end_Date;
	
	@JsonFormat(pattern = "yyyy-mm-dd")	
	private Date created_At;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updated_At;
	
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(Long id, String projectName, String projectIdentifier, String description, Date start_date,
			Date end_Date, Date created_At, Date updated_At) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectIdentifier = projectIdentifier;
		this.description = description;
		this.start_date = start_date;
		this.end_Date = end_Date;
		this.created_At = created_At;
		this.updated_At = updated_At;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_Date() {
		return end_Date;
	}

	public void setEnd_Date(Date end_Date) {
		this.end_Date = end_Date;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}
	
	@PrePersist
	protected void onCreat()
	{
		this.created_At=new Date();
		
	}
	
	@PreUpdate
	protected void onUpdate()
	{
		this.updated_At=new Date();
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", projectIdentifier=" + projectIdentifier
				+ ", description=" + description + ", start_date=" + start_date + ", end_Date=" + end_Date
				+ ", created_At=" + created_At + ", updated_At=" + updated_At + "]";
	}
	
	
	
}
