/**
 * <p>
 * 文件名称: WebCatalog.java
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
package com.ymxtc.duapp.service.impl;

import java.util.List;

import com.ymxtc.duapp.dao.vo.Web;

/**
 * <p>内容摘要: 同种类型网站的封装</p>
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
     
   /* (非 Javadoc) 
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
