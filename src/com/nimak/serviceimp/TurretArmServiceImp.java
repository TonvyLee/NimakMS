package com.nimak.serviceimp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.util.StringHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf2.core.cache.ApplicationCache;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.nimak.daoimp.TurretArmDaoImp;
import com.nimak.entity.Turretarm;
import com.nimak.serviceinterface.TurretArmServiceI;

@Component
public class TurretArmServiceImp implements TurretArmServiceI {

	ApplicationCache applicationCache = ContextHolder
			.getBean(ApplicationCache.BEAN_ID);

	private Logger logger = Logger.getLogger(TurretArmServiceImp.class);

	public TurretArmServiceImp() {

	}

	@Resource
	public TurretArmDaoImp turretArmDaoImp;

	@Override
	@DataProvider
	public List<Turretarm> getTurretArmByDrawingNo(String sArmComponentno) {
		return turretArmDaoImp.getTurretArmByDrawingNo(sArmComponentno);
	}

	@Override
	@Expose
	public List<String> getAllTurretArmDrawingnos() {
		List<String> compDrawingStrings = new ArrayList<>();

		String hql = "select armDrawingno from " + Turretarm.class.getName();
		
		Query query = turretArmDaoImp.createQuery(hql);
		compDrawingStrings = query.list(); 
		/*
		 * for (String string : compDrawingStrings) {
		 * System.out.println(string); }
		 */

		logger.info("Get所有的钳臂零件图号：" + compDrawingStrings);
		return compDrawingStrings;
	}



	@DataProvider
	@Transactional
	public void queryForCondition(Page<Turretarm> page,
			Map<String, Object> params) throws Exception {
		String whereCase = "";
		if (null != params) {
			String armDrawingno = (String) params.get("armDrawingno");
			String armType = (String) params.get("armType");
			String armSerial = (String) params.get("armSerial");
			String armMaterial = (String) params.get("armMaterial");
			String armSpecialshapeandrib = (String) params
					.get("armSpecialshapeandrib");

			/*
			 * 这里可以如果将String转化为int，数据查询的时候auroform不能留白，即不能输入null，较为麻烦，因此不转化为int
			 */
			String armLength1 = (String) params.get("armLength1");
			String armLength2 = (String) params.get("armLength2");

			String armWidth1 = (String) params.get("armWidth1");
			String armWidth1to = (String) params.get("armWidth1to");

			String armWidth2 = (String) params.get("armWidth2");
			String armWidth2to = (String) params.get("armWidth2to");

			String armAngel1 = (String) params.get("armAngel1");
			String armAngel1to = (String) params.get("armAngel1to");

			String armAngel2 = (String) params.get("armAngel2");
			String armAngel2to = (String) params.get("armAngel2to");

			String armAngel3 = (String) params.get("armAngel3");
			String armAngel3to = (String) params.get("armAngel3to");

			String armAngel4 = (String) params.get("armAngel4");
			String armAngel4to = (String) params.get("armAngel4to");

			String shankType = (String) params.get("shankType");
			String armStandard = (String) params.get("armStandard");

			/*
			 * 按名称查找--------------------------------------------------------------
			 * -
			 */
			if (StringHelper.isNotEmpty(armDrawingno)) {
				whereCase += " AND armDrawingno like '%" + armDrawingno + "%' ";
			}
			if (StringHelper.isNotEmpty(armType)) {
				whereCase += " AND armType like '%" + armType + "%' ";
			}
			if (StringHelper.isNotEmpty(armMaterial)) {
				whereCase += " AND armMaterial like '%" + armMaterial + "%' ";
			}
			if (StringHelper.isNotEmpty(armSerial)) {
				whereCase += " AND armSerial like '%" + armSerial + "%' ";
			}
			if (StringHelper.isNotEmpty(armSpecialshapeandrib)) {
				whereCase += " AND armSpecialshapeandrib like '%"
						+ armSpecialshapeandrib + "%' ";
			}

			/*
			 * 按数字范围查找------------------------------------------------------------
			 * ---
			 */
			if (StringHelper.isNotEmpty(armLength1)) {
				whereCase += " AND armLength >=" + armLength1;
			}
			if (StringHelper.isNotEmpty(armLength2)) {
				whereCase += " AND armLength <=" + armLength2;
			}

			if (StringHelper.isNotEmpty(armWidth1)) {
				whereCase += " AND armWidth1 >=" + armWidth1;
			}
			if (StringHelper.isNotEmpty(armWidth1to)) {
				whereCase += " AND armWidth1 <=" + armWidth1to;
			}

			if (StringHelper.isNotEmpty(armWidth2)) {
				whereCase += " AND armWidth2 >=" + armWidth2;
			}
			if (StringHelper.isNotEmpty(armWidth2to)) {
				whereCase += " AND armWidth2 <=" + armWidth2to;
			}

			if (StringHelper.isNotEmpty(armAngel1)) {
				whereCase += " AND armAngel1 >=" + armAngel1;
			}
			if (StringHelper.isNotEmpty(armAngel1to)) {
				whereCase += " AND armAngel1 <=" + armAngel1to;
			}

			if (StringHelper.isNotEmpty(armAngel2)) {
				whereCase += " AND armAngel2 >=" + armAngel2;
			}
			if (StringHelper.isNotEmpty(armAngel2to)) {
				whereCase += " AND armAngel2 <=" + armAngel2to;
			}

			if (StringHelper.isNotEmpty(armAngel3)) {
				whereCase += " AND armAngel3 >=" + armAngel3;
			}
			if (StringHelper.isNotEmpty(armAngel3to)) {
				whereCase += " AND armAngel3 <=" + armAngel3to;
			}

			if (StringHelper.isNotEmpty(armAngel4)) {
				whereCase += " AND armAngel4 >=" + armAngel4;
			}
			if (StringHelper.isNotEmpty(armAngel4to)) {
				whereCase += " AND armAngel4 <=" + armAngel4to;
			}

			if (StringHelper.isNotEmpty(shankType)) {
				whereCase += " AND shankType like '%" + shankType + "%' ";
			}

			if (StringHelper.isNotEmpty(armStandard)) {
				whereCase += " AND armStandard =" + armStandard;
			}

			turretArmDaoImp.find(page, " from Turretarm where 1=1 " + whereCase);
		} else
			page.setEntities(turretArmDaoImp.getSession().createQuery(" from Turretarm where 1=1 " + whereCase).list());
	}

