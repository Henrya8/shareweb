/**
 * <p>
 * 文件名称: LoginServlet.java
 * </p>
 * <p>
 * 文件描述: TODO
 * </p>
 * <p>
 * 版权所有: 版权所有(C)2014
 * </p>
 * <p>
 * 内容摘要: 简要描述本文件的内容，包括主要模块、函数及能的说明
 * </p>
 * <p>
 * 其他说明: 其它内容的说明
 * </p>
 * <p>
 * 完成日期: 2014年11月15日
 * </p>
 * @author ymxtc
 */
package com.ymxtc.duapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ymxtc.duapp.dao.vo.User;
import com.ymxtc.duapp.service.UserService;
import com.ymxtc.duapp.service.impl.UserServiceImpl;
import com.ymxtc.duapp.util.Encrypt;

/**
 * <p>内容摘要: 简要描述本文件的内容，包括主要模块、函数及能的说明</p>
 * @author  ymxtc
 */
public class LoginServlet  extends HttpServlet
{
	/** 
	* @Fields serialVersionUID : TODO
	*/
	
	private static final long	serialVersionUID	= 8443117658055282771L;

	/*
	 * (非 Javadoc) <p>Title: service</p> <p>Description: </p>
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
		PrintWriter  pw = resp.getWriter();
		 resp.setContentType("text/xml;charset=utf-8");
		 String username  =req.getParameter("username");
		 String  pwd = req.getParameter("pwd");
		
		 pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		 pw.println("<root>");
		
			UserService  service = new UserServiceImpl();
			HttpSession   session = req.getSession();
			if(service.verifyUser(username, Encrypt.encrypt( pwd))){
				User user =  service.getUserByUserName( username);
				 session.setAttribute("user", user);
				  Cookie idCookie=new Cookie("username" ,user.getUserName());
			       idCookie.setMaxAge(7*24*3600);
			       Cookie pwdCookie=new Cookie("pwd" ,user.getUserName());
			       pwdCookie.setMaxAge(7*24*3600);
			       resp.addCookie(pwdCookie);
			       resp.addCookie(idCookie);
			       pw.println("<mark>"+true+"</mark>");
			}else{
				pw.println("<mark>"+false+"</mark>");
				
			}
			pw.println("</root>");
			pw.close();
		
		
	}

}
