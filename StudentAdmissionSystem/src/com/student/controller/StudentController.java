package com.student.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.student.beans.Student;
import com.student.dao.StudentDaoImpl;


@Controller
public class StudentController {

	ModelAndView modelAndView = new ModelAndView();
	List<Student> studentList = new ArrayList<Student>();
	private StudentDaoImpl studentdao = new StudentDaoImpl();

	@RequestMapping("/hello.html")
	public ModelAndView HelloStudent() {

		modelAndView.addObject("welcomeMessage", "Welcome to Student Registration process!!");
		modelAndView.setViewName("hello");
		return modelAndView;
	}

	@RequestMapping("/displayStudentList.html")
	public ModelAndView displayStudentList() {
		modelAndView.setViewName("displayStudentList");
		studentList = getStudentdao().retriveStudentList();
		modelAndView.addObject("studentList", studentList);
		return modelAndView;
	}

	@RequestMapping("/editStudent.html")
	public ModelAndView editStudent(@RequestParam String studentToEdit) {

		System.out.println("Edit record called" + studentToEdit);
		modelAndView.setViewName("updateStudent");
		Student student = new Student();

		ListIterator<Student> iterator = studentList.listIterator();
		while (iterator.hasNext()) {
			student = iterator.next();
			if (StringUtils.trimAllWhitespace(student.getFname())
					.equals(StringUtils.trimAllWhitespace(studentToEdit))) {
				break;
			}

		}
		modelAndView.addObject("student", student);
		return modelAndView;
	}

	@RequestMapping("/updateStudent.html")
	public ModelAndView UpdateStudent(@ModelAttribute("Student") Student studentToUpdate) {

		int updateResult = getStudentdao().updateStudent(studentToUpdate);
		modelAndView.setViewName("updateSuccess");
		modelAndView.addObject("updateSuccessMsg", "Student Records Updated SuccessFully !!");
		modelAndView.addObject("updateResult", updateResult);
		return modelAndView;
	}

	@RequestMapping("/deleteStudent.html")
	public ModelAndView deleteStudent(String studentToDelete) {

		int deleteResult = getStudentdao().deleteStudent(studentToDelete);
		modelAndView.setViewName("deleteSuccess");
		modelAndView.addObject("deleteSuccessMsg", "Student Records Deleted SuccessFully !!");
		modelAndView.addObject("deleteResult", deleteResult);
		return modelAndView;
	}

	@RequestMapping("/sortAscend.html")
	public ModelAndView sortAscend() {
		
		
		Student.AscendComparator ascendComparator= new Student().new AscendComparator();
		Collections.sort(studentList,ascendComparator);
		modelAndView.setViewName("displayStudentList");
		modelAndView.addObject("studentList", studentList);
		return modelAndView;
	}
	
	@RequestMapping("/sortDescend.html")
	public ModelAndView sortDescend() {
		
		Student.DescendComparator desscendComparator= new Student().new DescendComparator();
		Collections.sort(studentList,desscendComparator);
		modelAndView.setViewName("displayStudentList");
		modelAndView.addObject("studentList", studentList);
		return modelAndView;
	}
	
	@RequestMapping("/saveStudent.html")
	public ModelAndView SaveStudent(@ModelAttribute Student student) {

		Properties prop = new Properties();
		try {
			InputStream inputStream = StudentController.class.getResourceAsStream("config.properties");
			prop.load(inputStream);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean saveStatus = getStudentdao().saveStudent(student);
		String successMessage = prop.getProperty("success");
		String failMessage = prop.getProperty("error");

		if (saveStatus == true) {
			modelAndView.setViewName("success");
			modelAndView.addObject("successMessage", successMessage);
			modelAndView.addObject("stud", student);
			return modelAndView;
		} else {
			modelAndView.setViewName("error");
			modelAndView.addObject("failMessage", failMessage);
			return modelAndView;
		}
	}

	public StudentDaoImpl getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(StudentDaoImpl studentdao) {
		this.studentdao = studentdao;
	}

}
