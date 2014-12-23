/**
 * <p>
 * �ļ�����: LoginServlet.java
 * </p>
 * <p>
 * �ļ�����: TODO
 * </p>
 * <p>
 * ��Ȩ����: ��Ȩ����(C)2014
 * </p>
 * <p>
 * ����ժҪ: ��Ҫ�������ļ������ݣ�������Ҫģ�顢�������ܵ�˵��
 * </p>
 * <p>
 * ����˵��: �������ݵ�˵��
 * </p>
 * <p>
 * �������: 2014��11��15��
 * </p>
 * @author ymxtc
 */
package com.ymxtc.duapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ymxtc.duapp.dao.UserDao;
import com.ymxtc.duapp.dao.impl.UserDaoImpl;
import com.ymxtc.duapp.dao.vo.User;

/**
 * <p>����ժҪ: ��Ҫ�������ļ������ݣ�������Ҫģ�顢�������ܵ�˵��</p>
 * @author  ymxtc
 */
public class LoginServlet  extends HttpServlet
{
	
	
	
	
	/* (�� Javadoc) 
	* <p>Title: service</p> 
	* <p>Description: </p> 
	* @param req
	* @param resp
	* @throws ServletException
	* @throws IOException 
	* @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse) 
	*/
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		PrintWriter  pw = resp.getWriter();
		 resp.setContentType("text/xml;charset=utf-8");
		 String username  =req.getParameter("username");
		 String  pwd = req.getParameter("pwd");
		 UserDao   userDao = new UserDaoImpl();
		 pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		 pw.println("<root>");
		try
		{
			User user =  userDao.getUserByusername( username);
			if(user!=null && user.getPwd().equals(pwd)){
				  Cookie idCookie=new Cookie("userId" ,String.valueOf(user.getId()));
			       idCookie.setMaxAge(7*24*3600);
			       Cookie pwdCookie=new Cookie("pwdId" ,user.getUserName());
			       pwdCookie.setMaxAge(7*24*3600);
			       resp.addCookie(pwdCookie);
			       resp.addCookie(idCookie);
			       pw.println("<mark>"+true+"</mark>");
			}else{
				pw.println("<mark>"+false+"</mark>");
				
			}
			pw.println("</root>");
			pw.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		 
		
	}

}
