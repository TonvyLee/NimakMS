package com.nimak.serviceimp;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.ObjectUtils.Null;
import org.hibernate.annotations.common.util.StringHelper;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf2.core.cache.ApplicationCache;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.data.variant.Record;
import com.bstek.dorado.hibernate.HibernateUtils;
import com.nimak.daoimp.TurretDaoImp;
import com.nimak.entity.Turret;
import com.nimak.exception.FileException;
import com.nimak.serviceinterface.TurretServiceI;
import com.nimak.utils.NimakConstantSet;
import com.nimak.utils.NimakStringUtils;

@Component
public class TurretServiceImp implements TurretServiceI {

	ApplicationCache applicationCache = ContextHolder.getBean(ApplicationCache.BEAN_ID);
	@Resource
	public TurretDaoImp turretDao;

	@Override
	@DataProvider
	public void getAllTurretInfoByPage(Page<Turret> page, Criteria criteria)
			throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Turret.class);
		if (criteria != null) {
			HibernateUtils.createFilter(detachedCriteria, criteria);
		}
		turretDao.pagingQuery(page, detachedCriteria);
	}

	@Override
	@DataProvider
	public List<Turret> getAllTurretInfo() {
		String hql = "from " + Turret.class.getName() + "";
		return turretDao.query(hql);
	}

	@Override
	@DataResolver
	@Transactional
	public void saveAll(Collection<Turret> allTurrets) {
		turretDao.saveAll(allTurrets);
	}

	@DataProvider
	public void queryForCondition(Page<Turret> page, Map<String, Object> params)
			throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Turret.class);
		if (params != null) {
			String gunType 				= (String) params.get("gunType");
			String gunDrawingno 		= (String) params.get("gunDrawingno");
			String gunbodyDrawingno 	= (String) params.get("gunbodyDrawingno");
			String armAssemblynoF 		= (String) params.get("armAssemblynoF");
			String armAssemblynoM 		= (String) params.get("armAssemblynoM");
			String capDrawingnoF 		= (String) params.get("capDrawingnoF");
			String capDrawingnoM 		= (String) params.get("capDrawingnoM");
			
			BigDecimal stroke= ((Object) params.get("stroke") == null ? null : 
				new BigDecimal(String.valueOf(params.get("stroke")))); 
			BigDecimal armassemblyLength= ((Object) params.get("armassemblyLength") == null ? null : 
				new BigDecimal(String.valueOf(params.get("armassemblyLength")))); 
			BigDecimal armassemblyWidth= ((Object) params.get("armassemblyWidth") == null ? null : 
				new BigDecimal(String.valueOf(params.get("armassemblyWidth")))); 
			BigDecimal armassemblyWidth2= ((Object) params.get("armassemblyWidth2") == null ? null : 
				new BigDecimal(String.valueOf(params.get("armassemblyWidth2")))); 
			BigDecimal force= ((Object) params.get("force") == null ? null : 
				new BigDecimal(String.valueOf(params.get("force")))); 
			BigDecimal capAngel= ((Object) params.get("capAngel") == null ? null : 
				new BigDecimal(String.valueOf(params.get("capAngel")))); 
			
			String flange 				= (String) params.get("flange");
			String gunTechchange 		= (String) params.get("gunTechchange");

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
			if (StringHelper.isNotEmpty(gunType)) {
				dc.add(Restrictions.like("gunType",
						NimakStringUtils.AddCharToBothSides(gunType, "%")));
			}
			if (StringHelper.isNotEmpty(gunDrawingno)) {
				dc.add(Restrictions.like("gunDrawingno",
						NimakStringUtils.AddCharToBothSides(gunDrawingno, "%")));
			}
			if (StringHelper.isNotEmpty(gunbodyDrawingno)) {
				dc.add(Restrictions.like("gunbodyDrawingno", NimakStringUtils
						.AddCharToBothSides(gunbodyDrawingno, "%")));
			}
			if (StringHelper.isNotEmpty(armAssemblynoF)) {
				dc.add(Restrictions.like("armAssemblynoF", NimakStringUtils
						.AddCharToBothSides(armAssemblynoF, "%")));
			}
			if (StringHelper.isNotEmpty(armAssemblynoM)) {
				dc.add(Restrictions.like("armAssemblynoM", NimakStringUtils
						.AddCharToBothSides(armAssemblynoM, "%")));
			}
			if (StringHelper.isNotEmpty(capDrawingnoF)) {
				dc.add(Restrictions.like("capDrawingnoF",
						NimakStringUtils.AddCharToBothSides(capDrawingnoF, "%")));
			}
			if (StringHelper.isNotEmpty(capDrawingnoM)) {
				dc.add(Restrictions.like("capDrawingnoM",
						NimakStringUtils.AddCharToBothSides(capDrawingnoM, "%")));
			}
			if (null != stroke) {
				dc.add(Restrictions.like("stroke", stroke));
			}
			if (null != armassemblyLength) {
				dc.add(Restrictions.like("armassemblyLength", armassemblyLength));
			}
			if (null != armassemblyWidth) {
				dc.add(Restrictions.like("armassemblyWidth", armassemblyWidth));
			}
			if (null != armassemblyWidth2) {
				dc.add(Restrictions.like("armassemblyWidth2", armassemblyWidth2));
			}
			if (null != force) {
				dc.add(Restrictions.like("force",force));
			}
			if (null != capAngel) {
				dc.add(Restrictions.like("capAngel",capAngel));
			}
			if (StringHelper.isNotEmpty(flange)) {
				dc.add(Restrictions.like("flange",
						NimakStringUtils.AddCharToBothSides(flange, "%")));
			}
			if (StringHelper.isNotEmpty(gunTechchange)) {
				dc.add(Restrictions.like("gunTechchange",
						NimakStringUtils.AddCharToBothSides(gunTechchange, "%")));
			}
			/*
			 * if (designdate != null) { whereCase +=
			 * " AND to_char(designdate,'yyyy-mm-dd') like '%" + designdate +
			 * "%' "; }
			 */
			turretDao.pagingQuery(page, dc);
		} else {
			turretDao.pagingQuery(page, dc);
		}
	}

	@Override
	@Expose
	public String isNewAddedTurretSatisfied(Map<String, Object> params) {
		System.out.println("test");
		System.out.println(params);
		if (params != null) {
			String gunType = (String) params.get("gunType");
			String gunDrawingno = (String) params.get("gunDrawingno");
			String gunbodyDrawingno = (String) params.get("gunbodyDrawingno");
			//Record armAssemblynoF1 = (Record) params.get("armAssemblynoF");
			
			/*// 对于绑定下拉框的数据做特殊处理
			Map<String, Object> compMap1 = (Map<String, Object>)params.get("armAssemblynoF");
			System.out.println(" -----------" +compMap1.get("armAssemblyno"));
			String armAssemblynoF = (String) compMap1.get("armAssemblyno");
			
			Map<String, Object> compMap2 = (Map<String, Object>)params.get("armAssemblynoM");
			System.out.println(" -----------" +compMap2.get("armAssemblyno"));
			String armAssemblynoM = (String) compMap2.get("armAssemblyno");*/

			String armAssemblynoF = (String) params.get("armAssemblynoF");
			String armAssemblynoM = (String) params.get("armAssemblynoM");
			
			String capDrawingnoF = (String) params.get("capDrawingnoF");
			String capDrawingnoM = (String) params.get("capDrawingnoM");
			String stroke = (String.valueOf(params.get("stroke")));
			String armassemblyLength = (String.valueOf(params
					.get("armassemblyLength")));
			String armassemblyWidth = (String.valueOf(params
					.get("armassemblyWidth")));
			String armassemblyWidth2 = (String.valueOf(params
					.get("armassemblyWidth2")));
			String force = (String.valueOf(params.get("force")));
			String capAngel = (String.valueOf(params.get("capAngel")));
			String flange = (String) params.get("flange");

			if (gunType == null || (gunType != null) && gunType.equals("")) {
				return "钳臂类型不能为空！";
			}
			if (gunDrawingno == null || (gunDrawingno != null)
					&& gunDrawingno.equals("")) {
				return "焊钳图号不能为空！";
			}
			if (gunbodyDrawingno == null || (gunbodyDrawingno != null)
					&& gunbodyDrawingno.equals("")) {
				return "钳体图号不能为空！";
			}
			if (!(StringHelper.isNotEmpty(armAssemblynoF))) {
				return "静臂部件图号不能为空！";
			}
			if (!(StringHelper.isNotEmpty(armAssemblynoM))) {
				return "动臂部件图号不能为空！";
			}
			if (!(StringHelper.isNotEmpty(capDrawingnoF))) {
				return "电极帽零件图号不能为空！";
			}
			if (!(StringHelper.isNotEmpty(capDrawingnoM))) {
				return "电极帽零件图号不能为空！";
			}
			if (!(StringHelper.isNotEmpty(stroke))) {
				return "行程不能为空！";
			}
			if ("null" == stroke || ((stroke != null) && stroke.equals(""))
					|| null == stroke) {
				System.out.println("xingcheng");
				return "行程不能为空！";
			}
			if ("null" == armassemblyLength
					|| ((armassemblyLength != null) && armassemblyLength
							.equals("")) || null == armassemblyLength) {
				return "喉深不能为空！";
			}
			if ("null" == armassemblyWidth
					|| ((armassemblyWidth != null) && armassemblyWidth
							.equals("")) || null == armassemblyWidth) {
				return "喉宽不能为空！";
			}
			if ("null" == armassemblyWidth2
					|| ((armassemblyWidth2 != null) && armassemblyWidth2
							.equals("")) || null == armassemblyWidth2) {
				return "臂间距不能为空！";
			}
			if ("null" == force || ((force != null) && force.equals(""))
					|| null == force) {
				return "压力等级不能为空！";
			}
			if ("null" == capAngel
					|| ((capAngel != null) && capAngel.equals(""))
					|| null == capAngel) {
				return "电极帽偏转角度不能为空！";
			}
			if (!(StringHelper.isNotEmpty(flange))) {
				return "法兰盘位置不能为空！";
			}
			// 判断文件是否上传成功,注意文件类型
			if (!new File(NimakConstantSet.TURRET3D_PATH + gunDrawingno
					+ ".CATPart").exists()) {
				return "三维数模文件未上传成功！";
			}
			// 判断2d文件是否上传成功,注意文件类型
			if (!new File(NimakConstantSet.TURRET2D_PATH + gunDrawingno
					+ ".jpg").exists()) {
				return "二位图纸文件未上传成功！";
			}
			return "S_OK";
		} else {
			return "请输入钳臂实例参数！";
		}
	}

	@Expose
	public String deleteRelatedFilesByID(String ID) {
		System.out.println(ID);
		try {
			return turretDao.deleteRelatedFilesByID(ID);
		} catch (FileException e) {
			System.out.println(e.getFileErrorMsg());
			e.printStackTrace();
			return e.getFileErrorMsg();
		}
	}
}
