package com.pwskills.danish.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.pwskills.danish.dateobjects.StudentDto;
import com.pwskills.danish.factory.StudentServiceFactory;
import com.pwskills.danish.service.IStudentService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doProcess(request, response); //we don't know data will come by get or post
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response); //we don't know data will come by get or post
	
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		IStudentService service = StudentServiceFactory.getStudentService();
		
		System.out.println("RequestURI is ::  " +request.getRequestURI());
		if(request.getRequestURI().endsWith("addform")) {
			
			String sname= request.getParameter("sname");
			String sage= request.getParameter("sage");
			String saddress= request.getParameter("saddr");
			
			StudentDto stdDto = new StudentDto();
			stdDto.setSname(sname);
			stdDto.setSage(Integer.parseInt(sage));
			stdDto.setSaddress(saddress);
			
			String status = service.insertRecord(stdDto);   //
			
			ServletContext servletContext = request.getServletContext();
			
			if(status.equalsIgnoreCase("success")) {
				RequestDispatcher rd = request.getRequestDispatcher("/success.html");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/failure.html");
				rd.forward(request, response);
			}
		}
		
		if(request.getRequestURI().endsWith("searchform")) {
			
			String sid = request.getParameter("sid");
			StudentDto stdDto = service.readRecord(Integer.parseInt(sid));  //
			
			PrintWriter out = response.getWriter();
			if(stdDto != null) {
				out.println("<table border='1'>");
				out.println("<tr><th>SNAME</th><td>" +stdDto.getSname()+ "</td></tr>");
				out.println("<tr><th>SAGE</th><td>" +stdDto.getSage()+ "</td></tr>");
				out.println("<tr><th>SADDRESS</th><td>" +stdDto.getSaddress()+ "</td></tr>");
				out.println("</table>");
			} else {
				out.println("<h1>RECORD NOT FOUND</h1>");
			}
		}
		
		if(request.getRequestURI().endsWith("deleteform")) {
					String sid = request.getParameter("sid");
					String status = service.deleteRecord(Integer.parseInt(sid));  //
					
					PrintWriter out = response.getWriter();
					
					if(status== "success") {
						RequestDispatcher rd = request.getRequestDispatcher("/deletesuccess.html");
						rd.forward(request, response);
					} else {
						RequestDispatcher rd = request.getRequestDispatcher("/deletefailure.html");
						rd.forward(request, response);
					}
		}
		
		if(request.getRequestURI().endsWith("updateform")) {
			String sid = request.getParameter("sid");
			
			StudentDto stdDto = service.readRecord(Integer.parseInt(sid));
			PrintWriter out = response.getWriter();
			
			if(stdDto != null) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				out.println("<p>OLD SNAME IS :: " + stdDto.getSname() +"</p>");
				out.print("<p>Enter new name :: "+ br.readLine() +"<p>");
			} else {
				out.println("<h1 font-variant:small-caps>NO RECORDS TO UPDATE </h1>");
			}
		}
		
	}
}
