/**
 * <p>
 * �ļ�����: WebService.java
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
package com.ymxtc.duapp.service;

import java.util.List;

import com.ymxtc.duapp.dao.vo.User;
import com.ymxtc.duapp.dao.vo.Web;
import com.ymxtc.duapp.service.impl.WebCatalog;



/**
 * <p>����ժҪ: ��Ҫ�������ļ������ݣ�������Ҫģ�顢�������ܵ�˵��</p>
 * @author  ymxtc
 */
public   interface WebService
{
	List<WebCatalog>  getWebCatalogsByUserId(String  Id);

	
	/**
	* @author��ymxtc	        
	* @date��2014��12��7��
	* @Description��������������
	* @param userId
	* @param web: ���ؽ������
	* @return void: ����ֵ����
	* @throws 
	*/
	int saveWeb(String userId, Web web);


	
	/**
	* @author��ymxtc	        
	* @date��2014��12��7��
	* @Description��������������
	* @param user
	* @return: ���ؽ������
	* @return List<Web>: ����ֵ����
	* @throws 
	*/
	List<WebCatalog> getWebsByUser(User user);
}
