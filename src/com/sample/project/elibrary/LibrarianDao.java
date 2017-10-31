package com.sample.project.elibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.elibrary.beans.LibrarianBean;

public class LibrarianDao {

	public int librarianDao(LibrarianBean bean){
		Connection connection=null;
		int result=0;
		try{
		    connection=jdbcUtil.getConnection();
		    System.out.println("LibrarianDao connected to databass successfully");
			PreparedStatement ps=connection.prepareStatement("insert into E_LIBRARIAN values(?,?,?,?,?)");
			ps.setInt(1, 2);
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getPassword());
			ps.setString(5, bean.getNumber());
			result=ps.executeUpdate();
			System.out.println(result);
	}catch(SQLException  e){
		System.out.println("Somethig was occured"+e.getMessage());
	}finally{
		if(connection!=null){
			try{
				connection.close();
				System.out.println("connection closed successfully");
			}catch(SQLException e){
				System.out.println("problem occured while closing the connection");
			}
		}else{
			System.out.println("connection was not established");
		}
	}
		return result;
}
}
