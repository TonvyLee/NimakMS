package com.nimak.serviceinterface;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;
import com.nimak.entity.Electrodeholder;
import com.nimak.entity.Turretpart;

public interface ElectrodeHolderServiceI {
	
	/**
	 * 获取握杆信息,分页查询
	 * @param page
	 * @param criteria
	 * @throws Exception
	 */
	public void getAllShanksInfoByPage(Page<Electrodeholder> page,Criteria criteria) throws Exception;
	
	
	/**
	 * 获取所有握杆
	 * @return
	 */
	public List<Electrodeholder>getAllShanksInfo();	
	
	

	/**
	 * 分页条件查询
	 * @param page
	 * @param params
	 * @throws Exception 
	 */

	public void queryForCondition(Page<Electrodeholder> page,Map<String, Object> params) throws Exception;

	/**
	 * 持久化
	 * @param allShanks
	 */
	void saveAll(Collection<Electrodeholder> allShanks);
	
	
	/**
	 * 新增握杆零件实例时判断输入的握杆属性信息是否符合要求，并判断相应文件是否已经上传
	 * @param params
	 * @return
	 */
	public Map<String, String> isNewAddedShankSatisfied(Map<String, Object> params);
	
	
	/**
	 * 根据id找到对应的相关文件路径，然后删除之
	 * @param ID
	 * @return
	 */
	@Expose
	public String deleteRelatedFilesByID(String ID);
	
	
	/**
	 * 根据传入参数Map对点击握杆组件或者零件进行编码
	 * @param params	参数map
	 * @return	map中键值主要有flag，如果flag == S_OK;则map中还含有键值：coderesult，其对应的值就是编码值
	 * 			否则map中只有flag键值，并且其值为E_Fail
	 */
	public Map<String, String> codeShankByParameter(Map<String, Object> params);
	
	
	
	
	/**
	 * 根据电极握杆的图号查询到电极握杆
	 * @param armAssemblyno  电极握杆图号
	 * @return				电极握杆
	 */
	public Collection<Electrodeholder> getShankByDrawingno(String shankDrawingno);
	
	
	/**
	 * 得到部件所有图号，用于下拉框关联
	 * @return
	 */
	public List<String> getAllTurretShankDrawingnos();
	
}
