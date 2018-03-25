package com.nimak.daoimp;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.hibernate.HibernateDao;
import com.nimak.daointerface.TurretArmDaoI;
import com.nimak.entity.Electrodeholder;
import com.nimak.entity.Turretarm;
import com.nimak.exception.DaoException;

@SuppressWarnings("rawtypes")
@Repository
@Transactional
public class TurretArmDaoImp extends HibernateDao implements TurretArmDaoI{
	
	@Override
	public List<Turretarm> getTurretArmByDrawingNo(String sArmComponentno) {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		String sqlString = "from " + Turretarm.class.getName() + " t";
		if (sArmComponentno != null && !"".equals(sArmComponentno)) {
			map.put("sArmComponentno", sArmComponentno);
			sqlString+=" where t.armDrawingno=:sArmComponentno";
		}
		List<Turretarm> list = this.find(sqlString, map);
		return list;
	}
	
	
	public void saveAll(Collection<Turretarm> allTurretarms) {
		Session session = this.getSessionFactory().openSession();
		try {
			for (Turretarm turretarm : allTurretarms) {
				EntityState state = EntityUtils.getState(turretarm);
				if (EntityState.NEW.equals(state)) {
					session.save(turretarm);
				}
				if (EntityState.MODIFIED.equals(state)) {
					session.update(turretarm);
				}
				if (EntityState.DELETED.equals(state)) {
					session.delete(turretarm);
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
	}
	
	

}
