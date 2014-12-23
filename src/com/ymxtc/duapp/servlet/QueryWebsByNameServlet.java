/**
 * <p>
 * �ļ�����: QueryWebsByNameServlet.java
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
 * �������: 2014��12��8��
 * </p>
 * @author ymxtc
 */
package com.ymxtc.duapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.ymxtc.duapp.dao.UserDao;
import com.ymxtc.duapp.dao.impl.UserDaoImpl;
import com.ymxtc.duapp.dao.vo.User;
import com.ymxtc.duapp.service.WebService;
import com.ymxtc.duapp.service.impl.WebCatalog;
import com.ymxtc.duapp.service.impl.WebServiceImpl;

/**
 * <p>
 * ����ժҪ: ��Ҫ�������ļ������ݣ�������Ҫģ�顢�������ܵ�˵��
 * </p>
 * 
 * @author ymxtc
 */
public class QueryWebsByNameServlet extends HttpServlet
{

	/*
	 * (�� Javadoc) <p>Title: doPost</p> <p>Description: </p>
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
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		String username = req.getParameter("username");

		String pwd = req.getParameter("pwd");

		UserDao userDao = new UserDaoImpl();
		WebService webService = new WebServiceImpl();
		User user;

		List<WebCatalog> webCatalogs=null;
		try
		{

		
				user = userDao.getUserByusername(username);
System.out.println(user.getId());
				if (user.getId()==0||user.getPwd().equals(pwd))
				{
					webCatalogs = webService.getWebsByUser(user);
				} else
				{
					pw.print("{err:'�Ƿ���ȡ'}");
				}
		
			JSONArray jsonArray = JSONArray.fromObject(webCatalogs);
			System.out.println(jsonArray.toString());
			pw.print(jsonArray.toString());

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
