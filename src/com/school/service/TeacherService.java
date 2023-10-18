package com.school.service;

import com.school.dao.TeacherDao;
import com.school.dto.Teacher;

public class TeacherService {
	TeacherDao teacherdao = new TeacherDao();
	
	public Teacher saveTeacher(Teacher teacher) {
		return teacherdao.saveTeacher(teacher);
	}
	

}
