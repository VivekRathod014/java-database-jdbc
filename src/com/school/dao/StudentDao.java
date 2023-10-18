package com.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.school.configuration.HelperClass;
import com.school.dto.Student;

public class StudentDao {
	
	HelperClass helperClass = new HelperClass();
	Connection connection = null;
	
	//to save a student data
	
	public Student saveStudent(Student student) {
		connection = helperClass.getConnection();
		String sql = "Insert into student values(?,?,?)";
		
		//create statement
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//passed the values to delimiters/ placeholders----->  ?
			
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());
			
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
		
		return student;
	}
	
	//=========================================================================================//
	
	
	//to Delete a Student data
	public boolean deleteStudentByID(int id) {
		connection = helperClass.getConnection();
		String sql = "Delete from Student where id = ?";
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
	
	//to update a student detail
	
	public boolean updateStudentNameAndEmailByID(String name, String email, int id) {
		connection = helperClass.getConnection();
		String sql = "Update student set name = ?, email = ?, id = ?";
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

	//display student detail from id
	
	public void studentQueryWithId(int id) {
		connection = helperClass.getConnection();
		String sql = "Select * from student where id = ?";
		
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
	
	public void studentQueryAll() {
		connection = helperClass.getConnection();
		String sql ="Select * from student";
		
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
