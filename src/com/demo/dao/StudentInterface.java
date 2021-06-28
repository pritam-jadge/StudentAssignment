package com.demo.dao;

import java.util.ArrayList;

import com.demo.bean.Student;

public interface StudentInterface {
	
	ArrayList<Student> fetchAllStudents();
	
	int addStudent(Student st);
	
	void deleteStudent (int StudentNumber);
	
	Student editStudent (int StudentNumber);
	
	int updateStudent(Student st, int oldNumber);

}
