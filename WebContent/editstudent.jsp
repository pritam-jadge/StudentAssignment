<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateStudent">
		<input type="hidden" name="oldNumber" value="${student.getStudentNumber()}">
		Student Number :<input type="number" name="StudentNumber" value="${student.getStudentNumber()}">
		Student Name : <input type="text" name="StudentName" value="${student.getStudentName()}">
		Student DOB : <input type="date" name="StudentDOB" value="${student.getStudentDOB()}">
		Student DOJ : <input type="date" name="StudentDOJ" value="${student.getStudentDOJ()}">
		<input type="submit" value="Update Student">
	</form>
</body>
</html>