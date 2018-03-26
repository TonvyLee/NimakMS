package com.nimak.serviceinterface;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.bstek.dorado.annotation.Expose;
import com.nimak.entity.Turretarm;
import com.nimak.entity.Turretpart;

/**
 * interface TurretArmService
 * @author BUAA514
 *
 */
public interface TurretArmServiceI {
	
	/**
	 * 根据钳臂组件或者零件图号获取对应的零件或者组件
	 * @param sArmComponentno	： 组件或者零件图号
	 * @return 查到的钳臂组件或者零件
	 */
	public List<Turretarm> getTurretArmByDrawingNo(String sArmComponentno);
	
	
	
	/**
	 * 得到钳臂零件所有图号，用于下拉框关联
	 * @return
	 */
	public List<String> getAllTurretArmDrawingnos();
	
	
	/**
	 * 新增钳臂零件实例时判断输入的钳臂属性信息是否符合要求，并判断相应文件是否已经上传
	 * @param params
	 * @return
	 */
	public Map<String, String> isNewAddedTurretArmSatisfied(Map<String, Object> params);
	
	
	
	/**
	 * 根据钳臂图号找到对应的相关文件路径，然后删除之
	 * @param ID
	 * @return
	 */
	@Expose
	public String deleteRelatedFilesByArmDrawingno(String armDrawingno);
	
}
