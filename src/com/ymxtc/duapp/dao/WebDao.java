/**
 * <p>
 * �ļ�����: WebDao.java
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
package com.ymxtc.duapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ymxtc.duapp.dao.vo.Web;

/**
 * <p>����ժҪ: ��Ҫ�������ļ������ݣ�������Ҫģ�顢�������ܵ�˵��</p>
 * @author  ymxtc
 */
public interface WebDao
{

	
	/**
	* @author��ymxtc	        
	* @date��2014��12��7��
	* @Description��������������
	* @param id: ���ؽ������
	* @return void: ����ֵ����
	* @throws 
	*/
	List<Web> findWebsbyUserId(int id);
     
	List<Web>  findWebsByUserIdwithClass(int userid ,String clazz) ;
	
	List<String> findWebClazzByUserId(int userid);
}
