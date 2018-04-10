package com.nimak.serviceimp;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf2.core.cache.ApplicationCache;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.nimak.daoimp.Bdf2UserDaoImp;
import com.nimak.entity.Bdf2User;
import com.nimak.entity.Electrodeholder;
import com.nimak.serviceinterface.Bdf2UserServiceI;


@Component
public class Bdf2UserServiceImp implements Bdf2UserServiceI{
	ApplicationCache applicationCache = ContextHolder.getBean(ApplicationCache.BEAN_ID);
	
	@Resource
	public Bdf2UserDaoImp bdf2UserDaoImp;
	
	@Override
	@DataProvider
	public void queryForCondition(Page<Bdf2User> page,
			Map<String, Object> params) throws Exception {
		//条件查询
	}

	@Override
	@DataResolver
	@Transactional
	public void saveAll(Collection<Bdf2User> allBdf2Users) {
		bdf2UserDaoImp.saveAll(allBdf2Users);
	}

	@Override
	@DataProvider
	public List<Bdf2User> getAllUsers() {
		String hql = "from " + Bdf2User.class.getName() + "";
		//return bdf2UserDaoImp.getJdbcTemplate().query(hql);
		return null;
	}
	

	@Override
	@Expose
	@Transactional
	public String registerUser(Map<String, Object> params) {
		String username;
		String cname;
		String ename;
		String password;
		String email;
		String mobile;
		String companyId;
		boolean maleboolean;
		try {
			System.out.println(params);
			username 	= (String)params.get("username");
			cname 		= (String)params.get("cname");
			ename 		= (String)params.get("ename"); 
			password 	= (String)params.get("password");
			email 		= (String)params.get("email"); 		
			mobile 		= (String)params.get("mobile");
			companyId 	= "nimak";
			String male = (String)params.get("male");
			maleboolean = ((male == "1")? true:false);
			return bdf2UserDaoImp.registerUser(username,cname,ename,password,email,mobile,companyId,true,false,maleboolean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
