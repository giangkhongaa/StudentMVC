package com.giang.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giang.model.*;

/**
 * Servlet implementation class showServlet
 */
@WebServlet("/showServlet")
public class showServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public showServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDAO studentDAO = new StudentDAO();
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<link rel=\"stylesheet\" href=\"CSS/style.css\" />");
			out.println("<title>Book Student</title>");
			out.println("</head>");
			out.println("<body>");
			out.print("<center>");
			out.println("<h1>");
			out.println("Danh sách sinh viên");
			out.println("</h1>");
			out.print("</center>");
			out.print("<center>");
			out.println("<table border='" + 5 + "'>");
			//begin title
			out.println("<tr>");
			out.println("<th>");
			out.println("STT");
			out.println("</th>");
			out.println("<th>");
			out.println("Name");
			out.println("</th>");
			out.println("<th>");
			out.println("Adress");
			out.println("</th>");
			out.println("<th>");
			out.println("Age");
			out.println("</th>");
			out.println("</tr>");
			//end title
			// begin show book student
			for(Student student : studentDAO.getListStudent()) {
				out.println("</tr>");
				out.println("<td>");
				out.println(student.getId());
				out.println("</td>");
				out.println("<td>");
				out.println(student.getName());
				out.println("</td>");
				out.println("<td>");
				out.println(student.getAddress());
				out.println("</td>");
				out.println("<td>");
				out.println(student.getAge());
				out.println("</td>");
				out.println("<tr>");
			}
			// end show book student
			out.println("</table>");
			
			out.print("</center>");
			out.println("</body>");
			out.println("</html>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
