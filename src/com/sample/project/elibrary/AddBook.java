package com.sample.project.elibrary;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.beans.BookBean;


@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Book Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
		
		String callno=request.getParameter("callno");
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String publisher=request.getParameter("publisher");
	    int quantity=Integer.parseInt(request.getParameter("quantity"));
		//int quantity=Integer.parseInt(squantity);
		BookBean bean=new BookBean(callno,name,author,publisher,quantity);

	    int result = 0;
		try {
			result = BookDao.save(bean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0){
			out.println("<h3>Book saved successfully</h3>");
		}
		request.getRequestDispatcher("AnotherBook.html").include(request, response);
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
