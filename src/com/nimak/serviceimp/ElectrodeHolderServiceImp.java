package com.nimak.serviceimp;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.annotations.common.util.StringHelper;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.hibernate.HibernateUtils;
import com.nimak.daoimp.ElectrodeHolderDaoImp;
import com.nimak.entity.Electrodeholder;
import com.nimak.entity.Turret;
import com.nimak.entity.Turretarm;
import com.nimak.entity.Turretpart;
import com.nimak.exception.FileException;
import com.nimak.serviceinterface.ElectrodeHolderServiceI;
import com.nimak.utils.NimakConstantSet;
import com.nimak.utils.NimakStringUtils;

@Component
public class ElectrodeHolderServiceImp implements ElectrodeHolderServiceI {

	@Resource
	public ElectrodeHolderDaoImp electrodeHolderDaoImp;

	private Logger logger = Logger.getLogger(ElectrodeHolderServiceImp.class);

	@Override
	@DataProvider
	public void getAllShanksInfoByPage(Page<Electrodeholder> page,
			Criteria criteria) throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Electrodeholder.class);
		if (criteria != null) {
			HibernateUtils.createFilter(detachedCriteria, criteria);
		}
		electrodeHolderDaoImp.pagingQuery(page, detachedCriteria);
	}

	@Override
	@DataProvider
	public List<Electrodeholder> getAllShanksInfo() {
		String hql = "from " + Electrodeholder.class.getName() + "";
		return electrodeHolderDaoImp.query(hql);
	}

	@Override
	@DataProvider
	public void queryForCondition(Page<Electrodeholder> page,
			Map<String, Object> params) throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Electrodeholder.class);
		if (params != null) {
			String shankDrawingno = (String) params.get("shankDrawingno");
			String shankMaterial = (String) params.get("shankMaterial");
			String shankTaper = (String) params.get("shankTaper");
			String shankType = (String) params.get("shankType");
			String shankDiameter = (String) params.get("shankDiameter");
			String shankAngel1 = (String) params.get("shankAngel1");
			String shankRadius1 = (String) params.get("shankRadius1");
			String shankLengthS1 = (String) params.get("shankLengthS1");
			String shankAngel2 = (String) params.get("shankAngel2");
			String shankRadius2 = (String) params.get("shankRadius2");
			String shankLengthS2 = (String) params.get("shankLengthS2");
			String shankAngel3 = (String) params.get("shankAngel3");
			String shankRadius3 = (String) params.get("shankRadius3");
			String shankLengthS3 = (String) params.get("shankLengthS3");
			String shankStandard = (String) params.get("shankStandard");
			String shankUsestate = (String) params.get("shankUsestate");
			String shankDesigner = (String) params.get("shankDesigner");

			Date shankDesigndate = (Date) params.get("shankDesigndate");

			String armTechchange = (String) params.get("armTechchange");
			String attachedPage = (String) params.get("attachedPage");
			String shankCustomer = (String) params.get("shankCustomer");
			String shankRemark = (String) params.get("shankRemark");
			String shankCode = (String) params.get("shankCode");

			// 日期做特殊处理
			/*
			 * System.out.println(params.get("designdate")); String designdate =
			 * ""; if(params.get("designdate") != null) { Date date = (Date)
			 * params.get("designdate"); SimpleDateFormat sdf = new
			 * SimpleDateFormat("yyyy-MM-dd"); designdate =
			 * sdf.format(date).toString(); }
			 */
			/*
			 * Date date = (Date) params.get("designdate"); SimpleDateFormat sdf
			 * = new SimpleDateFormat("yyyy-MM-dd"); Date designdate =
			 * sdf.parse(sdf.format(date)); System.out.println(designdate);
			 */

			// System.out.println(designdate);
			if (StringHelper.isNotEmpty(shankDrawingno)) {
				dc.add(Restrictions.like("shankDrawingno", NimakStringUtils
						.AddCharToBothSides(shankDrawingno, "%")));
			}
			if (StringHelper.isNotEmpty(shankMaterial)) {
				dc.add(Restrictions.like("shankMaterial",
						NimakStringUtils.AddCharToBothSides(shankMaterial, "%")));
			}
			if (StringHelper.isNotEmpty(shankTaper)) {
				dc.add(Restrictions.like("shankTaper",
						NimakStringUtils.AddCharToBothSides(shankTaper, "%")));
			}
			if (StringHelper.isNotEmpty(shankType)) {
				dc.add(Restrictions.like("shankType",
						NimakStringUtils.AddCharToBothSides(shankType, "%")));
			}

			if (StringHelper.isNotEmpty(shankDiameter)) {
				dc.add(Restrictions.like("shankDiameter", new BigDecimal(
						shankDiameter)));
			}

			if (StringHelper.isNotEmpty(shankAngel1)) {
				dc.add(Restrictions.like("shankAngel1",
						NimakStringUtils.AddCharToBothSides(shankAngel1, "%")));
			}
			if (StringHelper.isNotEmpty(shankRadius1)) {
				dc.add(Restrictions.like("shankRadius1", new BigDecimal(
						shankRadius1)));
			}
			if (StringHelper.isNotEmpty(shankLengthS1)) {
				dc.add(Restrictions.like("shankLengthS1", new BigDecimal(
						shankLengthS1)));
			}
			if (StringHelper.isNotEmpty(shankAngel2)) {
				dc.add(Restrictions.like("shankAngel2",
						NimakStringUtils.AddCharToBothSides(shankAngel2, "%")));
			}
			if (StringHelper.isNotEmpty(shankRadius2)) {
				dc.add(Restrictions.like("shankRadius2", new BigDecimal(
						shankRadius2)));
			}
			if (StringHelper.isNotEmpty(shankLengthS2)) {
				dc.add(Restrictions.like("shankLengthS2", new BigDecimal(
						shankLengthS2)));
			}
			if (StringHelper.isNotEmpty(shankAngel3)) {
				dc.add(Restrictions.like("shankAngel3",
						NimakStringUtils.AddCharToBothSides(shankAngel3, "%")));
			}
			if (StringHelper.isNotEmpty(shankRadius3)) {
				dc.add(Restrictions.like("shankRadius3", new BigDecimal(
						shankRadius3)));
			}
			if (StringHelper.isNotEmpty(shankLengthS3)) {
				dc.add(Restrictions.like("shankLengthS3", new BigDecimal(
						shankLengthS3)));
			}
			if (StringHelper.isNotEmpty(shankStandard)) {
				dc.add(Restrictions.like("shankStandard", new BigDecimal(
						shankStandard)));
			}

			if (StringHelper.isNotEmpty(shankStandard)) {
				dc.add(Restrictions.like("shankStandard",
						NimakStringUtils.AddCharToBothSides(shankStandard, "%")));
			}
			if (StringHelper.isNotEmpty(shankDesigner)) {
				dc.add(Restrictions.like("shankDesigner",
						NimakStringUtils.AddCharToBothSides(shankDesigner, "%")));
			}
			if (StringHelper.isNotEmpty(shankCode)) {
				dc.add(Restrictions.like("shankCode",
						NimakStringUtils.AddCharToBothSides(shankCode, "%")));
			}

			/*
			 * if (StringHelper.isNotEmpty(shankDesigndate)) { Date designdate =
			 * null; SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 * designdate = sdf.parse(shankDesigndate);
			 * System.out.println(designdate);
			 * dc.add(Restrictions.like("shankDesigndate",designdate)); }
			 */
			if (null != shankDesigndate) {
				dc.add(Restrictions.like("shankDesigndate", shankDesigndate));
			}

			/*
			 * if (shankDesigndate != null) { whereCase +=
			 * " AND to_char(designdate,'yyyy-mm-dd') like '%" + shankDesigndate
			 * + "%' "; }
			 */

			electrodeHolderDaoImp.pagingQuery(page, dc);
		} else {
			electrodeHolderDaoImp.pagingQuery(page, dc);
		}
	}

	@Override
	@DataResolver
	@Transactional
	public void saveAll(Collection<Electrodeholder> allShanks) {
		electrodeHolderDaoImp.saveAll(allShanks);
	}

	@Override
	@Expose
	public Map<String, String> isNewAddedShankSatisfied(
			Map<String, Object> params) {
		logger.info("Start verify electrodeHolder conditions");
		System.out.println(params);
		Map<String, String> returnMap = new HashMap<>();
		if (params != null) {
			String shankDrawingno = (String) params.get("shankDrawingno");
			// String shankCode = (String) params.get("shankCode");
			// String stroke = (String.valueOf(params.get("stroke")));
			String shankAngel1 = (String) params.get("shankAngel1");
			String shankAngel2 = (String) params.get("shankAngel2");
			String shankAngel3 = (String) params.get("shankAngel3");
			if (shankDrawingno == null || (shankDrawingno != null)
					&& shankDrawingno.equals("")) {
				returnMap.put("flag", "请填写握杆组件零件图号！");
				return returnMap;
			}

			if (!"无".equals(shankAngel1)
					&& !"0".equals(shankAngel1)
					&& (StringHelper.isNotEmpty(shankAngel1) && !shankAngel1
							.contains("获得"))) {
				returnMap.put("flag", "握杆偏移角度1输入格式有误！[0,无,输入角度后选择偏移生成方式]");
				return returnMap;
			}
			if (!"无".equals(shankAngel2)
					&& !"0".equals(shankAngel2)
					&& (StringHelper.isNotEmpty(shankAngel2) && !shankAngel2
							.contains("获得"))) {
				returnMap.put("flag", "握杆偏移角度1输入格式有误！[0,无,输入角度后选择偏移生成方式]");
				return returnMap;
			}
			if (!"无".equals(shankAngel3)
					&& !"0".equals(shankAngel3)
					&& (StringHelper.isNotEmpty(shankAngel3) && !shankAngel3
							.contains("获得"))) {
				returnMap.put("flag", "握杆偏移角度1输入格式有误！[0,无,输入角度后选择偏移生成方式]");
				return returnMap;
			}

			// 判断文件是否上传成功,注意文件类型
			if (!new File(NimakConstantSet.TURRETSHANK3D_PATH + shankDrawingno
					+ ".CATPart").exists()) {
				returnMap.put("flag", "三维数模文件未上传成功！");
				return returnMap;
			}
			// 判断2d文件是否上传成功,注意文件类型
			if (!new File(NimakConstantSet.TURRETSHANK2D_PATH + shankDrawingno
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
	public String deleteRelatedFilesByID(String ID) {
		logger.info("即将根据前台传入的电极握杆的id删除相关的文件======,id:" + ID);
		try {
			return electrodeHolderDaoImp.deleteRelatedFilesByID(ID);
		} catch (FileException e) {
			System.out.println(e.getFileErrorMsg());
			e.printStackTrace();
			return e.getFileErrorMsg();
		}
	}

	@DataProvider
	public List<Electrodeholder> getHolderByShankNo(String sShankDrawingno) {
		return electrodeHolderDaoImp.getHolderByShankNo(sShankDrawingno);
	}

	@Override
	@Expose
	public Map<String, String> codeShankByParameter(Map<String, Object> params) {
		Map<String, String> returnMap = new HashMap<>();
		// 下面方法可以获取到部件整体信息的编码。总的编码结果是部件整体信息编码结果+组成部件的零件+握杆零件的编码
		Map<String, String> map = new CodeService()
				.codeTurretShankByParameter(params);
		// 编码成功
		if ("S_OK".equals(map.get("codeflag"))) {
			String coderesult = map.get("coderesult");
			returnMap.put("flag", "S_OK");
			returnMap.put("coderesult", coderesult);
			return returnMap;
		} else {
			returnMap.put("flag", "E_Fail");
			return returnMap;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@DataProvider
	public Collection<Electrodeholder> getShankByDrawingno(
			String shankDrawingno) {
		String hql = "from " + Electrodeholder.class.getName()
				+ " where shankDrawingno like :shankDrawingno";
		Map param = new HashMap();
		if (StringHelper.isNotEmpty(shankDrawingno)) {
			param.put("shankDrawingno", "%" + shankDrawingno + "%");
			return electrodeHolderDaoImp.query(hql, param);
		} else {
			return getAllShanksInfo();
		}
	}
	
	@Override
	@Expose
	public List<String> getAllTurretShankDrawingnos() {
		List<String> compDrawingStrings = new ArrayList<>();
		
		String hql = "select shankDrawingno from " + Electrodeholder.class.getName();
		compDrawingStrings = electrodeHolderDaoImp.query(hql);
		/*for (String string : compDrawingStrings) {
			System.out.println(string);
		}*/
		
		logger.info("Get所有的电极握杆图号" + compDrawingStrings);
		return compDrawingStrings;
	}

	
}
