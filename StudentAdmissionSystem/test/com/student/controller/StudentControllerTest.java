package com.student.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.web.servlet.ModelAndView;

import com.student.beans.Student;
import com.student.dao.StudentDao;
import com.student.dao.StudentDaoImpl;

import static org.mockito.Mockito.*;

public class StudentControllerTest {

	@Mock
	private StudentDaoImpl studentdao;
	private Student studentToUpdate;

	ModelAndView modelAndView = new ModelAndView();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		StudentController controller = new StudentController();
		controller.setStudentdao(studentdao);
	}

	@Test
	public void testHelloStudent() {

		modelAndView.addObject("welcomeMessage", "Welcome to Student Registration!!");
		modelAndView.setViewName("hello");
	}

	@Test
	public void testDisplayStudentList() {

		List<Student> studentListReturned;
		List<Student> studentListCreated = new ArrayList<Student>();
		Student student1 = new Student();
		student1.setFname("abc");
		student1.setLname("xyz");
		student1.setGender("M");
		student1.setAge("25");
		studentListCreated.add(student1);
		when(studentdao.retriveStudentList()).thenReturn(studentListCreated);
		studentListReturned = studentdao.retriveStudentList();
		verify(studentdao).retriveStudentList();

	}

	@Test
	public void TestUpdateStudent() {

		when(studentdao.updateStudent(studentToUpdate)).thenReturn(1);
		int updateResult = studentdao.updateStudent(studentToUpdate);
		assertEquals(1, updateResult);
		verify(studentdao).updateStudent(studentToUpdate);

	}

	@Test
	public void TestDeleteStudent(){
		
		String studentToDelete=null;
		when(studentdao.deleteStudent(studentToDelete)).thenReturn(1);
		int deleteResult=studentdao.deleteStudent(studentToDelete);
		assertEquals(1, deleteResult);
		verify(studentdao).deleteStudent(studentToDelete);
		
	}
	
	
}
