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
import com.nimak.entity.Turretpart;


public interface TurretComponentServiceI {
	

	
	/**
	 * 获取钳臂信息,分页查询
	 * @param page
	 * @param criteria
	 * @throws Exception
	 */
	public void getAllTurretComponentInfoByPage(Page<Turretpart> page,Criteria criteria) throws Exception;
	
	
	/**
	 * 获取所有钳臂
	 * @return
	 */
	public List<Turretpart>getAllTurretComponentInfo();	
	
	

	/**
	 * 分页条件查询
	 * @param page
	 * @param params
	 * @throws Exception 
	 */

	public void queryForCondition(Page<Turretpart> page,Map<String, Object> params) throws Exception;

	/**
	 * 持久化
	 * @param allTurretComponents
	 */
	void saveAll(Collection<Turretpart> allTurretComponents);
	
	
	/**
	 * 新增钳臂部件实例时判断输入的钳臂信息是否符合要求
	 * @param params
	 * @return
	 */
	public Map<String, String> isNewAddedTurretSatisfied(Map<String, Object> params);
	
	
	/**
	 * 根据id找到对应的相关文件路径，然后删除之
	 * @param ID
	 * @return
	 */
	@Expose
	public String deleteRelatedFilesByID(String ID);
	
	
	/**
	 * 根据传入参数Map对钳臂部件进行编码
	 * @param params	参数map
	 * @return	map中键值主要有flag，如果flag == S_OK;则map中还含有键值：coderesult，其对应的值就是编码值
	 * 			否则map中只有flag键值，并且其值为E_Fail
	 */
	public Map<String , String> codeTurretComponentByParameter(Map<String, Object> params);
	
	
	
	/**
	 * 根据钳臂部件的图号查询到钳臂组件
	 * @param armAssemblyno  钳臂部件图号
	 * @return				钳臂部件
	 */
	public Collection<Turretpart> getTurretComponentByDrawingno(String armAssemblyno);
	
	/**
	 * 根据钳臂部件的图号查询到钳臂组件图号，模糊查询，返回钳臂图号
	 * @param armAssemblyno
	 * @return
	 */
	public List<String> getTurretComponentDrawingByDrawingno(String armAssemblyno);
	
	/**
	 * 得到部件所有图号，用于下拉框关联
	 * @return
	 */
	public List<String> getAllTurretCompDrawingnos();
}



















