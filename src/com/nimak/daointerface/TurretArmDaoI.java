package com.nimak.daointerface;

import java.util.List;

import com.nimak.entity.Turretarm;

public interface TurretArmDaoI {
	
	
	/**
	 * dao根据钳臂组件或者零件图号查询到对应的钳臂组件或者钳臂零件
	 * @param sArmComponentno：		钳臂组件或者零件图号
	 * @return：						查询到的产品组件或者零件
	 */
	public List<Turretarm> getTurretArmByDrawingNo(String sArmComponentno);

}
