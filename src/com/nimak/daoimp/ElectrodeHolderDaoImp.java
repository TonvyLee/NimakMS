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

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.nimak.daointerface.ElectrodeHolderDaoI;
import com.nimak.entity.Electrodeholder;
import com.nimak.entity.Turret;
import com.nimak.entity.Turretpart;
import com.nimak.exception.DaoException;
import com.nimak.exception.FileException;
import com.nimak.utils.NimakConstantSet;
import com.nimak.utils.NimakFileUtils;

@Repository
public class ElectrodeHolderDaoImp extends HibernateDao implements ElectrodeHolderDaoI {

	private Logger logger = Logger.getLogger(ElectrodeHolderDaoImp.class);
	
	public void saveAll(Collection<Electrodeholder> allShanks) {
		Session session = this.getSessionFactory().openSession();
		try {
			for (Electrodeholder shank : allShanks) {
				EntityState state = EntityUtils.getState(shank);
				if (EntityState.NEW.equals(state)) {
					shank.setId(UUID.randomUUID().toString());
					session.save(shank);
				}
				if (EntityState.MODIFIED.equals(state)) {
					session.update(shank);
				}
				if (EntityState.DELETED.equals(state)) {
					session.delete(shank);
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
	
	
	@Override
	public List<Electrodeholder> getHolderByShankNo(String sShankDrawingno) {

		Map<String, Object> map = new HashMap<String, Object>();
		String sqlString = "from " + Electrodeholder.class.getName() + " t";
		if (sShankDrawingno != null && !"".equals(sShankDrawingno)) {
			map.put("sShankDrawingno", sShankDrawingno);
			sqlString += " where t.shankDrawingno=:sShankDrawingno";
		}
		List<Electrodeholder> list = this.query(sqlString, map);
		return list;
	}


	@Override
	public String deleteRelatedFilesByID(String id) throws FileException {
		logger.info("根据电极握杆的id删除相关的文件======,id:" + id);
		Map<String, Object> map = new HashMap<String, Object>();
		String sqlString = "from " + Electrodeholder.class.getName() + " t";
		if (id != null && !"".equals(id)) {
			map.put("id", id);
			sqlString+=" where t.id=:id";
		}
		List<Electrodeholder> list = this.query(sqlString, map);
		Electrodeholder shank = list.get(0);
		List<String> pathStrings = new ArrayList<>();
		pathStrings.add(shank.getShankDrawingno());
		
		// 如果将电极握杆相关的其他文件也删除的话，解注
		/*pathStrings.add(turret.getArmAssemblynoF());
		pathStrings.add(turret.getArmAssemblynoM());
		pathStrings.add(turret.getCapDrawingnoF());
		pathStrings.add(turret.getCapDrawingnoM());
		pathStrings.add(turret.getGunbodyDrawingno());*/
		String TURRETSHANKCOM3D_PATH = NimakConstantSet.TURRETSHANKCOM3D_PATH;
		String TURRETSHANKCOM2D_PATH = NimakConstantSet.TURRETSHANKCOM2D_PATH;
		NimakFileUtils nfu = new NimakFileUtils();
		for (String string : pathStrings) {
			// 删除文件
			logger.info("即将删除文件：" + TURRETSHANKCOM3D_PATH + string + ".CATPart");
			nfu.DeleteFileByPath(TURRETSHANKCOM3D_PATH + string + ".CATPart");
			logger.info("即将删除文件：" + TURRETSHANKCOM2D_PATH + string + ".jpg");
			nfu.DeleteFileByPath(TURRETSHANKCOM2D_PATH + string + ".jpg");
		}
		return "Successfully deleted";
	}

}
