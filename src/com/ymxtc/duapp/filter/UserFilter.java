/**
 * <p>
 * �ļ�����: UserFilter.java
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
 * �������: 2014��12��24��
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
 * <p>����ժҪ:�z���Ñ�</p>
 * @author  ymxtc
 */
public class UserFilter implements Filter
{
	
	/* (�� Javadoc) 
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

	/* (�� Javadoc) 
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
		//ǿת
		HttpServletRequest request = (HttpServletRequest)q;
		HttpServletResponse 	response = (HttpServletResponse)r;
		//���ñ���
		request.setCharacterEncoding("utf-8");
	    HttpSession 	session = request.getSession();
		 //���δ�session ��cookie�в���user�ҳ������뵽session
		 addUsserToSession(request, session);
		 chain.doFilter(request, response);
	}

	/* (�� Javadoc) 
	* <p>Title: destroy</p> 
	* <p>Description: </p>  
	* @see javax.servlet.Filter#destroy() 
	*/
	
	
	
	/**
	 * @param session TODO
	* @author��ymxtc	        
	* @date��2014��12��24��
	* @Description���Դ˴�session,cookie,reponse��Ѱ��user�ҵ���������
	* @param request
	* @return: ���ؽ������
	* @return boolean: ����ֵ����
	* @throws 
	*/
	private void addUsserToSession(HttpServletRequest request, HttpSession session)
	{
		User  user = null;
		//1,��session����
	 user= (User) session.getAttribute("user");
	
	 //2���û�ҵ���cookies����
	 if(null==user){
		 Cookie[]  cookies= request.getCookies();
		 if(null!=cookies){
			 user = getUserFromCookie(cookies);
		 }
		 //������Ϊnull  �󶨵�user
		 if(null!=user){
				session.setAttribute("user", user);
			}
	 }
	}

	/**
	* @author��ymxtc	        
	* @date��2014��12��24��
	* @Description����cookie�м�����user����֤
	* @param cookies
	* @return: ���ؽ������
	* @return User: ����ֵ����
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
		
		//ѭ��cookies����ҵ�username��pwd�����˳�ѭ��
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
		
		//���û�м�����username  ����false������֤�û���������
	   if(null!=username){
		   //��֤�ɹ�����user����true
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
