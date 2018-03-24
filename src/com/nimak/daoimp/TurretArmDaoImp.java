package com.nimak.daoimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.hibernate.HibernateDao;
import com.nimak.daointerface.TurretArmDaoI;
import com.nimak.entity.Turretarm;

@SuppressWarnings("rawtypes")
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
		List<Turretarm> list = this.find(sqlString, map);
		return list;
	}
	
	
	

}
