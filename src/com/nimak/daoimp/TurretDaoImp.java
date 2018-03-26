package com.nimak.daoimp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.nimak.daointerface.TurretDaoI;
import com.nimak.entity.Turret;
import com.nimak.exception.DaoException;
import com.nimak.exception.FileException;
import com.nimak.utils.NimakConstantSet;
import com.nimak.utils.NimakFileUtils;

@Repository
public class TurretDaoImp extends HibernateDao implements TurretDaoI {

	public void saveAll(Collection<Turret> allTurrets) {
		Session session = this.getSessionFactory().openSession();
		try {
			for (Turret turret : allTurrets) {
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
		String sqlString = "from " + Turret.class.getName() + " t";
		if (iD != null && !"".equals(iD)) {
			map.put("id", iD);
			sqlString+=" where t.id=:id";
		}
		List<Turret> list = this.query(sqlString, map);
		Turret turret = list.get(0);
		List<String> pathStrings = new ArrayList<>();
		pathStrings.add(turret.getGunDrawingno());
		
		// 如果将焊钳相关的其他文件也删除的话，解注
		/*pathStrings.add(turret.getArmAssemblynoF());
		pathStrings.add(turret.getArmAssemblynoM());
		pathStrings.add(turret.getCapDrawingnoF());
		pathStrings.add(turret.getCapDrawingnoM());
		pathStrings.add(turret.getGunbodyDrawingno());*/
		String TURRET3D_PATH = NimakConstantSet.TURRET3D_PATH;
		String TURRET2D_PATH = NimakConstantSet.TURRET2D_PATH;
		System.out.println(TURRET3D_PATH);
		NimakFileUtils nfu = new NimakFileUtils();
		for (String string : pathStrings) {
			// 删除文件
			System.out.println("即将删除文件：" + TURRET3D_PATH + string + NimakConstantSet.PRODUCT_EXT);
			nfu.DeleteFileByPath(TURRET3D_PATH + string + NimakConstantSet.PRODUCT_EXT);
			System.out.println("即将删除文件：" + TURRET2D_PATH + string + NimakConstantSet.PRODUCT_2D_EXT);
			nfu.DeleteFileByPath(TURRET2D_PATH + string + NimakConstantSet.PRODUCT_2D_EXT);	
		}
		return "Successfully deleted";
	}

}
