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
	<table border="1" align="center" cellpadding="5">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Date Of Birth</th>
			<th>Date Of Join</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${student}" var="stud">
			<tr>
				<td>${stud.getStudentNumber()}</td>
				<td>${stud.getStudentName()}</td>
				<td>${stud.getStudentDOB()}</td>
				<td>${stud.getStudentDOJ()}</td>
				<td><a href="EditStudent?StudentNumber=${stud.getStudentNumber()}" >Update</a></td>
				<td><a href="DeleteStudent?StudentNumber=${stud.getStudentNumber()}" >Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.jsp" style="text-align: center">Home</a>
</body>
</html>