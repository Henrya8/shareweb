/**
 * <p>
 * 文件名称: AddWebServlet.java
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
 * 完成日期: 2014年12月7日
 * </p>
 * @author ymxtc
 */
package com.ymxtc.duapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ymxtc.duapp.dao.vo.Web;
import com.ymxtc.duapp.service.WebService;
import com.ymxtc.duapp.service.impl.WebServiceImpl;

/**
 * <p>内容摘要: 简要描述本文件的内容，包括主要模块、函数及能的说明</p>
 * @author  ymxtc
 */
public class AddWebServlet extends HttpServlet
{
	
	
/* (非 Javadoc) 
* <p>Title: doPost</p> 
* <p>Description: </p> 
* @param req
* @param resp
* @throws ServletException
* @throws IOException 
* @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse) 
*/

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
{
	
	
	request.setCharacterEncoding("utf-8");
	String   name = request.getParameter("name");
	String  address =  request.getParameter("address");
	String  clazz   =   request.getParameter("clazz");
	String  userId=   request.getParameter("userId");
	Web    web  =  new Web();
	web.setWebname(name);
	web.setClazz(clazz);
	web.setWebUrl(address);
	WebService webservice = new WebServiceImpl();
	
	int  num = webservice.saveWeb(userId,web);
	
}
}
