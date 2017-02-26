<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>

	${welcomeMessage}

	<form action="saveStudent.html">
		<table>

			<tr>
				<td><label>First Name</label> <input type="text" name="fname"></td>
			</tr>
			<tr>
				<td><label>Last Name</label> <input type="text" name="lname"></td>

			</tr>

			<tr>
				<td><label>Gender</label> <select name="gender">
						<option value="m">M</option>
						<option value="f">F</option>
				</select></td>

			</tr>
			<tr>
				<td><label>Age</label> <input type="text" name="age"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>

		</table>

	</form>

</body>
</html>