	@DataResolver
	@Transactional
	public void saveAll(Collection<Turretarm> turretarms) {
		turretArmDaoImp.persistEntities(turretarms);
	}

	/*--------------------------------------------------------------------------------------------------------------------*/
	@DataProvider
	public void queryForCondition1(Page<Turretarm> page,
			Map<String, Object> params) throws Exception {
		String whereCase = "";
		if (null != params) {
			String armSerial = "1-";
			String armType = (String) params.get("armType");

			if (StringHelper.isNotEmpty(armSerial)) {
				whereCase += " AND armSerial like '%" + armSerial + "%' ";
			}
			if (StringHelper.isNotEmpty(armType)) {
				whereCase += " AND armType like '%" + armType + "%' ";
			}
			turretArmDaoImp.find(page, " from Turretarm where 1=1 " + whereCase);
		} else
			page.setEntities(turretArmDaoImp.getSession().createQuery(" from Turretarm where 1=1 " + whereCase).list());	}

	@DataProvider
	public void queryForCondition2(Page<Turretarm> page,
			Map<String, Object> params) throws Exception {
		String whereCase = "";
		if (null != params) {
			String armSerial = "2-";
			String armType = (String) params.get("armType");

			if (StringHelper.isNotEmpty(armSerial)) {
				whereCase += " AND armSerial like '%" + armSerial + "%' ";
			}
			if (StringHelper.isNotEmpty(armType)) {
				whereCase += " AND armType like '%" + armType + "%' ";
			}
			turretArmDaoImp.find(page, " from Turretarm where 1=1 " + whereCase);
		} else
			page.setEntities(turretArmDaoImp.getSession().createQuery(" from Turretarm where 1=1 " + whereCase).list());
	}

	@DataProvider
	public void queryForCondition3(Page<Turretarm> page,
			Map<String, Object> params) throws Exception {
		String whereCase = "";
		if (null != params) {
			String armSerial = "3-";
			String armType = (String) params.get("armType");

			if (StringHelper.isNotEmpty(armSerial)) {
				whereCase += " AND armSerial like '%" + armSerial + "%' ";
			}
			if (StringHelper.isNotEmpty(armType)) {
				whereCase += " AND armType like '%" + armType + "%' ";
			}
			turretArmDaoImp.find(page, " from Turretarm where 1=1 " + whereCase);
		} else
			page.setEntities(turretArmDaoImp.getSession().createQuery(" from Turretarm where 1=1 " + whereCase).list());
	}

	@DataProvider
	public void queryForCondition4(Page<Turretarm> page,
			Map<String, Object> params) throws Exception {
		String whereCase = "";
		if (null != params) {
			String armSerial = "4-";
			String armType = (String) params.get("armType");

			if (StringHelper.isNotEmpty(armSerial)) {
				whereCase += " AND armSerial like '%" + armSerial + "%' ";
			}
			if (StringHelper.isNotEmpty(armType)) {
				whereCase += " AND armType like '%" + armType + "%' ";
			}
			turretArmDaoImp.find(page, " from Turretarm where 1=1 " + whereCase);
		} else
			turretArmDaoImp.getAll(page);
	}

	@DataProvider
	public void queryForCondition5(Page<Turretarm> page,
			Map<String, Object> params) throws Exception {
		String whereCase = "";
		if (null != params) {
			String armSerial = "5-";
			String armType = (String) params.get("armType");

			if (StringHelper.isNotEmpty(armSerial)) {
				whereCase += " AND armSerial like '%" + armSerial + "%' ";
			}
			if (StringHelper.isNotEmpty(armType)) {
				whereCase += " AND armType like '%" + armType + "%' ";
			}
			turretArmDaoImp.find(page, " from Turretarm where 1=1 " + whereCase);
		} else
			page.setEntities(turretArmDaoImp.getSession().createQuery(" from Turretarm where 1=1 " + whereCase).list());
	}

	/*--------------------------------------------------------------------------------------------------------------------*/

}
