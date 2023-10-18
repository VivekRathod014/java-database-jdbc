package com.school.controller;

import com.school.service.StudentService;

public class TestDeleteStudent {
	
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		boolean res = studentService.deleteStudentByID(1);
		System.out.println(res);
	}

}
