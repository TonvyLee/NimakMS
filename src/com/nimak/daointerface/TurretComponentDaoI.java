package com.nimak.daointerface;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.nimak.entity.Turretpart;
import com.nimak.exception.FileException;

public interface TurretComponentDaoI {
	
	/**
	 * 持久化
	 * @param allTurretComponents：持久化对象
	 */
	public void saveAll(Collection<Turretpart> allTurretComponents);
	
	
	/**
	 * 根据id找到id对应的钳臂图号信息，然后根据图号将相关文件进行删除
	 * @param iD
	 * @return
	 */
	public String deleteRelatedFilesByID(String iD) throws FileException;
	
	
	/**
	 * 根据部件图号，获取组成部件的钳臂组件和电极握杆组件的图号
	 * @param componentDrawingno
	 * @return
	 */
	public Map<String, String> getPartNos(String componentDrawingno);
	
}
