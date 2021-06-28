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
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int oldNumber = Integer.parseInt(request.getParameter("oldNumber"));
		
		int StudentNumber = Integer.parseInt(request.getParameter("StudentNumber"));
		String studentName = request.getParameter("StudentName");
		String studentDOB = request.getParameter("StudentDOB");
		String studentDOJ = request.getParameter("StudentDOJ");
	
		Student st = new Student();
		st.setStudentNumber(StudentNumber);
		st.setStudentName(studentName);
		st.setStudentDOB(studentDOB);
		st.setStudentDOJ(studentDOJ);
		
		StudentDAO dao = new StudentDAO();
		int status = dao.updateStudent(st,oldNumber);
		
		if(status != 0) {
			response.sendRedirect("StudentList");
		}
		else {
			System.err.println("Something went wrong ! Record not updated.");
		}
		
	}

}
