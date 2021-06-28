<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>Add Student</h1>
	<form action="AddStudent" method="post">
		Student Number : <input type="number" name="StudentNumber">
		Student Name : <input type="text" name="StudentName">
		Student DOB : <input type="date" name="StudentDOB">
		Student DOJ : <input type="date" name="StudentDOJ">
		<input type="submit" value="Add Student">
	</form>
	<br>
	<form action="StudentList">
		<input type="submit" value="Student List">
	</form>
</body>
</html>