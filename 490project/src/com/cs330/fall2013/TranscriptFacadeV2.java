
package com.cs330.fall2013;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.PreparedStatement;
//import com.mysql.jdbc.PreparedStatement;

import com.google.gson.Gson;


public class TranscriptFacadeV2 {

	public Student getStudentById(int id) {
		
		ProgramAdvisorDataSourceSingleton ds = ProgramAdvisorDataSourceSingleton.getInstance();
		Connection con = ds.getConnection();
				
		PreparedStatement stmt=null;
		ResultSet rs = null;
		//String result="";
		Student theStud = null;
		try {
			stmt = con.prepareStatement("SELECT id, fname,lname FROM student WHERE id=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			
			if (rs.next()) {
				int x = rs.getInt("id");
				String f = rs.getString("fname");
				String l = rs.getString("lname");
				//result = "id: "+x+ ", name: "+s;
				theStud = new Student(x, f, l);
			}
			
			
			//con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
 		
 		
		return theStud;
		
	}
	
public Course getCourseById(int id) {
		
		ProgramAdvisorDataSourceSingleton ds = ProgramAdvisorDataSourceSingleton.getInstance();
		Connection con = ds.getConnection();
		
		PreparedStatement stmt=null;
		ResultSet rs = null;
		//String result="";
		Course theCours = null;
		try {
			stmt = con.prepareStatement("SELECT id, dept,number FROM course WHERE id=?");
			stmt.setInt(1,id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				int x = rs.getInt("id");
				String d = rs.getString("dept");
				String n = rs.getString("number");
				//result = "id: "+x+ ", course: "+s;
				theCours = new Course(x, d, n);
			}
			
			//con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
 		
 		
		return theCours;
		
	}
	
	
	public static void main(String[] args) {
		TranscriptFacadeV2 tf = new TranscriptFacadeV2();
		int id = 3;
		Student theStudent = tf.getStudentById(id);
		System.out.println(theStudent);

		Gson gson = new Gson();
		String jsonStudent = gson.toJson(theStudent);
		System.out.println(jsonStudent);
		Student s2 = gson.fromJson(jsonStudent, Student.class);

		System.out.println(s2);

		Course theCourse = tf.getCourseById(id);
		System.out.println(theCourse);
		
		String jsonCourse = gson.toJson(theCourse);
		System.out.println(jsonCourse);
		Course c2 = gson.fromJson(jsonCourse, Course.class);
		System.out.println(c2);
		
	}

}
