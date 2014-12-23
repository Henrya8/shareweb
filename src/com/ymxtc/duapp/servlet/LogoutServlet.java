/**
 * <p>
 * �ļ�����: LogoutServlet.java
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
 * �������: 2014��11��16��
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

/**
 * <p>����ժҪ: ��Ҫ�������ļ������ݣ�������Ҫģ�顢�������ܵ�˵��</p>
 * @author  ymxtc
 */
public class LogoutServlet  extends HttpServlet
{
	
	/* (�� Javadoc) 
	* <p>Title: doGet</p> 
	* <p>Description: </p> 
	* @param req
	* @param resp
	* @throws ServletException
	* @throws IOException 
	* @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse) 
	*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
	    Cookie[]  cookies=  req.getCookies();
	    resp.setContentType("text/xml;charset=utf-8");
	    for(Cookie cookie:cookies){
	    	cookie.setMaxAge(0);
	    	resp.addCookie(cookie);
	    }
	    PrintWriter pw = resp.getWriter();
	    pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	    pw.print("<root>");
	    pw.print("<state>true</state>");
		pw.print("</root>");
	
	}

}
