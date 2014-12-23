/**
 * <p>
 * 文件名称: LogoutServlet.java
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
 * 完成日期: 2014年11月16日
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
 * <p>内容摘要: 简要描述本文件的内容，包括主要模块、函数及能的说明</p>
 * @author  ymxtc
 */
public class LogoutServlet  extends HttpServlet
{
	
	/* (非 Javadoc) 
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
