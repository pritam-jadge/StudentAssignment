package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.demo.bean.Student;
import com.demo.connection.ConnectionDB;

public class StudentDAO implements StudentInterface {

	Connection con = ConnectionDB.connection();

	@Override
	public ArrayList<Student> fetchAllStudents() {
		ArrayList<Student> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select student_no, student_name, student_dob, student_doj from STUDENT");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Student st = new Student();
				st.setStudentNumber(rs.getInt(1));
				st.setStudentName(rs.getString(2));
				st.setStudentDOB(rs.getString(3));
				st.setStudentDOJ(rs.getString(4));
				list.add(st);
			}
			pstmt.close();
			con.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addStudent(Student st) {
		int status = 0;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into STUDENT(student_no, student_name, student_dob, student_doj) values (?,?,?,?)");
			
			pstmt.setInt(1, st.getStudentNumber());
			pstmt.setString(2, st.getStudentName());
			pstmt.setString(3, st.getStudentDOB());
			pstmt.setString(4, st.getStudentDOJ());

			status = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public void deleteStudent(int StudentNumber) {

		try {
			PreparedStatement pstmt = con.prepareStatement("delete from STUDENT where student_no = ?");
			pstmt.setInt(1, StudentNumber);
			pstmt.executeUpdate();

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Student editStudent(int StudentNumber) {
		Student st = new Student();
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"select student_no, student_name, student_dob, student_doj from STUDENT where student_no = ?");
			pstmt.setInt(1, StudentNumber);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				st.setStudentNumber(rs.getInt(1));
				st.setStudentName(rs.getString(2));
				st.setStudentDOB(rs.getString(3));
				st.setStudentDOJ(rs.getString(4));
			}
			pstmt.close();
			con.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return st;

	}

	@Override
	public int updateStudent(Student st,int oldNumber) {
		int status = 0;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("update STUDENT set student_no=?, student_name=?, student_dob=?, student_doj=? where student_no=?");
			
			pstmt.setInt(1, st.getStudentNumber());
			pstmt.setString(2, st.getStudentName());
			pstmt.setString(3, st.getStudentDOB());
			pstmt.setString(4, st.getStudentDOJ());
			pstmt.setInt(5, oldNumber);

			status = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}
}