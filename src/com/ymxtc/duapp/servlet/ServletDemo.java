package com.ymxtc.duapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo
 */
public class ServletDemo extends HttpServlet
{
	private static final long	serialVersionUID	= 1L;

	/**
	 * Default constructor.
	 */
	public ServletDemo()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

	/*
	 * (·Ç Javadoc) <p>Title: service</p> <p>Description: </p>
	 * 
	 * @param req
	 * 
	 * @param resp
	 * 
	 * @throws ServletException
	 * 
	 * @throws IOException
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		Connection conn = (Connection) req.getAttribute("oracleconn");
		try
		{
			Statement sta = conn.createStatement();
			ResultSet rs = sta
					.executeQuery("select * from emp order by empno desc");
			int count=0;
			pw.println("<table border='1'>");
			pw.println("<tr>");
			pw.println("<td>±àºÅ</td> <td> ÐÕÃû</td>");
			pw.println("</tr>");
		
				while (rs.next())
				{
					pw.println("<tr>");
					pw.println("<td>"+rs.getString(1) +"</td><td>"+rs.getString(2)+"</td>");
					pw.println("</tr>");
					count++;
				}
				pw.println("<tr>");
				pw.println("<td>"+ "sum " +"</td><td>"+count+"</td>");
				pw.println("</tr>");
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
