package com.nimak.daoimp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.lucene.util.StringHelper;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.nimak.daointerface.TurretComponentDaoI;
import com.nimak.entity.Turret;
import com.nimak.entity.Turretpart;
import com.nimak.exception.DaoException;
import com.nimak.exception.FileException;
import com.nimak.utils.NimakConstantSet;
import com.nimak.utils.NimakFileUtils;

@Repository
public class TurretComponentDaoImp extends HibernateDao implements TurretComponentDaoI{

	public void saveAll(Collection<Turretpart> allTurretComponents) {
		Session session = this.getSessionFactory().openSession();
		try {
			for (Turretpart turret : allTurretComponents) {
				EntityState state = EntityUtils.getState(turret);
				if (EntityState.NEW.equals(state)) {
					turret.setId(UUID.randomUUID().toString());
					session.save(turret);
				}
				if (EntityState.MODIFIED.equals(state)) {
					session.update(turret);
				}
				if (EntityState.DELETED.equals(state)) {
					session.delete(turret);
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
	public String deleteRelatedFilesByID(String iD) throws FileException{
		Map<String, Object> map = new HashMap<String, Object>();
		String sqlString = "from " + Turretpart.class.getName() + " t";
		if (iD != null && !"".equals(iD)) {
			map.put("id", iD);
			sqlString+=" where t.id=:id";
		}
		List<Turretpart> list = this.query(sqlString, map);
		Turretpart turretpart = list.get(0);
		List<String> pathStrings = new ArrayList<>();
		pathStrings.add(turretpart.getArmAssemblyno());
		
		// 如果将焊钳相关的其他文件也删除的话，解注
		/*pathStrings.add(turret.getArmAssemblynoF());
		pathStrings.add(turret.getArmAssemblynoM());
		pathStrings.add(turret.getCapDrawingnoF());
		pathStrings.add(turret.getCapDrawingnoM());
		pathStrings.add(turret.getGunbodyDrawingno());*/
		String TURRETCOMPONENT3D_PATH = NimakConstantSet.TURRETCOMPONENT3D_PATH;
		String TURRETCOMPONENT2D_PATH = NimakConstantSet.TURRETCOMPONENT2D_PATH;
		System.out.println(TURRETCOMPONENT3D_PATH);
		NimakFileUtils nfu = new NimakFileUtils();
		for (String string : pathStrings) {
			// 删除文件
			System.out.println("即将删除文件：" + TURRETCOMPONENT3D_PATH + string + NimakConstantSet.WIDGET_EXT);
			nfu.DeleteFileByPath(TURRETCOMPONENT3D_PATH + string + NimakConstantSet.WIDGET_EXT);
			System.out.println("即将删除文件：" + TURRETCOMPONENT2D_PATH + string + NimakConstantSet.WIDGET_2D_EXT);
			nfu.DeleteFileByPath(TURRETCOMPONENT2D_PATH + string + NimakConstantSet.WIDGET_2D_EXT);	
		}
		return "Successfully deleted";
	}


	@Override
	public Map<String, String> getPartNos(String componentDrawingno) {
		if (org.hibernate.util.StringHelper.isEmpty(componentDrawingno)) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		String sqlString = "from " + Turretpart.class.getName() + " t";
		if (componentDrawingno != null && !"".equals(componentDrawingno)) {
			map.put("armAssemblyno", componentDrawingno);
			sqlString+=" where t.armAssemblyno=:armAssemblyno";
		}
		List<Turretpart> list = this.query(sqlString, map);
		Turretpart turretpart = list.get(0);
		if (null == turretpart) {
			return null;
		}
		String armComponentno = turretpart.getArmComponentno();
		String shankComponentno = turretpart.getShankComponentno();
		map.clear();
		Map<String, String> returnMap = new HashMap<>();
		returnMap.put("armComponentno", armComponentno);
		returnMap.put("shankComponentno", shankComponentno);
		return returnMap;
	}
	
	
	

}
