package com.sample.project.elibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddquantityDao {
	
	public static int quantity(int number,String callno){
		int status=0;
		try{
			Connection connection=jdbcUtil.getConnection();
			PreparedStatement ps=connection.prepareStatement("update  E_BOOK set quantity=? where callno=?");
			ps.setInt(1, number);
			ps.setString(2, callno);
			status=ps.executeUpdate();
			System.out.println(status);
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return status;
	}

}
