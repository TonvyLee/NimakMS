package com.nimak.serviceimp;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;

import org.apache.log4j.Logger;
import org.hibernate.annotations.common.util.StringHelper;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf2.core.cache.ApplicationCache;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.hibernate.HibernateUtils;
import com.nimak.daoimp.ElectrodeHolderDaoImp;
import com.nimak.daoimp.TurretArmDaoImp;
import com.nimak.daoimp.TurretComponentDaoImp;
import com.nimak.entity.Electrodeholder;
import com.nimak.entity.Turret;
import com.nimak.entity.Turretarm;
import com.nimak.entity.Turretpart;
import com.nimak.exception.FileException;
import com.nimak.serviceinterface.TurretArmServiceI;
import com.nimak.serviceinterface.TurretComponentServiceI;
import com.nimak.utils.NimakConstantSet;
import com.nimak.utils.NimakStringUtils;

@Component
public class TurretComponentServiceImp implements TurretComponentServiceI {
	
	ApplicationCache applicationCache = ContextHolder.getBean(ApplicationCache.BEAN_ID);

	@Resource
	public TurretComponentDaoImp turretComponentDao;

	@Resource
	public TurretArmDaoImp turretArmDaoImp;

	@Resource
	public ElectrodeHolderDaoImp electrodeHolderDaoImp;
	
	
	 private Logger logger = Logger.getLogger(TurretComponentServiceImp.class);

