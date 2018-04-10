package com.nimak.serviceinterface;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;
import com.nimak.daointerface.TurretDaoI;
import com.nimak.entity.Turret;


public interface TurretServiceI {
	

	
	/**
	 * 获取焊钳信息
	 * @param page
	 * @param criteria
	 * @throws Exception
	 */
	public void getAllTurretInfoByPage(Page<Turret> page,Criteria criteria) throws Exception;
	
	
	/**
	 * 获取所有焊钳
	 * @return
	 */
	public List<Turret>getAllTurretInfo();	
	
	

	/**
	 * 分页条件查询
	 * @param page
	 * @param params
	 * @throws Exception 
	 */

	public void queryForCondition(Page<Turret> page,Map<String, Object> params) throws Exception;

	/**
	 * 持久化
	 * @param allTurrets
	 */
	void saveAll(Collection<Turret> allTurrets);
	
	
	/**
	 * 新增焊钳实例时判断输入的焊钳信息是否符合要求
	 * @param params
	 * @return
	 */
	public String isNewAddedTurretSatisfied(Map<String, Object> params);
	
	
	/**
	 * 根据id找到对应的相关文件路径，然后删除之
	 * @param ID
	 * @return
	 */
	@Expose
	public String deleteRelatedFilesByID(String ID);
}



















