package practice;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JackSonDeSerTest {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper obj_mapper = new ObjectMapper();
		Project project_obj = obj_mapper.readValue( new File("./project.json"), Project.class);
		System.out.println(project_obj.getCreatedBy());
		System.out.println(project_obj.getProjectName());
		System.out.println(project_obj.getStatus());
		System.out.println(project_obj.getTeamSize());
	}
}
