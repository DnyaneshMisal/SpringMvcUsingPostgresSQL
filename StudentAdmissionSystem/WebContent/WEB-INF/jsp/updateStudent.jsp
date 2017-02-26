<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Student</title>
</head>
<body>

<form action="updateStudent.html">

<table>
<tr>

<td><input type="text" value="${student.fname}" name="fname"></td>
<td><input type="text" value="${student.lname}" name="lname"><td>
<td><input type="text" value="${student.gender}" name="gender"></td>
<td><input type="text" value="${student.age}" name="age"></td>
<td><input type="submit" value="Update"></td>
</tr>

</table>
</form>

</body>
</html>