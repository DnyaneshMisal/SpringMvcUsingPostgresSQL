package com.student.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.beans.Student;
import com.student.dao.StudentDao;
import com.student.dao.StudentDaoImpl;

public class StudentMain {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("springMvc-servlet.xml");
		StudentDaoImpl studentDao=(StudentDaoImpl) context.getBean("studentDaoImpl");
		Student student=new Student();
		student.setFname("Dnyanesh");
		student.setLname("Misal");
		student.setGender("Male");
		student.setAge("twenty");
		studentDao.saveStudent(student);
		
	}
}
