
package com.cs330.fall2013;

public class Student {
	private int id;
	private String fname;
	private String lname;
	
	public Student(int id, String fname, String lname) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}

	public Student (String fname, String lname){
		this.fname = fname;
		this.lname = lname;
	}
	
	
	public String toString() {
		//String.format(format, args)
		return id+": " +lname+", "+fname;
	}

}
