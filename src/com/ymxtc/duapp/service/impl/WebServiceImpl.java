/**
 * <p>
 * 文件名称: WebServiceImpl.java
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
package com.ymxtc.duapp.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.ymxtc.duapp.dao.WebDao;
import com.ymxtc.duapp.dao.impl.WebDaoImpl;
import com.ymxtc.duapp.dao.vo.User;
import com.ymxtc.duapp.dao.vo.Web;
import com.ymxtc.duapp.service.WebService;

/**
 * <p>内容摘要: 简要描述本文件的内容，包括主要模块、函数及能的说明</p>
 * @author  ymxtc
 */
public class WebServiceImpl   implements  WebService
{
	
	private WebDao  webDao;

	/* (非 Javadoc) 
	* <p>Title: getWebsByUserId</p> 
	* <p>Description: </p> 
	* @param Id
	* @return 
	* @see com.ymxtc.duapp.service.WebService#getWebsByUserId(int) 
	*/
	
	@Override
	public List<WebCatalog> getWebCatalogsByUserId(int id)
	{
		
		WebCatalog  wc ;
		List<WebCatalog>  webCatalogs= new ArrayList<WebCatalog>();
		List<String>  clazzs;
			clazzs = webDao.findWebClazzByUserId(id);
			for(String clazz :clazzs){
				wc = new WebCatalog();
				wc.setClazz(clazz);
				wc.setWebs(webDao.findWebsByUserIdwithClass(id, clazz));
				webCatalogs.add(wc);
			}
		return webCatalogs;
	}

	public WebDao getWebDao()
	{
		return webDao;
	}

	public void setWebDao(WebDao webDao)
	{
		this.webDao = webDao;
	}

	public   WebServiceImpl(){
		webDao=new  WebDaoImpl();
	}

	/* (非 Javadoc) 
	* <p>Title: saveWeb</p> 
	* <p>Description: </p> 
	* @param userId
	* @param web
	* @return 
	* @see com.ymxtc.duapp.service.WebService#saveWeb(java.lang.String, com.ymxtc.duapp.dao.vo.Web) 
	*/
	
	@Override
	public int saveWeb(String userId, Web web)
	{
		// TODO Auto-generated method stub
		return 1;
	}

	/* (非 Javadoc) 
	* <p>Title: getWebsByUserId</p> 
	* <p>Description: </p> 
	* @param user
	* @return 
	* @see com.ymxtc.duapp.service.WebService#getWebsByUserId(com.ymxtc.duapp.dao.vo.User) 
	*/
	
	@Override
	public List<WebCatalog> getWebsByUser(User user)
	{
		
		return this.getWebCatalogsByUserId(user.getId());
	
	}
	public static void main(String[] args)
	{
		WebServiceImpl  webServiceImpl  =  new WebServiceImpl();
		User  user = new User();
		user.setId(0);
		ArrayList<String>  as= new ArrayList<String>();
	
		 JSONArray jsonArray =  JSONArray.fromObject(webServiceImpl.getWebsByUser(user));
		
	}

	/* (非 Javadoc) 
	* <p>Title: getWebCatalogsByUserName</p> 
	* <p>Description: </p> 
	* @param userName
	* @return 
	* @see com.ymxtc.duapp.service.WebService#getWebCatalogsByUserName(java.lang.String) 
	*/
	
	@Override
	public List<WebCatalog> getWebCatalogsByUserName(String userName)
	{
		return null;
	}
	
}
