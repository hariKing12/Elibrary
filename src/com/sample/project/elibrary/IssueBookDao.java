package com.sample.project.elibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.elibrary.beans.IssueBookBean;

public class IssueBookDao {
	
	public static int getIssued(String callno){
		int issued=0;
		try{
			Connection connection=jdbcUtil.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from e_book");
			ResultSet resultSet=ps.executeQuery();
			if(resultSet.next()){
				issued=resultSet.getInt("issued");
				System.out.println(issued);
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return issued;
	}
	
	public static boolean checkIssue(String callno){
		boolean status=false;
		try{
			Connection connection=jdbcUtil.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from E_BOOK where callno=? and quantity>issued");
			ps.setString(1, callno);
			ResultSet resultSet=ps.executeQuery();
			if(resultSet.next()){
				status=true;
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return status;
	}

	public static int issueBook(IssueBookBean bean){

		String callno=bean.getCallno();
		boolean checkstatus=checkIssue(callno);
		System.out.println("status is "+checkstatus);
		if(checkstatus){
			int status=0;
			try{
				Connection connection=jdbcUtil.getConnection();
				PreparedStatement ps=connection.prepareStatement("insert into e_issuebook values(?,?,?,?,?,?)");
				ps.setString(1, bean.getCallno());
				ps.setString(2, bean.getStudentid());
				ps.setString(3, bean.getStudentname());
				ps.setLong(4, bean.getStudentmobile());
			    java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
			    ps.setDate(5, currentDate);
			    ps.setString(6, "no");
			    status=ps.executeUpdate();
			    if(status>0){
			    	PreparedStatement ps1=connection.prepareStatement("update e_issuebook issued=? where callno=?");
			    	ps.setInt(1, getIssued(callno)+1);
			    	ps.setString(2, callno);
			    	status=ps.executeUpdate();
			    }
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return status;
		}else{
			return 0;
		}
		
	}

}
