package com.nimak.serviceinterface;

import java.util.List;

import org.apache.log4j.Logger;

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
}
