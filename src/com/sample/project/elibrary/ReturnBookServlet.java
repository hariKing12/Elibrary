package com.sample.project.elibrary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Return Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		
		out.println("<div class='container'>");
		
		String callno=request.getParameter("callno");
		String studentid=request.getParameter("studentid");
		
		int status=ReturnBookDao.returnBook(callno, studentid);
		if(status>0){
			out.println("<h3>Book returned successfully</h3>");
		}
			else{
				out.println("<h3>Sorry, unable to return book.</h3><p>We may have sortage of books. Kindly visit later.</p>");
			}
		}
	}

