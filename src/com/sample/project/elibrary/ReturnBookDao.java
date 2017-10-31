package com.sample.project.elibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReturnBookDao {
	
	public static int getIssued(String callno){
		int issued=0;
		try{
			Connection connection=jdbcUtil.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from e_book where callno=?");
			ps.setString(1, callno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				issued=rs.getInt("issued");
			}
		}catch(SQLException e){
			System.out.println("problem with query"+e.getMessage());
		}
		return issued;
	}

	public static int returnBook(String callno,String studentid){
		int status=0;
		try{
			Connection connection=jdbcUtil.getConnection();
			PreparedStatement ps=connection.prepareStatement("update e_issuebook set returnstatus='yes' where callno=? and studentid=?");
			ps.setString(1, callno);
			ps.setString(2, studentid);
			status=ps.executeUpdate();
			if(status>0){
				PreparedStatement ps1=connection.prepareStatement("update e_book set issued=? where callno=?");
				ps1.setInt(1, getIssued(callno)-1);
				ps1.setString(2, callno);
			}
		}catch(SQLException e){
			System.out.println("problem with the query");
		}
		return status;
		
	}
}
