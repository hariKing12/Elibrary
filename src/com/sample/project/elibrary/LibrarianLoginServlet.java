package com.sample.project.elibrary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LibrarianLoginServlet")
public class LibrarianLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Librarian Section</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		LibrarianLoginDao da=new LibrarianLoginDao();
		/*boolean result=da.librarianLoginDao(email, password);*/
		if(da.librarianLoginDao(email, password)){
			HttpSession session=request.getSession();
			session.setAttribute(email, "email");
			request.getRequestDispatcher("navlibrarian.html").include(request, response);
			request.getRequestDispatcher("librariancarousel.html").include(request, response);
		}else{
			request.getRequestDispatcher("navhome.html").include(request, response);
			out.println("<div class='container'>");
			out.println("<h3>Username or password error</h3>");
			request.getRequestDispatcher("LibrarianLogin.html").include(request, response);
			out.println("</div>");
		}
	}

}
