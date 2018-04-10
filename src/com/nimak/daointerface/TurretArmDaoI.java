package com.nimak.daointerface;

import java.util.List;

import com.nimak.entity.Turretarm;
import com.nimak.exception.FileException;

public interface TurretArmDaoI {
	
	
	/**
	 * dao根据钳臂组件或者零件图号查询到对应的钳臂组件或者钳臂零件
	 * @param sArmComponentno：		钳臂组件或者零件图号
	 * @return：						查询到的产品组件或者零件
	 */
	public List<Turretarm> getTurretArmByDrawingNo(String sArmComponentno);

	
	
	/**
	 * 根据钳臂图号找到钳臂图号对应的钳臂图号信息，然后根据图号将相关文件进行删除
	 * @param armDrawingno
	 * @return
	 */
	public String deleteRelatedFilesByArmDrawingno(String armDrawingno) throws FileException; 
	
}
