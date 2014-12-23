/**
 * <p>
 * �ļ�����: DataBaseConnectUtil.java
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
package com.ymxtc.duapp.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>����ժҪ: ��Ҫ�������ļ������ݣ�������Ҫģ�顢�������ܵ�˵��</p>
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
	* @author��ymxtc	        
	* @date��2014��11��15��
	* @Description��������
	* @return
	* @throws ClassNotFoundException
	* @throws SQLException: ���ؽ������
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
	* @author��ymxtc	        
	* @date��2014��11��15��
	* @Description���ر�����
	* @throws SQLException: ���ؽ������
	* @return void: ����ֵ����
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
