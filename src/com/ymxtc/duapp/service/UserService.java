/**
 * <p>
 * �ļ�����: UserServicce.java
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
package com.ymxtc.duapp.service;

import com.ymxtc.duapp.dao.vo.User;

/**
 * <p>����ժҪ: ��Ҫ�������ļ������ݣ�������Ҫģ�顢�������ܵ�˵��</p>
 * @author  ymxtc
 */
public interface UserService
{

	
	/**
	* @author��ymxtc	        
	* @date��2014��12��24��
	* @Description����֤�û�������
	* @param username
	* @param pwd
	* @return: ���ؽ������
	* @return boolean: ����ֵ����
	* @throws 
	*/
	boolean verifyUser(String username, String pwd);

	
	/**
	* @author��ymxtc	        
	* @date��2014��12��24��
	* @Description������username�����û�
	* @param username
	* @return: ���ؽ������
	* @return User: ����ֵ����
	* @throws 
	*/
	User getUserByUserName(String username);
	
       
	
}
