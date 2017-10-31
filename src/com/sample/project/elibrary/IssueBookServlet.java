package com.sample.project.elibrary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.beans.IssueBookBean;


@WebServlet("/IssueBookServlet")
public class IssueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IssueBookBean bean=new IssueBookBean();
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
		out.println("<div class='container'>");
		
		bean.setCallno(request.getParameter("callno"));
		bean.setStudentid(request.getParameter("studentid"));
		bean.setStudentname(request.getParameter("studentname"));
		bean.setStudentmobile(Long.parseLong(request.getParameter("studentmobile")));
		IssueBookDao dao=new IssueBookDao();
		int status=dao.issueBook(bean);
		if(status>0){
			out.println("<h3>Book issued successfully</h3>");
		}else{
			out.println("<h3>Sorry, unable to issue book.</h3><p>We may have sortage of books. Kindly visit later.</p>");
		}
          out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
