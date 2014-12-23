/**
 * <p>
 * 文件名称: DataBaseConnectUtil.java
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
package com.ymxtc.duapp.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>内容摘要: 简要描述本文件的内容，包括主要模块、函数及能的说明</p>
 * @author  ymxtc
 */
public class DataBaseConnection
{
	private  String dbDriver ;
	private  String dbUsername ;
	private  String dbPasswd;
	private  String dbConnUrl;
	private  Connection  conn;
	
	public DataBaseConnection(String dbDriver, String dbUsername,
			String dbPasswd, String dbConnUrl, Connection conn)
	{
		this.dbDriver = dbDriver;
		this.dbUsername = dbUsername;
		this.dbPasswd = dbPasswd;
		this.dbConnUrl = dbConnUrl;
		this.conn = conn;
	}
	
	/** 
	* <p>Title: </p> 
	* <p>Description: </p>  
	*/
	
	public DataBaseConnection()
	{
		 dbDriver ="oracle.jdbc.OracleDriver";
		 dbUsername ="scott";
		 dbPasswd="scott";
	   dbConnUrl="jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	}

	/**
	 * 
	* @author：ymxtc	        
	* @date：2014年11月15日
	* @Description：打开连接
	* @return
	* @throws ClassNotFoundException
	* @throws SQLException: 返回结果描述
	* @return Connection:
	* @throws
	 */
	public   Connection  getConnection(){
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			 conn  = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","scott","scott");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  conn;
	}
	/**
	 * 
	* @author：ymxtc	        
	* @date：2014年11月15日
	* @Description：关闭连接
	* @throws SQLException: 返回结果描述
	* @return void: 返回值类型
	* @throws
	 */
	public   void   closeConnection(){
		try
		{
			conn.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		
	}
}
