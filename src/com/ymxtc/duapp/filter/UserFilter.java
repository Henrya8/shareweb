/**
 * <p>
 * 文件名称: UserFilter.java
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
 * 完成日期: 2014年12月24日
 * </p>
 * @author ymxtc
 */
package com.ymxtc.duapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ymxtc.duapp.dao.vo.User;
import com.ymxtc.duapp.service.UserService;
import com.ymxtc.duapp.service.impl.UserServiceImpl;

/**
 * <p>内容摘要:檢查用戶</p>
 * @author  ymxtc
 */
public class UserFilter implements Filter
{
	
	/* (非 Javadoc) 
	* <p>Title: init</p> 
	* <p>Description: </p> 
	* @param filterConfig
	* @throws ServletException 
	* @see javax.servlet.Filter#init(javax.servlet.FilterConfig) 
	*/
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
	
	}

	/* (非 Javadoc) 
	* <p>Title: doFilter</p> 
	* <p>Description: </p> 
	* @param request
	* @param response
	* @param chain
	* @throws IOException
	* @throws ServletException 
	* @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain) 
	*/
	
	@Override
	public void doFilter(ServletRequest q, ServletResponse r,
			FilterChain chain) throws IOException, ServletException
	{
		//强转
		HttpServletRequest request = (HttpServletRequest)q;
		HttpServletResponse 	response = (HttpServletResponse)r;
		//设置编码
		request.setCharacterEncoding("utf-8");
	    HttpSession 	session = request.getSession();
		 //依次从session 及cookie中查找user找出并加入到session
		 addUsserToSession(request, session);
		 chain.doFilter(request, response);
	}

	/* (非 Javadoc) 
	* <p>Title: destroy</p> 
	* <p>Description: </p>  
	* @see javax.servlet.Filter#destroy() 
	*/
	
	
	
	/**
	 * @param session TODO
	* @author：ymxtc	        
	* @date：2014年12月24日
	* @Description：以此从session,cookie,reponse中寻找user找到立即返回
	* @param request
	* @return: 返回结果描述
	* @return boolean: 返回值类型
	* @throws 
	*/
	private void addUsserToSession(HttpServletRequest request, HttpSession session)
	{
		User  user = null;
		//1,从session中找
	 user= (User) session.getAttribute("user");
	
	 //2如果没找到从cookies中找
	 if(null==user){
		 Cookie[]  cookies= request.getCookies();
		 if(null!=cookies){
			 user = getUserFromCookie(cookies);
		 }
		 //若果不为null  绑定到user
		 if(null!=user){
				session.setAttribute("user", user);
			}
	 }
	}

	/**
	* @author：ymxtc	        
	* @date：2014年12月24日
	* @Description：从cookie中检索出user并验证
	* @param cookies
	* @return: 返回结果描述
	* @return User: 返回值类型
	* @throws 
	*/
	private User getUserFromCookie(Cookie[] cookies)
	{
		UserService  service  = new  UserServiceImpl();
		User user=null;
	   String  username=null;
		String pwd = null;
		String cookiename;
		int  mark =0;
		
		//循环cookies如果找到username和pwd立即退出循环
		for(Cookie cookie:cookies){
			cookiename = cookie.getName();
    		if(cookiename.equals("username")){
    			username =  cookie.getValue();
    			mark++;
    		}
    		if(cookiename.equals("pwd")){
    			pwd= cookie.getValue();
    			mark++;
    		}
    		if(mark==2){
    			break;
    		}
		}
		
		//如果没有检索出username  返回false否则验证用户名和密码
	   if(null!=username){
		   //验证成功查找user返回true
		  boolean isRight = service.verifyUser(username,pwd);
		  if(isRight){
			  user = service.getUserByUserName(username);
		  }
	   }
	return user;
	}

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub
		
	}

}
