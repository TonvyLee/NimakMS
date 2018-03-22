package com.nimak.daointerface;

import java.util.Collection;
import java.util.List;

import com.nimak.entity.Electrodeholder;
import com.nimak.exception.FileException;

/**
 * 电极握杆DAO接口
 * @author BUAA514
 *
 */
public interface ElectrodeHolderDaoI {

	/**
	 * 根据电极握杆图号获取对应点击握杆组件或者零件
	 * @param sShankDrawingno	： 组件或者零件图号
	 * @return 查到的电极握杆组件或者零件
	 */
	public List<Electrodeholder> getHolderByShankNo(String sShankDrawingno);
	
	
	/**
	 * 持久化
	 * @param allShanks
	 */
	public void saveAll(Collection<Electrodeholder> allShanks);
	
	
	/**
	 * 根据id找到id对应的电极握杆图号信息，然后根据图号将相关文件进行删除
	 * @param iD
	 * @return
	 */
	public String deleteRelatedFilesByID(String id) throws FileException; 
}
