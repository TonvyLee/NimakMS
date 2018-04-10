package com.nimak.serviceimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.orm.jdbc.JdbcDao;
import com.bstek.bdf2.core.service.IUserService;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;
import com.nimak.entity.DemoUser;

public class DemoUserService extends JdbcDao implements IUserService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		String sql = "select username,password,cname from demo_user where username=?";
		List<IUser> users = this.getJdbcTemplate().query(sql,
				new Object[] { username }, new UserMapper());
		if (users.size() == 0) {
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
		String sql = "select username,password,cname from demo_user where username=?";
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
		DemoUser user = new DemoUser();
		user.setUsername(username);
		return user;
	}

	@Override
	public void registerAdministrator(String username, String cname,
			String ename, String password, String emai, String mobile,
			String companyId) {
		// TODO Auto-generated method stub

	}

	class UserMapper implements RowMapper<IUser> {
		public DemoUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			DemoUser user = new DemoUser();
			user.setCname(rs.getString("cname"));
			user.setPassword(rs.getString("password"));
			user.setUsername(rs.getString("username"));
			return user;
		}
	}
}
