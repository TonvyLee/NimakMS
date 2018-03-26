package com.nimak.daoimp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
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
import com.nimak.exception.FileException;
import com.nimak.utils.NimakConstantSet;
import com.nimak.utils.NimakFileUtils;

@SuppressWarnings("rawtypes")
@Repository
@Transactional
public class TurretArmDaoImp extends HibernateDao implements TurretArmDaoI{
	
	private Logger logger = Logger.getLogger(TurretArmDaoImp.class);
	
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


	@SuppressWarnings("unchecked")
	@Override
	public String deleteRelatedFilesByArmDrawingno(String armDrawingno)
			throws FileException {
		logger.info("根据钳臂零件的图号删除相关的文件======,图号:" + armDrawingno);
		Map<String, Object> map = new HashMap<String, Object>();
		String sqlString = "from " + Turretarm.class.getName() + " t";
		if (armDrawingno != null && !"".equals(armDrawingno)) {
			map.put("armDrawingno", armDrawingno);
			sqlString+=" where t.armDrawingno=:armDrawingno";
		}
		List<Turretarm> list = this.find(sqlString, map);
		Turretarm turretArm = list.get(0);
		List<String> pathStrings = new ArrayList<>();
		pathStrings.add(turretArm.getArmDrawingno());
		
		// 如果将钳臂零件相关的其他文件也删除的话，解注
		/*pathStrings.add(turret.getArmAssemblynoF());
		pathStrings.add(turret.getArmAssemblynoM());
		pathStrings.add(turret.getCapDrawingnoF());
		pathStrings.add(turret.getCapDrawingnoM());
		pathStrings.add(turret.getGunbodyDrawingno());*/
		String TURRETARM3D_PATH = NimakConstantSet.TURRETARM3D_PATH;
		String TURRETARM2D_PATH = NimakConstantSet.TURRETARM2D_PATH;
		NimakFileUtils nfu = new NimakFileUtils();
		for (String string : pathStrings) {
			// 删除文件
			logger.info("即将删除文件：" + TURRETARM3D_PATH + string + NimakConstantSet.COMPONENT_EXT);
			nfu.DeleteFileByPath(TURRETARM3D_PATH + string + NimakConstantSet.COMPONENT_EXT);
			logger.info("即将删除文件：" + TURRETARM2D_PATH + string + NimakConstantSet.COMPONENT_2D_EXT);
			nfu.DeleteFileByPath(TURRETARM2D_PATH + string + NimakConstantSet.COMPONENT_2D_EXT);
		}
		return "Successfully deleted";
	}
	
	

}
