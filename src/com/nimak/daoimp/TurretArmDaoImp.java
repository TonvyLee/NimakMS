package com.nimak.daoimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.nimak.daointerface.TurretArmDaoI;
import com.nimak.entity.Turretarm;

@Repository
public class TurretArmDaoImp extends HibernateDao implements TurretArmDaoI{

	@Override
	public List<Turretarm> getTurretArmByDrawingNo(String sArmComponentno) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sqlString = "from " + Turretarm.class.getName() + " t";
		if (sArmComponentno != null && !"".equals(sArmComponentno)) {
			map.put("sArmComponentno", sArmComponentno);
			sqlString+=" where t.armDrawingno=:sArmComponentno";
		}
		List<Turretarm> list = this.query(sqlString, map);
		return list;
	}

}
