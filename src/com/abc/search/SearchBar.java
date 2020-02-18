package com.abc.search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchBar")
public class SearchBar extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	response.setContentType("text/html");
	PrintWriter out= response.getWriter();
	
	if(request.getParameter("googleSearch") != null){
		String googleSearch=request.getParameter("googleSearch");
		if(googleSearch==null || googleSearch==""){
			out.println("<span style='color:red;'>Nothing is searched!</span>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/index.html");
			dispatcher.include(request, response);
		}
		else{
			response.sendRedirect("https://www.google.com/#q="+googleSearch);
		}
	}
	else if(request.getParameter("musicSearch")!=null){
		String musicSearch=request.getParameter("musicSearch");
		if(musicSearch==null || musicSearch==""){
			out.println("<span style='color:red;'>Nothing is searched!</span>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/index.html");
			dispatcher.include(request, response);
		}
		else{
			response.sendRedirect("https://www.gaana.com/search/"+musicSearch);
		}
	}
	else{
	String from=request.getParameter("flightSearchFrom").toUpperCase();
	String destination=request.getParameter("flightSearchDestination").toUpperCase();
	String date=request.getParameter("flightSearchDate");
	String changeDate=changeDate(date);
	
	if(from==null || from=="" || destination==null || destination==""){
		out.println("<span style='color:red;'>Nothing is searched!</span>");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/index.html");
		dispatcher.include(request, response);
	}
	else{
		response.sendRedirect("https://www.goibibo.com/flights/air-"+from+"-"+destination+"-"+changeDate+"--1-0-0-E-D/");
	}
	}
}
public String changeDate(String date){
	String temp="";
	for (int i = 0; i < date.length(); i++) {
		if(date.charAt(i) != '-'){
			temp+=date.charAt(i);
		}
	}
	
	return temp;
}
}
