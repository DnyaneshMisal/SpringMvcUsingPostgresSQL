package com.student.beans;

import java.util.Comparator;

public class Student {
	private String fname;
	private String lname;
	private String gender;
	private String age;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
		
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public class AscendComparator implements Comparator<Student> {

		@Override
		public int compare(Student stud1, Student stud2) {

			int i = stud1.getFname().compareTo(stud2.getFname());
			if (i > 1) {
				return 1;
			} else if (i < 1)
				return -1;
			else
				return 0;
		}

	}

	public class DescendComparator implements Comparator<Student> {

		@Override
		public int compare(Student stud1, Student stud2) {

			int i = stud1.getFname().compareTo(stud2.getFname());
			if (i < 1) {
				return 1;
			} else if (i > 1)
				return -1;
			else
				return 0;
		}

	}

}
