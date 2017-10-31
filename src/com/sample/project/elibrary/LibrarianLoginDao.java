package com.sample.project.elibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.elibrary.beans.LibrarianBean;

public class LibrarianLoginDao {

	public boolean librarianLoginDao(String email,String password){
		 Connection connection=null;
	     boolean result=false;

		try{
			connection=jdbcUtil.getConnection();
			System.out.println("connection was established");
			PreparedStatement ps=connection.prepareStatement("select * from E_LIBRARIAN where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet resultSet=ps.executeQuery();
			System.out.println(resultSet);
			if(resultSet.next()){
				result=true;
			}
		}catch(Exception e){
			e.getMessage();
		}finally{
			if(connection!=null){
				try{
					connection.close();
					System.out.println("connection was closed successfully");
				}catch(SQLException e){
					System.out.println("problem occured while closing the connection"+e.getMessage());
				}
			}else{
				System.out.println("connection was not established");
			}
		}
		return result;
	}
}
