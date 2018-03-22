package com.nimak.daointerface;

import java.util.Collection;

import com.nimak.entity.Turret;
import com.nimak.exception.FileException;

public interface TurretDaoI {
	
	/**
	 * 持久化
	 * @param allTurrets：持久化对象
	 */
	public void saveAll(Collection<Turret> allTurrets);
	
	
	/**
	 * 根据id找到id对应的焊钳图号信息，然后根据图号将相关文件进行删除
	 * @param iD
	 * @return
	 */
	public String deleteRelatedFilesByID(String iD) throws FileException;

}
