
package com.cs330.fall2013;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.google.gson.Gson;


@Path("students")
public class StudentServices{

	@GET 
	@Path("/{theId}")
	@Produces("text/plain")
	public static String getStudentById(@PathParam("theId") int id) {
		TranscriptFacadeV2 facade = new TranscriptFacadeV2();
		Student result = facade.getStudentById(id);
		//Gson gson = new Gson();
		if(result!=null)
			return result.toString();
			//return gson.toJson(result);
		else
			return "no result";
	}
	
	@GET
	@Path("/{theId}")
	@Produces("application/json")
	public static String getStudentByIdJson(@PathParam("theId") int id) {
		TranscriptFacadeV2 facade = new TranscriptFacadeV2();
		Student result = facade.getStudentById(id);
		Gson gson = new Gson();
		if(result!=null)
			return gson.toJson(result); //return result.toString();
		else
			return "{\"error\": \"707\"}";
	
	}
}
