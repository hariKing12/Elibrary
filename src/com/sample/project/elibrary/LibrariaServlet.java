package com.sample.project.elibrary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.beans.LibrarianBean;


@WebServlet("/LibrariaServlet")
public class LibrariaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Librarian</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		LibrarianBean bean=new LibrarianBean();
		bean.setName(request.getParameter("name"));
		bean.setEmail(request.getParameter("email"));
		bean.setPassword(request.getParameter("password"));
		bean.setNumber(request.getParameter("number"));
		//request.getRequestDispatcher("navadmin.html").include(request, response);
		
		out.println("<div class='container'>");
		LibrarianDao dao=new LibrarianDao();
		int result=dao.librarianDao(bean);
		if(result>0){
			request.getRequestDispatcher("LibrarianLogin.html").include(request, response);
		}else{
			request.getRequestDispatcher("index.html").include(request, response);
		}
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
	}

}
