/**
 * <p>
 * 文件名称: WebDao.java
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
package com.ymxtc.duapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ymxtc.duapp.dao.vo.Web;

/**
 * <p>内容摘要: 简要描述本文件的内容，包括主要模块、函数及能的说明</p>
 * @author  ymxtc
 */
public interface WebDao
{

	
	/**
	* @author：ymxtc	        
	* @date：2014年12月7日
	* @Description：方法功能描述
	* @param id: 返回结果描述
	* @return void: 返回值类型
	* @throws 
	*/
	List<Web> findWebsbyUserId(int id);
     
	List<Web>  findWebsByUserIdwithClass(int userid ,String clazz) ;
	
	List<String> findWebClazzByUserId(int userid);
}
