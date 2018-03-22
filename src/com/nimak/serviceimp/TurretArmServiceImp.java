package com.nimak.serviceimp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.cache.ApplicationCache;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.Expose;
import com.nimak.daoimp.TurretArmDaoImp;
import com.nimak.entity.Turretarm;
import com.nimak.entity.Turretpart;
import com.nimak.serviceinterface.TurretArmServiceI;

@Component
public class TurretArmServiceImp implements TurretArmServiceI{
	
	ApplicationCache applicationCache = ContextHolder.getBean(ApplicationCache.BEAN_ID);
	
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
		compDrawingStrings = turretArmDaoImp.query(hql);
		/*for (String string : compDrawingStrings) {
			System.out.println(string);
		}*/
		
		logger.info("Get所有的钳臂零件图号：" + compDrawingStrings);
		return compDrawingStrings;
	}

}
