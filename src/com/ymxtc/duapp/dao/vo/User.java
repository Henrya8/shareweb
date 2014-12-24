/**
 * <p>
 * 文件名称: User.java
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
 * 完成日期: 2014年11月13日
 * </p>
 * @author ymxtc
 */
package com.ymxtc.duapp.dao.vo;

import java.sql.Date;

/**
 * <p>内容摘要: 简要描述本文件的内容，包括主要模块、函数及能的说明</p>
 * @author  ymxtc
 */
public class User
{

	//用户Id
	private int id ;
	//用户名
	private String userName;
	//密码
	private String pwd;
	//用户类型
	private int type;
	//邮箱
	private String email;
	//注册日期
	private  Date  registerDate;
	//最后登陆日期
	private Date lastLoginDate;
	//昵称
	private String nickName;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	public int getType()
	{
		return type;
	}
	public void setType(int type)
	{
		this.type = type;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public Date getRegisterDate()
	{
		return registerDate;
	}
	public void setRegisterDate(Date registerDate)
	{
		this.registerDate = registerDate;
	}
	public Date getLastLoginDate()
	{
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate)
	{
		this.lastLoginDate = lastLoginDate;
	}
	public String getNickName()
	{
		return nickName;
	}
	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}
	
}
