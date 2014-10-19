
package com.cs330.fall2013;

public class Course
{	
	private int id;
	private String dept;
	private String number;
	
	
	public Course(int id, String dept, String number) {
		this.id = id;
		this.dept = dept;
		this.number = number;
	}
	
	public Course (String dept, String number) {
		this.dept = dept;
		this.number = number;
	}
	
	
	public String toString() {
		return id+": " +dept+ " "+number;
	}
	
}
