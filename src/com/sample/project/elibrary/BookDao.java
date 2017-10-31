package com.sample.project.elibrary;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.elibrary.beans.BookBean;

public class BookDao {
	
	public static  int save(BookBean bean) throws SQLException{
		int result=0;
		try{
		Connection connection=jdbcUtil.getConnection();
		PreparedStatement ps=connection.prepareStatement("insert into E_BOOK values(?,?,?,?,?,?)");
		ps.setString(1, bean.getCallno());
		ps.setString(2, bean.getName());
		ps.setString(3, bean.getAuthor());
		ps.setString(4, bean.getPublisher());
		ps.setInt(5, bean.getQuantity());
		ps.setInt(6, 0);
		result=ps.executeUpdate();
		System.out.println(result);

	}catch(Exception e){
		System.out.println(e.getMessage());
	}
		return result;
}
	
	public static List<BookBean> view(){
		List<BookBean> li=new ArrayList<BookBean>();
		try{
			Connection connection=jdbcUtil.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from ebook");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				BookBean bean=new BookBean();
				bean.setCallno(rs.getString("callno"));
				bean.setName(rs.getString("name"));
				bean.setAuthor(rs.getString("author"));
				bean.setPublisher(rs.getString("publisher"));
				bean.setQuantity(rs.getInt("quantity"));
				bean.setIssued(rs.getInt("issued"));
				li.add(bean);
			}
	
		}catch(SQLException e){
			System.out.println("problem occured while getting the connection"+e.getMessage());
		}
		return li;
		
	}
	
}
