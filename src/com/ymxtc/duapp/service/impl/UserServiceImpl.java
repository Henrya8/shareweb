/**
 * <p>
 * 文件名称: UserServiceImpl.java
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
 * 完成日期: 2014年11月15日
 * </p>
 * @author ymxtc
 */
package com.ymxtc.duapp.service.impl;

import com.ymxtc.duapp.dao.vo.User;
import com.ymxtc.duapp.service.UserService;


/**
 * <p>内容摘要: 简要描述本文件的内容，包括主要模块、函数及能的说明</p>
 * @author  ymxtc
 */
public class UserServiceImpl implements  UserService
{

	/* (非 Javadoc) 
	* <p>Title: verifyUser</p> 
	* <p>Description: </p> 
	* @param username
	* @param pwd
	* @return 
	* @see com.ymxtc.duapp.service.UserService#verifyUser(java.lang.String, java.lang.String) 
	*/
	
	@Override
	public boolean verifyUser(String username, String pwd)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (非 Javadoc) 
	* <p>Title: getUserByUserName</p> 
	* <p>Description: </p> 
	* @param username
	* @return 
	* @see com.ymxtc.duapp.service.UserService#getUserByUserName(java.lang.String) 
	*/
	
	@Override
	public User getUserByUserName(String username)
	{
		// TODO Auto-generated method stub
		return null;
	}

	


}
