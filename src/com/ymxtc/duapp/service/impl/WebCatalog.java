/**
 * <p>
 * �ļ�����: WebCatalog.java
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
 * �������: 2014��12��7��
 * </p>
 * @author ymxtc
 */
package com.ymxtc.duapp.service.impl;

import java.util.List;

import com.ymxtc.duapp.dao.vo.Web;

/**
 * <p>����ժҪ: ͬ��������վ�ķ�װ</p>
 * @author  ymxtc
 */
public class WebCatalog
{
	
	private  List<Web> webs;
	private  String   clazz;
	public WebCatalog(){
		
	}
    public 	WebCatalog(List<Web>  webs,String clazz){
	  this.webs=webs;
	  this.clazz=clazz;
  }
	public List<Web> getWebs()
	{
		return webs;
	}
	public void setWebs(List<Web> webs)
	{
		this.webs = webs;
	}
	public String getClazz()
	{
		return clazz;
	}
	public void setClazz(String calzz)
	{
		this.clazz = calzz;
	}
	
   public int size(){
	   if(webs==null ){
		 return -1;
	   }
	   return webs.size();
   }
     
   /* (�� Javadoc) 
* <p>Title: toString</p> 
* <p>Description: </p> 
* @return 
* @see java.lang.Object#toString() 
*/

@Override
public String toString()
{
	// TODO Auto-generated method stub
	return webs.toString();
}
    
}
