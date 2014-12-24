/**
 * <p>
 * �ļ�����: UserDao.java
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
package com.ymxtc.duapp.dao;

import java.sql.SQLException;

import com.ymxtc.duapp.dao.vo.User;

/**
 * <p>����ժҪ: ��Ҫ�������ļ������ݣ�������Ҫģ�顢�������ܵ�˵��</p>
 * @author  ymxtc
 */
public interface UserDao
{

	
	

	
	/**
	* @author��ymxtc	        
	* @date��2014��11��15��
	* @Description��������������
	* @param user
	* @return
	* @throws SQLException: ���ؽ������
	* @return User: ����ֵ����
	* @throws 
	*/
	User findUserById(int userid) throws SQLException;

	
	/**
	* @author��ymxtc	        
	* @date��2014��11��15��
	* @Description��������������
	* @param username
	* @return: ���ؽ������
	* @return User: ����ֵ����
	* @throws 
	*/
	User getUserByuserName(String username) ;


	
	/**
	* @author��ymxtc	        
	* @date��2014��12��24��
	* @Description��������������
	* @param username
	* @param pwd
	* @return: ���ؽ������
	* @return boolean: ����ֵ����
	* @throws 
	*/
	boolean validatUser(String username, String pwd) ;
	
}
