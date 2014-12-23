/**
 * <p>
 * �ļ�����: Mainservlet.java
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
 * �������: 2014��11��13��
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

import org.omg.CORBA.Request;

import com.ymxtc.duapp.dao.UserDao;
import com.ymxtc.duapp.dao.impl.UserDaoImpl;
import com.ymxtc.duapp.dao.vo.User;
import com.ymxtc.duapp.dao.vo.Web;
import com.ymxtc.duapp.service.WebService;
import com.ymxtc.duapp.service.impl.WebCatalog;
import com.ymxtc.duapp.service.impl.WebServiceImpl;

/**
 * <p>����ժҪ: ��Ҫ�������ļ������ݣ�������Ҫģ�顢�������ܵ�˵��</p>
 * @author  ymxtc
 */
public class MainServlet  extends HttpServlet
{
	
	/** 
	* @Fields serialVersionUID 
	*/
	
	private static final long	serialVersionUID	= 2699799887871009885L;

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
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
	    Cookie[]  cookies =    request.getCookies();
	    String userId = null;
	    String  cookiename=null;
	    String   pwdId = null;
	    boolean islogin=false;
	    
	    
	    WebService webService = new WebServiceImpl();
	    List<WebCatalog>  webCatalogs =null;
	    //��֤�ͻ����Ƿ���cookie����м������û���Ϣ
	    if(cookies!=null){
	    	for(Cookie cookie:cookies){
	    		cookiename = cookie.getName();
	    		if(cookiename.equals("userId")){
	    			userId =  cookie.getValue();
	    		}
	    		if(cookiename.equals("pwdId")){
	    			pwdId= cookie.getValue();
	    		}
	    		
	    		if(userId!=null && pwdId!=null){
	    			islogin=true;
	    			break;
	    		}
	    	}
	    }
	    //����м������û���Ϣ��֤�û�������֤�ɹ������û�����
	    if(islogin){
	    	User  user=null;
	    	UserDao   userDao = new UserDaoImpl();
	       try
		{
			user = 	userDao.findUserById(Integer.valueOf(userId));
		} catch (NumberFormatException e)
		{
			
			e.printStackTrace();
		} catch (SQLException e)
		{
		
			e.printStackTrace();
		}
	       
	       if(user!=null&&user.getPwd().equals(pwdId)){//��֤�û�������ɹ� 
	    	   webCatalogs = webService.getWebsByUser(user);
				//TODO  �����û���������
	    	   request.setAttribute("user", user.getUserName());
		       request.setAttribute("haslogin", true);
		       Cookie idCookie=new Cookie("userId" ,String.valueOf(user.getId()));
		       idCookie.setMaxAge(7*24*3600);
		       Cookie pwdCookie=new Cookie("pwdId" ,user.getUserName());
		       pwdCookie.setMaxAge(7*24*3600);
		       //����cookie
		       response.addCookie(pwdCookie);
		       response.addCookie(idCookie);
		       request.setAttribute("webCatalogs", webCatalogs);
		       request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		       return;
			}
	    }
	     //����һ���������Ĭ������
	  
	    webCatalogs = webService.getWebCatalogsByUserId("0");
	      request.setAttribute("webCatalogs", webCatalogs);
		   request.setAttribute("user", "�ο�");
	      request.setAttribute("haslogin",false);
	      request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			}
	
 		
	

}
