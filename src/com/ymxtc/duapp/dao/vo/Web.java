/**
 * <p>
 * �ļ�����: Web.java
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
 * �������: 2014��11��16��
 * </p>
 * @author ymxtc
 */
package com.ymxtc.duapp.dao.vo;

/**
 * <p>����ժҪ: ��վ</p>
 * @author  ymxtc
 */
public class Web
{

	//��վid
	private int id;
	//��վ����
	private String webname;
	//��վurl
	private  String webUrl;
	//��վ����
	private  String  Clazz;
	//������Id
	private int userId;
	
	//����
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
