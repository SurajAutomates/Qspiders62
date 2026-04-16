package practice;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


// POJO class  -> Plain Old Java Object
class Project{
	private String createdBy;
	private String projectName;
	private String status;
	private int teamSize;
	public Project() {
		super();
		// used for deserialization
	}
	public Project(String createdBy, String projectName, String status, int teamSize) {
		super();
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}	
	
}
public class Run1JackSonSerializationTest {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		Project proj = new Project("Deepak","Watermelon_1","Created",0);
		
		ObjectMapper objMapper = new ObjectMapper();
		objMapper.writeValue(new File("./project.json"), proj);
		System.out.println("==End==");
	}
}
