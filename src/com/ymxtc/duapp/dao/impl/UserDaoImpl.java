/**
 * <p>
 * 文件名称: UserDaoImpl.java
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
 * 内容摘要: 简要描述本文件的内容，包括主要模块、函数及能的说明
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
	 * (非 Javadoc) <p>Title: findUserById</p> <p>Description: </p>
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
			// 包装user
			user.setId(id);
			user.setUserName(rs.getString(2));
			user.setPwd(rs.getString(3));

		}
		conn.close();
		return user;
	}

	/*
	 * (非 Javadoc) <p>Title: getUserByusername</p> <p>Description: </p>
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
				// 包装user
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
	 * (非 Javadoc) <p>Title: validatUser</p> <p>Description: </p>
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
