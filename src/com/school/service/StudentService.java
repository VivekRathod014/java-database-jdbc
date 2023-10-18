package com.school.service;

import com.school.dao.StudentDao;
import com.school.dto.Student;

public class StudentService {
	
	StudentDao studentdao = new StudentDao();
	
	public Student saveStudent(Student student) {
		return studentdao.saveStudent(student);
	}
	
	public boolean deleteStudentByID(int id) {
		return studentdao.deleteStudentByID(id);
	}

}
