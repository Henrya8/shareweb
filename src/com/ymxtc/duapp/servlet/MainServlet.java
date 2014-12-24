/**
 * <p>
 * 文件名称: Mainservlet.java
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
 * 完成日期: 2014年11月13日
 * </p>
 * @author ymxtc
 */
package com.ymxtc.duapp.servlet;

import java.io.IOException;
import java.net.CookieStore;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import com.ymxtc.duapp.dao.UserDao;
import com.ymxtc.duapp.dao.impl.UserDaoImpl;
import com.ymxtc.duapp.dao.vo.User;
import com.ymxtc.duapp.dao.vo.Web;
import com.ymxtc.duapp.service.WebService;
import com.ymxtc.duapp.service.impl.WebCatalog;
import com.ymxtc.duapp.service.impl.WebServiceImpl;

/**
 * <p>内容摘要: 简要描述本文件的内容，包括主要模块、函数及能的说明</p>
 * @author  ymxtc
 */
public class MainServlet  extends HttpServlet
{
	
	/** 
	* @Fields serialVersionUID 
	*/
	
	private static final long	serialVersionUID	= 2699799887871009885L;

	/* (非 Javadoc) 
	* <p>Title: service</p> 
	* <p>Description: </p> 
	* @param req
	* @param resp
	* @throws ServletException
	* @throws IOException 
	* @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse) 
	*/
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
	  
	    WebService webService = new WebServiceImpl();
	    List<WebCatalog>  webCatalogs =null;
	   HttpSession  session = request.getSession();
	   User user = (User)session.getAttribute("user");
	   
       if(user!=null){
              webCatalogs = webService.getWebCatalogsByUserId(user.getId());
				//TODO  加载用户配置配置
		       Cookie idCookie=new Cookie("username" ,user.getUserName());
		       idCookie.setMaxAge(7*24*3600);
		       Cookie pwdCookie=new Cookie("pwd" ,user.getPwd());
		       pwdCookie.setMaxAge(7*24*3600);
		       //增加cookie
		       response.addCookie(pwdCookie);
		       response.addCookie(idCookie);
		      
       }else{
    	   webCatalogs = webService.getWebCatalogsByUserId(0);
       }
       request.setAttribute("webCatalogs", webCatalogs);
       request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
       
			}
	
 		
	

}
