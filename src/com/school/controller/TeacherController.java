package com.school.controller;

import com.school.dto.Student;
import com.school.dto.Teacher;
import com.school.service.StudentService;
import com.school.service.TeacherService;

public class TeacherController {
	
	public static void main(String[] args) {
		Teacher teacher = new Teacher();
		teacher.setId(2);
		teacher.setName("abc");
		teacher.setEmail("abc@gmail.com");
		
		TeacherService teacherService = new TeacherService();
		Teacher t = teacherService.saveTeacher(teacher);
		if(t!=null) {
			System.out.println(t.getId() + " Saved Successfully ");
	}
	

	}
}
