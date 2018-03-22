package com.nimak.daointerface;

import java.util.Collection;

import com.nimak.entity.Bdf2User;

public interface Bdf2UserDaoI {

	/**
	 * 持久化
	 * @param allShanks
	 */
	public void saveAll(Collection<Bdf2User> allBdf2Users);
	
	
	
	/**
	 * 注册用户
	 * @param username
	 * @param cname
	 * @param ename
	 * @param password
	 * @param email
	 * @param mobile
	 * @param companyId
	 * @param enabled
	 * @param administrator
	 * @param male
	 * @return
	 */
	public String registerUser(String username, String cname,
			String ename, String password, String email, String mobile,
			String companyId,boolean enabled,boolean administrator,boolean male);
}
