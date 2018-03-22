package com.nimak.daoimp;

import java.util.Collection;

import org.apache.commons.lang.math.RandomUtils;
import org.h2.util.New;
import org.hibernate.Session;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.CoreJdbcDao;
import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.bdf2.core.security.UserShaPasswordEncoder;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.nimak.daointerface.Bdf2UserDaoI;
import com.nimak.entity.Bdf2User;
import com.nimak.exception.DaoException;

@Repository
public class Bdf2UserDaoImp extends CoreJdbcDao  implements Bdf2UserDaoI{
	
	private PasswordEncoder passwordEncoder;
	

	/*@Override
	public void saveAll(Collection<Bdf2User> allBdf2Users) {

		Session session = this.getSessionFactory().openSession();
		try {
			for (Bdf2User user : allBdf2Users) {
				EntityState state = EntityUtils.getState(user);
				if (EntityState.NEW.equals(state)) {
					session.save(user);
				}
				if (EntityState.MODIFIED.equals(state)) {
					session.update(user);
				}
				if (EntityState.DELETED.equals(state)) {
					session.delete(user);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			DaoException de = new DaoException();
			String messageString = "Wrong";
			de.setMessageString(messageString );
			throw e;
		} finally {
			session.flush();
			session.close();
		}
	
	}*/

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String registerUser(String username, String cname, String ename,
			String password, String email, String mobile, String companyId,
			boolean enabled, boolean administrator, boolean male) {
		String sql = "INSERT INTO BDF2_USER(USERNAME_,CNAME_,ENAME_,PASSWORD_,SALT_,ENABLED_,ADMINISTRATOR_,EMAIL_,MOBILE_,COMPANY_ID_,MALE_) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		int salt = RandomUtils.nextInt(1000);
		password = passwordEncoder.encodePassword(password, salt);
		this.getJdbcTemplate().update(
				sql,
				new Object[] { username, cname, ename, password,
						String.valueOf(salt), enabled, administrator, email, mobile,
						companyId, male });
		return "S_OK";
	}

	@Override
	public void saveAll(Collection<Bdf2User> allBdf2Users) {
	}
	

}
