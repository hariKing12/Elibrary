package com.sample.project.elibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.elibrary.beans.IssueBookBean;

public class ViewIssuedBookDao {
	
	public static List<IssueBookBean> viewIssueBook(){
		List<IssueBookBean> list=new ArrayList<IssueBookBean>();
		try{
			Connection connection=jdbcUtil.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from e_issuebook order by issuedate desc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				IssueBookBean bean=new IssueBookBean();
				bean.setCallno(rs.getString("callno"));
				bean.setStudentid(rs.getString("studentid"));
				bean.setStudentname(rs.getString("studentname"));
				bean.setStudentmobile(rs.getLong("studentmobile"));
				bean.setIssuedate(rs.getDate("issuedate"));
				bean.setReturnstatus(rs.getString("returnstatus"));
				list.add(bean);
			}
		}catch(SQLException e){
			
		}
		return list;
	}

}
