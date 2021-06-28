package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Student;
import com.demo.dao.StudentDAO;

/**
 * Servlet implementation class EditStudent
 */
@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int StudentNumber = Integer.parseInt(request.getParameter("StudentNumber"));
		
		StudentDAO dao = new StudentDAO();
		
		Student student = dao.editStudent(StudentNumber);
		
	/*	response.sendRedirect("StudentList");*/
		RequestDispatcher rs = request.getRequestDispatcher("editstudent.jsp");
		request.setAttribute("student", student);
		rs.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
