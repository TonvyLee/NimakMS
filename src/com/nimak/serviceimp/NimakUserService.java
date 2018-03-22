package com.nimak.serviceimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.orm.jdbc.JdbcDao;
import com.bstek.bdf2.core.service.IUserService;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;
import com.nimak.entity.NimakUser;

public class NimakUserService extends JdbcDao implements IUserService{
	private Logger logger = Logger.getLogger(NimakUserService.class);

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("ceshi");
		System.out.println(username);
		String sql = "select username,address,createdate,birthday,administrator,password,cname,email,enabled,ename,male,mobile from nimak_user where username=?";
		//String sql = "select username,password,cname from nimak_user where username=?";
		List<IUser> users = this.getJdbcTemplate().query(sql,
				new Object[] { username }, new UserMapper());
		System.out.println("===========");
		if (users.size() == 0) {
			logger.info("用户不存在：");
			throw new UsernameNotFoundException("User [" + username
					+ "] is not exist!");
		}
		return users.get(0);
	}


	@Override
	public void changePassword(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String checkPassword(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadPageUsers(Page<IUser> page, String companyId,
			Criteria criteria) {
		//String sql = "select username,password,cname from nimak_user where username=?";
		String sql = "select username,address,createdate,birthday,administrator,password,cname,email,enabled,ename,male,mobile from nimak_user";
		Collection<IUser> users = this.getJdbcTemplate().query(sql,
				new UserMapper());
		page.setEntities(users);
	}

	@Override
	public Collection<IUser> loadUsersByDeptId(String deptId) {
		return Collections.EMPTY_LIST;
	}

	@Override
	public IUser newUserInstance(String username) {
		NimakUser user = new NimakUser();
		user.setUsername(username);
		return user;
	}

	@Override
	public void registerAdministrator(String arg0, String arg1, String arg2,
			String arg3, String arg4, String arg5, String arg6) {
		// TODO Auto-generated method stub
		
	}
	
	class UserMapper implements RowMapper<IUser> {
		public NimakUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			NimakUser user = new NimakUser();
			/*user.setCname(rs.getString("cname"));
			user.setPassword(rs.getString("password"));
			user.setUsername(rs.getString("username"));
			user.setAddress(rs.getString("address"));
			user.setAdministrator(rs.getBigDecimal("administrator"));
			user.setBirthday(rs.getDate("birthday"));
			user.setCreateDate(rs.getDate("createDate"));
			user.setEmail(rs.getString("email"));
			user.setEnabled(rs.getBigDecimal("enabled"));
			user.setEname(rs.getString("ename"));
			user.setMale(rs.getBigDecimal("male"));
			user.setMobile(rs.getString("mobile"));*/
			user.setUsername(rs.getString("username"));
			user.setCname(rs.getString("cname"));
			user.setPassword(rs.getString("password"));
			user.setAdministrator(rs.getBigDecimal("administrator"));
			user.setEnabled(rs.getBigDecimal("enabled"));
			user.setMale(rs.getBigDecimal("male"));
			user.setMobile(rs.getString("mobile"));
			user.setEname(rs.getString("ename"));
			user.setBirthday(rs.getDate("birthday"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));
			user.setCreatedate(rs.getDate("createdate"));
			return user;
		}
	}

}
