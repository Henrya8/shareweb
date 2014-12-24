/**
 * <p>
 * 文件名称: WebDAo.java
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
package com.ymxtc.duapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ymxtc.duapp.dao.WebDao;
import com.ymxtc.duapp.dao.vo.Web;
import com.ymxtc.duapp.dbc.DataBaseConnection;

/**
 * <p>内容摘要: 简要描述本文件的内容，包括主要模块、函数及能的说明</p>
 * @author  ymxtc
 */
public class WebDaoImpl   implements WebDao
{

	private DataBaseConnection dbc ;
	public WebDaoImpl(){
		dbc  =  new DataBaseConnection();
		
	}
	
	
	/* (非 Javadoc) 
	* <p>Title: findWebsbyUserId</p> 
	* <p>Description: </p> 
	* @param id
	* @return 
	* @see com.ymxtc.duapp.dao.WebDao#findWebsbyUserId(int) 
	*/
	
	@Override
	public List<Web> findWebsbyUserId(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (非 Javadoc) 
	* <p>Title: findWebsByIdwithClass</p> 
	* <p>Description: </p> 
	* @param id
	* @param clazz
	* @return 
	* @see com.ymxtc.duapp.dao.WebDao#findWebsByIdwithClass(int, java.lang.String) 
	*/
	
	@Override
	public List<Web> findWebsByUserIdwithClass(int id, String clazz)
	{
	     Connection  conn=  dbc.getConnection();
	     List<Web>   webs = new ArrayList<Web>();
	     PreparedStatement   ps =null;
	    try
		{
			ps =conn.prepareStatement("select id,webname,weburl from web where userid = ? and clazz=?");
			 ps.setInt(1, id);
			 ps.setString(2, clazz);
			 ps.executeQuery();
			 ResultSet rs =   ps.getResultSet();
			 
			 Web  web;
			 while(rs.next()){
				web = new Web();
				web.setUserId(id);
				web.setClazz(clazz);
				web.setId(rs.getInt(1));
				web.setWebname(rs.getString(2));
				web.setWebUrl(rs.getString(3));
				
				webs.add(web);
			 }
			 conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return webs;
	}


	/* (非 Javadoc) 
	* <p>Title: findWebClazzByUserId</p> 
	* <p>Description: </p> 
	* @param userid
	* @return
	* @throws SQLException 
	* @see com.ymxtc.duapp.dao.WebDao#findWebClazzByUserId(int) 
	*/
	
	@Override
	public List<String> findWebClazzByUserId(int userid)
	{
		 Connection  conn=  dbc.getConnection();
	     List<String>   webs = new ArrayList<String>();
	     PreparedStatement   ps=null;
	     try
		{
			ps=conn.prepareStatement("select  distinct clazz  from web where userid = ? ");
			 ps.setInt(1, userid);
			 ps.executeQuery();
			 ResultSet rs =   ps.getResultSet();
			
			 String  clazz;
			 while(rs.next()){
				 clazz = rs.getString(1);
				webs.add(clazz);
			 }
			 conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return webs;
	}
public static void main(String[] args)
{
	WebDaoImpl   d  = new WebDaoImpl();
	System.out.println(d.findWebClazzByUserId(0));
	System.out.println(d.findWebsByUserIdwithClass(0, "视频"));
}
	
	
}
