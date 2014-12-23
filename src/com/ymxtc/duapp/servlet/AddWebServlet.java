/**
 * <p>
 * �ļ�����: AddWebServlet.java
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
 * �������: 2014��12��7��
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
 * <p>����ժҪ: ��Ҫ�������ļ������ݣ�������Ҫģ�顢�������ܵ�˵��</p>
 * @author  ymxtc
 */
public class AddWebServlet extends HttpServlet
{
	
	
/* (�� Javadoc) 
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
