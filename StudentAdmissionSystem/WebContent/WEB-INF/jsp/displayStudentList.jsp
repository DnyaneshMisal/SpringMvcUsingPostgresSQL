<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student List</title>
</head>
<body>
	<h1>List of Students Registered</h1>
	<table border="1">
		
		<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Gender</th>
		<th>Age</th>
		</tr>
		<c:if test="${not empty studentList}">
			<c:forEach var="student" items="${studentList}">
				<tr>
					<td>${student.fname}</td>
					<td>${student.lname}</td>
					<td>${student.gender}</td>
					<td>${student.age}</td>

					<td><a href="editStudent.html?studentToEdit=${student.fname}">Edit</a></td>
					<td><a
						href="deleteStudent.html?studentToDelete=${student.fname}">Delete</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<a href="sortAscend.html">Sort Ascending</a>
	<a href="sortDescend.html">Sort Descending</a>
</body>
</html>



