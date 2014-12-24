/**
 * <p>
 * 文件名称: UserDao.java
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
package com.ymxtc.duapp.dao;

import java.sql.SQLException;

import com.ymxtc.duapp.dao.vo.User;

/**
 * <p>内容摘要: 简要描述本文件的内容，包括主要模块、函数及能的说明</p>
 * @author  ymxtc
 */
public interface UserDao
{

	
	

	
	/**
	* @author：ymxtc	        
	* @date：2014年11月15日
	* @Description：方法功能描述
	* @param user
	* @return
	* @throws SQLException: 返回结果描述
	* @return User: 返回值类型
	* @throws 
	*/
	User findUserById(int userid) throws SQLException;

	
	/**
	* @author：ymxtc	        
	* @date：2014年11月15日
	* @Description：方法功能描述
	* @param username
	* @return: 返回结果描述
	* @return User: 返回值类型
	* @throws 
	*/
	User getUserByuserName(String username) ;


	
	/**
	* @author：ymxtc	        
	* @date：2014年12月24日
	* @Description：方法功能描述
	* @param username
	* @param pwd
	* @return: 返回结果描述
	* @return boolean: 返回值类型
	* @throws 
	*/
	boolean validatUser(String username, String pwd) ;
	
}
