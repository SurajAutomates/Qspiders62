package practice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project1 {
	private String projectName;
	private String projectStatus;
	private List<String> teamMembers;
	private List<ProjectManager> projectManager;

	public Project1(String projectName, String projectStatus, List<String> teamMembers,
			List<ProjectManager> projectManager) {
		super();
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.teamMembers = teamMembers;
		this.projectManager = projectManager;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public List<String> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(List<String> teamMembers) {
		this.teamMembers = teamMembers;
	}
	public List<ProjectManager> getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(List<ProjectManager> projectManager) {
		this.projectManager = projectManager;
	}	
}

class ProjectManager {
	private String name;
	private String id;
	public ProjectManager(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}

public class CreatePojoClass1 {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		ProjectManager proj_man_obj1 = new ProjectManager("Sagar", "tp_01");
		ProjectManager proj_man_obj2 = new ProjectManager("Kaustubh", "tp_02");
		List<String> members = new ArrayList<String>();
		members.add("Jhon");
		members.add("Devid");
		members.add("Stev");
		List<ProjectManager> projectManager = new ArrayList<ProjectManager>();
		projectManager.add(proj_man_obj1);
		projectManager.add(proj_man_obj2);
		
		Project1 pro = new Project1("Orange", "Created", members, projectManager);
		
		ObjectMapper obj_mapper = new ObjectMapper();
		obj_mapper.writeValue(new File("./project.json"), pro);
		Sysyem.out.println("fcgvbhn)
		
	}
}
