package com.sample.project.elibrary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.beans.BookBean;


@WebServlet("/ViewBook")
public class ViewBook extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		out.println("<div class='container'>");
		List<BookBean> dao=BookDao.view();
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Callno</th><th>Name</th><th>Author</th><th>Publisher</th><th>Quantity</th><th>Issued</th><th>Delete</th></tr>");
		for(BookBean bean:dao){
		 out.print("<tr><th>"+bean.getCallno()+"</th><th>"+bean.getName()+"</th><th>"+bean.getAuthor()+"</th><th>"+bean.getPublisher()+"</th><th>"+bean.getQuantity()+"</th><th>"+bean.getIssued()+"</th></tr>");
		 
		}
out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
	}

}
