package com.nimak.serviceimp;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
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
import com.nimak.exception.FileException;
import com.nimak.serviceinterface.TurretArmServiceI;
import com.nimak.utils.NimakConstantSet;

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
	@Transactional
	public List<String> getAllTurretArmDrawingnos() {
		List<String> compDrawingStrings = new ArrayList<>();

		String hql = "select armDrawingno from " + Turretarm.class.getName();
		
		Query query = turretArmDaoImp.getSession().createQuery(hql);
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
			String armSpecialshapeandrib = (String) params.get("armSpecialshapeandrib");

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
			
			String armRadius1 = (String) params.get("armRadius1");
			String armLengthS1 = (String) params.get("armLengthS1");
			String armRadius2 = (String) params.get("armRadius2");
			String armLengthS2 = (String) params.get("armLengthS2");
			String armRadius3 = (String) params.get("armRadius3");
			String armLengthS3 = (String) params.get("armLengthS3");
			String armLengthS4 = (String) params.get("armLengthS4");
			String assembleSize = (String) params.get("assembleSize");
			String assembleLength = (String) params.get("assembleLength");
			String shankDiameter = (String) params.get("shankDiameter");
			String linearGuide = (String) params.get("linearGuide");
			String shankHoledepth = (String) params.get("shankHoledepth");
			String armUsestate = (String) params.get("armUsestate");
			String armDesigner = (String) params.get("armDesigner");
			String armMaker = (String) params.get("armMaker");
			String armDesigndate = (String) params.get("armDesigndate");
			String armTechchange = (String) params.get("armTechchange");
			String attachedPage = (String) params.get("attachedPage");
			String armCustomer = (String) params.get("armCustomer");
			String armRemark = (String) params.get("armRemark");
			String armCode = (String) params.get("armCode");
			
			
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
				whereCase += " AND armStandard like '%" + armStandard + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armRadius1)) {
				whereCase += " AND armRadius1 like '%" + armRadius1 + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armLengthS1)) {
				whereCase += " AND armLengthS1 like '%" + armLengthS1 + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armRadius2)) {
				whereCase += " AND armRadius2 like '%" + armRadius2 + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armLengthS2)) {
				whereCase += " AND armLengthS2 like '%" + armLengthS2 + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armRadius3)) {
				whereCase += " AND armRadius3 like '%" + armRadius3 + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armLengthS3)) {
				whereCase += " AND armLengthS3 like '%" + armLengthS3 + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armLengthS4)) {
				whereCase += " AND armLengthS4 like '%" + armLengthS4 + "%' ";
			}
			
			if (StringHelper.isNotEmpty(assembleSize)) {
				whereCase += " AND assembleSize like '%" + assembleSize + "%' ";
			}
			
			if (StringHelper.isNotEmpty(assembleLength)) {
				whereCase += " AND assembleLength like '%" + assembleLength + "%' ";
			}
			
			if (StringHelper.isNotEmpty(shankDiameter)) {
				whereCase += " AND shankDiameter like '%" + shankDiameter + "%' ";
			}
			
			if (StringHelper.isNotEmpty(linearGuide)) {
				whereCase += " AND linearGuide like '%" + linearGuide + "%' ";
			}
			
			if (StringHelper.isNotEmpty(shankHoledepth)) {
				whereCase += " AND shankHoledepth like '%" + shankHoledepth + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armUsestate)) {
				whereCase += " AND armUsestate like '%" + armUsestate + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armDesigner)) {
				whereCase += " AND armDesigner like '%" + armDesigner + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armMaker)) {
				whereCase += " AND armMaker like '%" + armMaker + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armDesigndate)) {
				whereCase += " AND armDesigndate like '%" + armDesigndate + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armTechchange)) {
				whereCase += " AND armTechchange like '%" + armTechchange + "%' ";
			}
			
			if (StringHelper.isNotEmpty(attachedPage)) {
				whereCase += " AND attachedPage like '%" + attachedPage + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armCustomer)) {
				whereCase += " AND armCustomer like '%" + armCustomer + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armRemark)) {
				whereCase += " AND armRemark like '%" + armRemark + "%' ";
			}
			
			if (StringHelper.isNotEmpty(armCode)) {
				whereCase += " AND armCode like '%" + armCode + "%' ";
			}
		
			turretArmDaoImp.find(page, " from Turretarm where 1=1 " + whereCase);
		} else
			page.setEntities(turretArmDaoImp.getSession().createQuery(" from Turretarm where 1=1 " + whereCase).list());
	}

	
/**
 * 验证输入图号是否已经存在
 * @param params
 * @return
 */
	@Expose
	@Transactional
	public String doVarifyDrawingno(String params){
		Page<Turretarm> page = new Page<>(15, 1);
		List<String> turrets = new ArrayList<>();
		String result="";
		if (null != params) {
			String armDrawingno = (String) params;
			
			String hql = "select armDrawingno from Turretarm";
			Query query = turretArmDaoImp.getSession().createQuery(hql);
			turrets=query.list();
			
			if (StringHelper.isNotEmpty(armDrawingno)){
				for (String temp : turrets) {
					if (temp.equals(armDrawingno)) {
						result="已存在";
						break;
					}else{
						result="不存在";
					}
				}
			}else{
				result="参数为空";
			}
		
		}
		
		return result;
	}
	

	@SuppressWarnings("unchecked")
	@DataResolver
	@Transactional
	public void saveAll(Collection<Turretarm> turretarms) {
		logger.info(turretarms.size());
		logger.info(turretarms);
		turretArmDaoImp.persistEntities(turretarms);
		//turretArmDaoImp.saveAll(turretarms);
		
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

	@Override
	@Expose
	public Map<String, String> isNewAddedTurretArmSatisfied(
			Map<String, Object> params) {
		logger.info("Start verify new added TurretArm object conditions");
		System.out.println(params);
		Map<String, String> returnMap = new HashMap<>();
		if (params != null) {
			String armDrawingno = (String) params.get("armDrawingno");
			// String stroke = (String.valueOf(params.get("stroke")));
			if (armDrawingno == null || (armDrawingno != null)
					&& armDrawingno.equals("")) {
				returnMap.put("flag", "请填写钳臂零件图号！");
				return returnMap;
			}


			// 判断文件是否上传成功,注意文件类型
			if (!new File(NimakConstantSet.TURRETARM3D_PATH + armDrawingno
					+ ".CATPart").exists()) {
				returnMap.put("flag", "三维数模文件未上传成功！");
				return returnMap;
			}
			// 判断2d文件是否上传成功,注意文件类型
			if (!new File(NimakConstantSet.TURRETARM2D_PATH + armDrawingno
					+ ".jpg").exists()) {
				returnMap.put("flag", "二维图纸文件未上传成功！");
				return returnMap;
			}
			// 如果上述条件都满足，map返回flag = S_OK键值
			returnMap.put("flag", "S_OK");
			return returnMap;
		} else {
			returnMap.put("flag", "请输入握杆零件相关参数！");			
			return returnMap;
		}
	}
	
	
	
	@Override
	@Expose
	public String deleteRelatedFilesByArmDrawingno(String armDrawingno) {
		logger.info("即将根据前台传入的电极握杆的id删除相关的文件======,id:" + armDrawingno);
		try {
			return turretArmDaoImp.deleteRelatedFilesByArmDrawingno(armDrawingno);
		} catch (FileException e) {
			System.out.println(e.getFileErrorMsg());
			e.printStackTrace();
			return e.getFileErrorMsg();
		}
	}
	
}
