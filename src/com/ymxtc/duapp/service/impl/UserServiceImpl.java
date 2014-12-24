/**
 * <p>
 * �ļ�����: UserServiceImpl.java
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
 * �������: 2014��11��15��
 * </p>
 * @author ymxtc
 */
package com.ymxtc.duapp.service.impl;

import java.sql.SQLException;

import com.ymxtc.duapp.dao.UserDao;
import com.ymxtc.duapp.dao.impl.UserDaoImpl;
import com.ymxtc.duapp.dao.vo.User;
import com.ymxtc.duapp.service.UserService;
import com.ymxtc.duapp.util.Encrypt;


/**
 * <p>����ժҪ: ��Ҫ�������ļ������ݣ�������Ҫģ�顢�������ܵ�˵��</p>
 * @author  ymxtc
 */
public class UserServiceImpl implements  UserService
{

	
	private UserDao userDao;
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */

	public UserServiceImpl()
	{
		userDao = new UserDaoImpl();
	}
	
	/* (�� Javadoc) 
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
		
		return userDao.validatUser(username,pwd);
	}

	/* (�� Javadoc) 
	* <p>Title: getUserByUserName</p> 
	* <p>Description: </p> 
	* @param username
	* @return 
	* @see com.ymxtc.duapp.service.UserService#getUserByUserName(java.lang.String) 
	*/
	
	@Override
	public User getUserByUserName(String username)
	{
		return userDao.getUserByuserName(username);
	}

	


}
