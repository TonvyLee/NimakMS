package com.nimak.serviceinterface;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.nimak.entity.Bdf2User;

public interface Bdf2UserServiceI {
	
	/**
	 * 分页条件查询用户
	 * @param page
	 * @param params
	 * @throws Exception 
	 */

	public void queryForCondition(Page<Bdf2User> page,Map<String, Object> params) throws Exception;

	/**
	 * 持久化
	 * @param allShanks
	 */
	void saveAll(Collection<Bdf2User> allShanks);
	
	
	/**
	 * 获取所有用户
	 * @return
	 */
	public List<Bdf2User> getAllUsers();
	
	
	/**
	 * 注册新用户
	 * @return
	 */
	public String registerUser(Map<String, Object> params);


}
