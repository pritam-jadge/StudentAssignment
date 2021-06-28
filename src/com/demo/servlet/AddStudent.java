package com.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Student;
import com.demo.dao.StudentDAO;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int studentNumber = Integer.parseInt(request.getParameter("StudentNumber"));
		String studentName = request.getParameter("StudentName");
		String studentDOB = request.getParameter("StudentDOB");
		String studentDOJ = request.getParameter("StudentDOJ");
	
		Student st = new Student();
		st.setStudentNumber(studentNumber);
		st.setStudentName(studentName);
		st.setStudentDOB(studentDOB);
		st.setStudentDOJ(studentDOJ);
		
		StudentDAO dao = new StudentDAO();
		int status = dao.addStudent(st);
		
		if(status != 0) {
			response.sendRedirect("StudentList");
		}
		else {
			System.err.println("Something went wrong ! Record not added.");
		}
	}
}
