package com.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.school.configuration.HelperClass;
import com.school.dto.Student;
import com.school.dto.Teacher;

public class TeacherDao {
	HelperClass helperClass = new HelperClass();
	Connection connection = null;
	
	//to save a teacher data
	
	public Teacher saveTeacher(Teacher teacher) {
		connection = helperClass.getConnection();
		String sql = "Insert into teacher values(?,?,?)";
		
		//create statement
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//passed the values to delimiters/ placeholders----->  ?
			
			preparedStatement.setInt(1, teacher.getId());
			preparedStatement.setString(2, teacher.getName());
			preparedStatement.setString(3, teacher.getEmail());
			
			//execute
			preparedStatement.execute();
		}  catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			//close connection
			try {
				connection.close();
			}  catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return teacher;
	}
	
	//=========================================================================================//
	
	
	//to Delete a Teacher data
	public boolean deleteTeacherByID(int id) {
		connection = helperClass.getConnection();
		String sql = "Delete from Teacher where id = ?";
		int i = 0;
		
		//establish the statement
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			i = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			//close connection
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(i>0) {
			return true;
		} else {
			return false;
		}
	}
	
	//=======================================================================================
	
	//to update a teacher detail
	
	public boolean updateTeacherNameAndEmailByID(String name, String email, int id) {
		connection = helperClass.getConnection();
		String sql = "Update teacher set name = ?, email = ?, id = ?";
		int i = 0;
		
		//establish the statement
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setInt(3, id);
			i = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			//close the connection
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(i>0) {
			return true;
		} else {
			return false;
		}
	}
	
	//=======================================================================================

	//display teacher detail from id
	
	public void studentQueryWithId(int id) {
		connection = helperClass.getConnection();
		String sql = "Select * from teacher where id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println("======================================================");
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//close the connection
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//========================================================================================
	
	//Display all the details of the student
	
	public void teacherQueryAll() {
		connection = helperClass.getConnection();
		String sql ="Select * from teacher";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println("==============================================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//close the connection 
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
