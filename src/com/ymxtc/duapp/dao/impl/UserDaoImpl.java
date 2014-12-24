/**
 * <p>
 * �ļ�����: UserDaoImpl.java
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
package com.ymxtc.duapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ymxtc.duapp.dao.UserDao;
import com.ymxtc.duapp.dao.vo.User;
import com.ymxtc.duapp.dbc.DataBaseConnection;

/**
 * <p>
 * ����ժҪ: ��Ҫ�������ļ������ݣ�������Ҫģ�顢�������ܵ�˵��
 * </p>
 * 
 * @author ymxtc
 */
public class UserDaoImpl implements UserDao
{

	private DataBaseConnection	dbc;

	public UserDaoImpl()
	{
		dbc = new DataBaseConnection();
	}

	/*
	 * (�� Javadoc) <p>Title: findUserById</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.ymxtc.duapp.dao.UserDao#findUserById()
	 */
	@Override
	public User findUserById(int id) throws SQLException
	{

		User user = null;
		Connection conn = dbc.getConnection();

		PreparedStatement ps = conn
				.prepareStatement("select * from iuser where id=?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next())
		{
			user = new User();
			// ��װuser
			user.setId(id);
			user.setUserName(rs.getString(2));
			user.setPwd(rs.getString(3));

		}
		conn.close();
		return user;
	}

	/*
	 * (�� Javadoc) <p>Title: getUserByusername</p> <p>Description: </p>
	 * 
	 * @param username
	 * 
	 * @return
	 * 
	 * @see com.ymxtc.duapp.dao.UserDao#getUserByusername(java.lang.String)
	 */

	@Override
	public User getUserByuserName(String username)
	{

		User user = new User();
		Connection conn = dbc.getConnection();

		PreparedStatement ps;
		try
		{
			ps = conn.prepareStatement("select * from iuser where name=?");

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next())
			{
				// ��װuser
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));

				user.setPwd(rs.getString(3));

				
			}
			conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}

	public static void main(String[] args)
	{

	}

	/*
	 * (�� Javadoc) <p>Title: validatUser</p> <p>Description: </p>
	 * 
	 * @param username
	 * 
	 * @param pwd
	 * 
	 * @return
	 * 
	 * @throws SQLException
	 * 
	 * @see com.ymxtc.duapp.dao.UserDao#validatUser(java.lang.String,
	 * java.lang.String)
	 */

	@Override
	public boolean validatUser(String username, String pwd)
	{

		Connection conn = dbc.getConnection();

		PreparedStatement ps;
		try
		{
			ps = conn
					.prepareStatement("select * from iuser where name=? and pwd=?");
			ps.setString(1, username);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
			{
				return true;
			}
			conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