	@Override
	@DataProvider
	public void getAllTurretComponentInfoByPage(Page<Turretpart> page,
			Criteria criteria) throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Turret.class);
		if (criteria != null) {
			HibernateUtils.createFilter(detachedCriteria, criteria);
		}
		turretComponentDao.pagingQuery(page, detachedCriteria);
	}

	@Override
	@DataProvider
	public List<Turretpart> getAllTurretComponentInfo() {
		String hql = "from " + Turretpart.class.getName() + "";
		return turretComponentDao.query(hql);
	}

	@Override
	@DataProvider
	public void queryForCondition(Page<Turretpart> page,
			Map<String, Object> params) throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Turretpart.class);
		if (params != null) {
			String gunType 				= (String) params.get("gunType");
			String armAssemblyno 		= (String) params.get("armAssemblyno");
			String armComponentno 		= (String) params.get("armComponentno");
			String shankComponentno 	= (String) params.get("shankComponentno");
			String armDrawingno 		= (String) params.get("armDrawingno");
			String shankDrawingno 		= (String) params.get("shankDrawingno");
			
			
			
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
			
			
			String armassemblyTechchange= (String) params
					.get("armassemblyTechchange");
			String armassemblyCode 		= (String) params.get("armassemblyCode");

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
			if (StringHelper.isNotEmpty(armComponentno)) {
				dc.add(Restrictions.like("armComponentno", NimakStringUtils
						.AddCharToBothSides(armComponentno, "%")));
			}
			if (StringHelper.isNotEmpty(armAssemblyno)) {
				dc.add(Restrictions.like("armAssemblyno",
						NimakStringUtils.AddCharToBothSides(armAssemblyno, "%")));
			}
			if (StringHelper.isNotEmpty(shankComponentno)) {
				dc.add(Restrictions.like("shankComponentno", NimakStringUtils
						.AddCharToBothSides(shankComponentno, "%")));
			}
			if (StringHelper.isNotEmpty(armDrawingno)) {
				dc.add(Restrictions.like("armDrawingno",
						NimakStringUtils.AddCharToBothSides(armDrawingno, "%")));
			}
			if (StringHelper.isNotEmpty(shankDrawingno)) {
				dc.add(Restrictions.like("shankDrawingno", NimakStringUtils
						.AddCharToBothSides(shankDrawingno, "%")));
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
				dc.add(Restrictions.like("force", force));
			}
			if (null != capAngel) {
				dc.add(Restrictions.like("capAngel", capAngel));
			}
			
			
			if (StringHelper.isNotEmpty(armassemblyTechchange)) {
				dc.add(Restrictions.like("armassemblyTechchange",
						NimakStringUtils.AddCharToBothSides(
								armassemblyTechchange, "%")));
			}
			if (StringHelper.isNotEmpty(armassemblyCode)) {
				dc.add(Restrictions.like("armassemblyCode", NimakStringUtils
						.AddCharToBothSides(armassemblyCode, "%")));
			}
			/*
			 * if (designdate != null) { whereCase +=
			 * " AND to_char(designdate,'yyyy-mm-dd') like '%" + designdate +
			 * "%' "; }
			 */
			turretComponentDao.pagingQuery(page, dc);
		} else {
			turretComponentDao.pagingQuery(page, dc);
		}
	}

	@Override
	@DataResolver
	@Transactional
	public void saveAll(Collection<Turretpart> allTurretComponents) {
		turretComponentDao.saveAll(allTurretComponents);
	}

	@Override
	@Expose
	public Map<String, String> isNewAddedTurretSatisfied(
			Map<String, Object> params) {
		System.out.println("Start verify turretcomponent conditions");
		logger.info("isNewAddedTurretSatisfied传入参数"+params);
		Map<String, String> returnMap = new HashMap<>();
		if (params != null) {
			String gunType 			= (String) params.get("gunType");
			String armAssemblyno 	= (String) params.get("armAssemblyno");
			String armComponentno 	= (String) params.get("armComponentno");
			String shankComponentno = (String) params.get("shankComponentno");
			String armDrawingno 	= (String) params.get("armDrawingno");
			String shankDrawingno 	= (String) params.get("shankDrawingno");
			String armassemblyLength= (String.valueOf(params.get("armassemblyLength")));
			String armassemblyWidth = (String.valueOf(params.get("armassemblyWidth")));
			String armassemblyWidth2= (String.valueOf(params.get("armassemblyWidth2")));
			String force 			= (String.valueOf(params.get("force")));
			String capAngel 		= (String.valueOf(params.get("capAngel")));

			String armassemblyTechchange 	= (String) params.get("armassemblyTechchange");
			String armassemblyCode 			= (String) params.get("armassemblyCode");

			if (gunType == null || (gunType != null) && gunType.equals("")) {
				returnMap.put("flag", "钳臂类型不能为空！");
				return returnMap;
			}
			if (armAssemblyno == null || (armAssemblyno != null)
					&& armAssemblyno.equals("")) {
				returnMap.put("flag", "请填写钳臂部件图号！");
				return returnMap;
			}
			if (armComponentno == null || (armComponentno != null)
					&& armComponentno.equals("")) {
				returnMap.put("flag", "请填写钳臂组件信息！");
				return returnMap;
			}
			if (!(StringHelper.isNotEmpty(shankComponentno))) {
				returnMap.put("flag", "请填写电极握杆组件信息！");
				return returnMap;
			}
			if (!(StringHelper.isNotEmpty(armDrawingno))) {
				returnMap.put("flag", "请填写钳臂零件信息！");
				return returnMap;
			}
			if (!(StringHelper.isNotEmpty(shankDrawingno))) {
				returnMap.put("flag", "请填写电极握杆零件信息！");
				return returnMap;
			}

			if ("null" == armassemblyLength
					|| ((armassemblyLength != null) && armassemblyLength
							.equals("")) || null == armassemblyLength) {
				returnMap.put("flag", "喉深不能为空！");
				return returnMap;
			}
			if ("null" == armassemblyWidth
					|| ((armassemblyWidth != null) && armassemblyWidth
							.equals("")) || null == armassemblyWidth) {
				returnMap.put("flag", "喉宽不能为空！");
				return returnMap;
			}
			if ("null" == armassemblyWidth2
					|| ((armassemblyWidth2 != null) && armassemblyWidth2
							.equals("")) || null == armassemblyWidth2) {
				returnMap.put("flag", "臂间距不能为空！");
				return returnMap;
			}
			if ("null" == force || ((force != null) && force.equals(""))
					|| null == force) {
				returnMap.put("flag", "压力等级不能为空！");
				return returnMap;
			}
			if ("null" == capAngel
					|| ((capAngel != null) && capAngel.equals(""))
					|| null == capAngel) {
				returnMap.put("flag", "电极帽偏转角度不能为空！");
				return returnMap;
			}

			// 参数满足条件
			returnMap.put("flag", "S_OK");
			// 如果编码成功！
			Map<String, String> codeMap = codeTurretComponentByParameter(params);
			if ("S_OK".equals(codeMap.get("flag"))) {
				returnMap.put("coderesult", codeTurretComponentByParameter(params).get("coderesult"));
			}
			
			// 判断文件是否上传成功,注意文件类型
			if (!new File(NimakConstantSet.TURRETCOMPONENT3D_PATH
					+ armAssemblyno + ".CATPart").exists()) {
				returnMap.put("flag", "三维数模文件未上传成功！");
				return returnMap;
			}
			// 判断2d文件是否上传成功,注意文件类型
			if (!new File(NimakConstantSet.TURRETCOMPONENT2D_PATH
					+ armAssemblyno + ".jpg").exists()) {
				returnMap.put("flag", "二维图纸文件未上传成功！");
				return returnMap;
			}
			
			
		} else {
			returnMap.put("flag", "请输入钳臂部件相关参数！");
			return returnMap;
		}
		return returnMap;
	}

	@Expose
	public Map<String, String> codeTurretComponentByParameter(Map<String, Object> params) {
		logger.info("Start codeTurretComponentByParameter ");		
		System.out.println("codeTurretComponentByParameter传入参数："+params);
		Map<String, String> returnMap = new HashMap<>();
		String armDrawingno = (String) params.get("armDrawingno");
		String shankDrawingno = (String) params.get("shankDrawingno");
		
		// 经过上述判断后可以直接进行编码,并且params已经不为空，在调用函数中不需要进行判断。
		// 下面方法可以获取到部件整体信息的编码。总的编码结果是部件整体信息编码结果+组成部件的零件+握杆零件的编码
		Map<String, String> map = new CodeService()
				.codeTurretComponentByParameter(params);
		// 编码成功
		if ("S_OK".equals(map.get("codeflag"))) {
			// armDrawingno
			String coderesult = map.get("coderesult");
			// 获取组成该部件的零件编码，包括钳臂零件和握杆零件
			List<Turretarm> turretArmByDrawingNo = turretArmDaoImp
					.getTurretArmByDrawingNo(armDrawingno);
			if (turretArmByDrawingNo != null) {
				if (turretArmDaoImp.getTurretArmByDrawingNo(armDrawingno)
						.size() > 0) {
					String armPartCode = turretArmDaoImp
							.getTurretArmByDrawingNo(armDrawingno).get(0)
							.getArmCode();
					coderesult = coderesult.concat("." + armPartCode);
				}
			}

			// 获取握杆编码
			List<Electrodeholder> electrodeholders = electrodeHolderDaoImp
					.getHolderByShankNo(shankDrawingno);
			if (electrodeholders != null) {
				if (electrodeHolderDaoImp.getHolderByShankNo(shankDrawingno)
						.size() > 0) {
					String shankPartCode = electrodeHolderDaoImp
							.getHolderByShankNo(shankDrawingno).get(0)
							.getShankCode();
					coderesult = coderesult.concat("." + shankPartCode);
				}
			}

			returnMap.put("flag", "S_OK");
			returnMap.put("coderesult", coderesult);
			return returnMap;
		} else {
			returnMap.put("flag", "E_Fail");
			return returnMap;
		}
	}

	@Override
	@Expose
	public String deleteRelatedFilesByID(String ID) {
		logger.info("即将根据ID删除文件，ID="+ID);
		try {
			return turretComponentDao.deleteRelatedFilesByID(ID);
		} catch (FileException e) {
			logger.info("即将根据ID删除文件出错");
			System.out.println(e.getFileErrorMsg());
			e.printStackTrace();
			return e.getFileErrorMsg();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@DataProvider
	public Collection<Turretpart> getTurretComponentByDrawingno(
			String armAssemblyno) {
		String hql = "from " + Turretpart.class.getName()
				+ " where armAssemblyno like :armAssemblyno";
		Map param = new HashMap();
		if (StringHelper.isNotEmpty(armAssemblyno)) {
			param.put("armAssemblyno", "%" + armAssemblyno + "%");
			return turretComponentDao.query(hql,param);
		} else {
			return getAllTurretComponentInfo();
		}
	}

	@Override
	@DataProvider
	public List<String> getTurretComponentDrawingByDrawingno(
			String armAssemblyno) {
		List<String> compDrawingStrings = new ArrayList<>();
		List<Turretpart> tuList = new ArrayList<>();
		String hql = "from " + Turretpart.class.getName()
				+ " where armAssemblyno like :armAssemblyno";
		Map param = new HashMap();
		if (StringHelper.isNotEmpty(armAssemblyno)) {
			param.put("armAssemblyno", "%" + armAssemblyno + "%");
			tuList =  turretComponentDao.query(hql,param);
		} else {
			tuList = getAllTurretComponentInfo();
		}
		
		for (Turretpart turretpart : tuList) {
			compDrawingStrings.add(turretpart.getArmAssemblyno());
		}
		return compDrawingStrings;
	}

	@Override
	@Expose
	public List<String> getAllTurretCompDrawingnos() {
		List<String> compDrawingStrings = new ArrayList<>();
		
		String hql = "select armAssemblyno from " + Turretpart.class.getName();
		compDrawingStrings = turretComponentDao.query(hql);
		/*for (String string : compDrawingStrings) {
			System.out.println(string);
		}*/
		
		logger.info("Get所有的钳臂组件图号" + compDrawingStrings);
		return compDrawingStrings;
	}
	
	// 上面方法的另外一种服务
/*	@Override
	@Expose
	public List<String> getAllTurretCompDrawingnos() {
		List<String> compDrawingStrings = new ArrayList<>();
		List<Turretpart> tuList = new ArrayList<>();
		tuList = getAllTurretComponentInfo();
		
		for (Turretpart turretpart : tuList) {
			compDrawingStrings.add(turretpart.getArmAssemblyno());
		}
		System.out.println("GetAlllTurretCompDrawingnos");
		return compDrawingStrings;
	}
*/
}
