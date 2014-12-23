/**
 * <p>
 * 文件名称: Web.java
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
 * 完成日期: 2014年11月16日
 * </p>
 * @author ymxtc
 */
package com.ymxtc.duapp.dao.vo;

/**
 * <p>内容摘要: 网站</p>
 * @author  ymxtc
 */
public class Web
{

	//网站id
	private int id;
	//网站名字
	private String webname;
	//网站url
	private  String webUrl;
	//网站分类
	private  String  Clazz;
	//所有人Id
	private int userId;
	
	//次序
	private  int  order;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getWebname()
	{
		return webname;
	}
	public void setWebname(String webname)
	{
		this.webname = webname;
	}
	public String getWebUrl()
	{
		return webUrl;
	}
	public void setWebUrl(String webUrl)
	{
		this.webUrl = webUrl;
	}
	public String getClazz()
	{
		return Clazz;
	}
	public void setClazz(String clazz)
	{
		Clazz = clazz;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getOrder()
	{
		return order;
	}
	public void setOrder(int order)
	{
		this.order = order;
	}
	
}
