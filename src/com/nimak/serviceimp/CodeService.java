package com.nimak.serviceimp;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 编码实现类，编码规则实现
 * @author BUAA514
 *
 */
public class CodeService {
	
	private Logger logger = Logger.getLogger(CodeService.class);

	
	/**
	 * 根据编码规则对钳臂部件进行编码
	 * @param params	传入钳臂部件的编码所需的参数
	 * @return			编码是否成功
	 */
	public Map<String, String> codeTurretComponentByParameter(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Map<String, String> returnMap = new HashMap<String, String>();
		returnMap.put("codeflag", "S_OK");
		
		String gunType 				= (String) params.get("gunType");
		String armassemblyLength 	= (String.valueOf(params.get("armassemblyLength")));
		String armassemblyWidth 	= (String.valueOf(params.get("armassemblyWidth")));
		String armassemblyWidth2	= (String.valueOf(params.get("armassemblyWidth2")));
		String force 				= (String.valueOf(params.get("force")));
		String capAngel 			= (String.valueOf(params.get("capAngel")));

		
		String coderesult="";
		if ("C".equals(gunType)) {
			coderesult = coderesult.concat("0");
		}else {
			coderesult = coderesult.concat("1");
		}
		
		double dArmAssemblyLength = Double.parseDouble(armassemblyLength);
		double dArmAssemblyWidth = Double.parseDouble(armassemblyWidth);
		double dArmAssemblyWidth2 = Double.parseDouble(armassemblyWidth2);
		double dForce = Double.parseDouble(force);
		double dCapAngel = Double.parseDouble(capAngel);
		
		// armassemblyWidth码位==臂间距
		if (dArmAssemblyWidth2 >0  && dArmAssemblyWidth2 < 125) {
			coderesult = coderesult.concat("0");
		}else if (dArmAssemblyWidth2 >=125  && dArmAssemblyWidth2 < 150) {
			coderesult = coderesult.concat("1");
		}else if (dArmAssemblyWidth2 >=150  && dArmAssemblyWidth2 < 175) {
			coderesult = coderesult.concat("2");
		}else if (dArmAssemblyWidth2 >=175  && dArmAssemblyWidth2 < 200) {
			coderesult = coderesult.concat("3");
		}else if (dArmAssemblyWidth2 >=200  && dArmAssemblyWidth2 < 225) {
			coderesult = coderesult.concat("4");
		}else if (dArmAssemblyWidth2 >=225  && dArmAssemblyWidth2 < 250) {
			coderesult = coderesult.concat("5");
		}else if (dArmAssemblyWidth2 >=250  && dArmAssemblyWidth2 < 275) {
			coderesult = coderesult.concat("6");
		}else if (dArmAssemblyWidth2 >=275  && dArmAssemblyWidth2 < 300) {
			coderesult = coderesult.concat("7");
		}else if (dArmAssemblyWidth2 >=300  && dArmAssemblyWidth2 < 325) {
			coderesult = coderesult.concat("8");
		}else if (dArmAssemblyWidth2 >=325) {
			coderesult = coderesult.concat("9");
		}
		
		
		// armassemblyLength码位 === 喉深
		if (dArmAssemblyLength >0  && dArmAssemblyLength < 300) {
			coderesult = coderesult.concat("2");
		}else if (dArmAssemblyLength >=300  && dArmAssemblyLength < 400) {
			coderesult = coderesult.concat("3");
		}else if (dArmAssemblyLength >=400  && dArmAssemblyLength < 500) {
			coderesult = coderesult.concat("4");
		}else if (dArmAssemblyLength >=500  && dArmAssemblyLength < 600) {
			coderesult = coderesult.concat("5");
		}else if (dArmAssemblyLength >=600  && dArmAssemblyLength < 700) {
			coderesult = coderesult.concat("6");
		}else if (dArmAssemblyLength >=700  && dArmAssemblyLength < 800) {
			coderesult = coderesult.concat("7");
		}else if (dArmAssemblyLength >=800  && dArmAssemblyLength < 900) {
			coderesult = coderesult.concat("8");
		}else if (dArmAssemblyLength >=900) {
			coderesult = coderesult.concat("9");
		}
		
		// armassemblyWidth码位 === 喉宽
		if (dArmAssemblyWidth >0  && dArmAssemblyWidth < 125) {
			coderesult = coderesult.concat("0");
		}else if (dArmAssemblyWidth >=125  && dArmAssemblyWidth < 150) {
			coderesult = coderesult.concat("1");
		}else if (dArmAssemblyWidth >=150  && dArmAssemblyWidth < 200) {
			coderesult = coderesult.concat("2");
		}else if (dArmAssemblyWidth >=200  && dArmAssemblyWidth < 250) {
			coderesult = coderesult.concat("3");
		}else if (dArmAssemblyWidth >=250  && dArmAssemblyWidth < 300) {
			coderesult = coderesult.concat("4");
		}else if (dArmAssemblyWidth >=300  && dArmAssemblyWidth < 350) {
			coderesult = coderesult.concat("5");
		}else if (dArmAssemblyWidth >=350  && dArmAssemblyWidth < 400) {
			coderesult = coderesult.concat("6");
		}else if (dArmAssemblyWidth >=400  && dArmAssemblyWidth < 450) {
			coderesult = coderesult.concat("7");
		}else if (dArmAssemblyWidth >=450  && dArmAssemblyWidth < 500) {
			coderesult = coderesult.concat("8");
		}else if (dArmAssemblyWidth >=500) {
			coderesult = coderesult.concat("9");
		}
		
		// force码位 === 压力等级
		if (dForce >=1.0  && dForce < 1.5) {
			coderesult = coderesult.concat("0");
		}else if (dForce >=1.5  && dForce < 2.0) {
			coderesult = coderesult.concat("1");
		}else if (dForce >=2.0  && dForce < 2.5) {
			coderesult = coderesult.concat("2");
		}else if (dForce >=2.5  && dForce < 3.0) {
			coderesult = coderesult.concat("3");
		}else if (dForce >=3.0  && dForce < 3.5) {
			coderesult = coderesult.concat("4");
		}else if (dForce >=3.5  && dForce < 4.0) {
			coderesult = coderesult.concat("5");
		}else if (dForce >=4.0  && dForce < 4.5) {
			coderesult = coderesult.concat("6");
		}else if (dForce >=4.5  && dForce < 5.0) {
			coderesult = coderesult.concat("7");
		}else if (dForce >=5.0  && dForce < 5.5) {
			coderesult = coderesult.concat("8");
		}else if (dForce >=5.5) {
			coderesult = coderesult.concat("9");
		}
		
		// dCapAngel码位 === 压电极帽旋转角度
		if (dCapAngel == 0) {
			coderesult = coderesult.concat("0");
		}else if (dCapAngel == 5) {
			coderesult = coderesult.concat("1");
		}else if (dCapAngel == 10) {
			coderesult = coderesult.concat("2");
		}else if (dCapAngel == 15) {
			coderesult = coderesult.concat("3");
		}else {
			coderesult = coderesult.concat("4");
		}
				
		logger.info("钳臂部件编码结果：" + coderesult);
		returnMap.put("coderesult", coderesult);
		
		return returnMap;
	}
	
	
	/**
	 * 根据编码规则对钳臂部件进行编码
	 * @param params	传入钳臂部件的编码所需的参数
	 * @return			编码是否成功
	 */
	public Map<String, String> codeTurretShankByParameter(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Map<String, String> returnMap = new HashMap<String, String>();
		returnMap.put("codeflag", "S_OK");
		
		String shankType 	= (String) params.get("shankType");
		String shankTaper 	= (String) params.get("shankTaper");
		/*String shankAngel1 	= (String.valueOf(params.get("shankAngel1")));
		String shankAngel2	= (String.valueOf(params.get("shankAngel2")));
		String shankAngel3 	= (String.valueOf(params.get("shankAngel3")));*/
		String shankAngel1 	= (String) params.get("shankAngel1");
		String shankAngel2	= (String) params.get("shankAngel2");
		String shankAngel3 	= (String) params.get("shankAngel3");
		String capAngel 	= (String.valueOf(params.get("capAngel")));
		System.out.println(shankAngel1);
		logger.info("电极握杆偏转角度1："+shankAngel1);

		if (StringUtils.isEmpty(shankType) || StringUtils.isEmpty(shankTaper) || StringUtils.isEmpty(shankAngel1) || 
				StringUtils.isEmpty(shankAngel2) || StringUtils.isEmpty(shankAngel3)) {
			logger.info("参数不完整不能成功为电极握杆零件编码！" );
			returnMap.put("codeflag", "E_Fail");
			return returnMap;
		}
		
		
		String coderesult="";
		
		// 握杆链接形式码位
		if ("螺纹式".equals(shankType)) {
			coderesult = coderesult.concat("0");
		}else if("抱紧式".equals(shankType)){
			coderesult = coderesult.concat("1");
		}else {
			coderesult = coderesult.concat("2");
		}
		
		// 锥度码位
		if ("1:10".equals(shankTaper)) {
			coderesult = coderesult.concat("0");
		}else if("1:9.6".equals(shankTaper)){
			coderesult = coderesult.concat("1");
		}else {
			coderesult = coderesult.concat("2");
		}
		
		double dShankAngel1 = Double.parseDouble(shankAngel1.substring(0, 
				(shankAngel1.indexOf("[")==-1 ? shankAngel1.length() : shankAngel1.indexOf("["))));
		double dShankAngel2 = Double.parseDouble(shankAngel2.substring(0, 
				(shankAngel2.indexOf("[")==-1 ? shankAngel2.length() : shankAngel2.indexOf("["))));
		double dShankAngel3 = Double.parseDouble(shankAngel3.substring(0,
				(shankAngel3.indexOf("[")==-1 ? shankAngel3.length() : shankAngel3.indexOf("["))));
		
		// dShankAngel1码位==偏移角度1
		if ("无".equals(shankAngel1) || "0".equals(shankAngel1)) {
			coderesult = coderesult.concat("0");
		}else if ((dShankAngel1 > -180  && dShankAngel1 < -90) && shankAngel1.contains("折弯")) {
			coderesult = coderesult.concat("1");
		}else if ((dShankAngel1 == -90) && shankAngel1.contains("折弯")) {
			coderesult = coderesult.concat("2");
		}else if ((dShankAngel1 > -180  && dShankAngel1 < -90) && shankAngel1.contains("机加")) {
			coderesult = coderesult.concat("3");
		}else if ((dShankAngel1 == -90) && shankAngel1.contains("机加")) {
			coderesult = coderesult.concat("4");
		}else if ((dShankAngel1 > 90  && dShankAngel1 < 180) && shankAngel1.contains("折弯")) {
			coderesult = coderesult.concat("5");
		}else if ((dShankAngel1 == 90) && shankAngel1.contains("折弯")) {
			coderesult = coderesult.concat("6");
		}else if ((dShankAngel1 > 90  && dShankAngel1 < 180) && shankAngel1.contains("机加")) {
			coderesult = coderesult.concat("7");
		}else if ((dShankAngel1 == 90) && shankAngel1.contains("机加")) {
			coderesult = coderesult.concat("8");
		}else {
			coderesult = coderesult.concat("9");
		}
		
		// dShankAngel2码位==偏移角度2
		if ("无".equals(shankAngel2) || "0".equals(shankAngel2)) {
			coderesult = coderesult.concat("0");
		}else if ((dShankAngel2 > -180  && dShankAngel2 < -90) && shankAngel2.contains("折弯")) {
			coderesult = coderesult.concat("1");
		}else if ((dShankAngel2 == -90) && shankAngel2.contains("折弯")) {
			coderesult = coderesult.concat("2");
		}else if ((dShankAngel2 > -180  && dShankAngel2 < -90) && shankAngel2.contains("机加")) {
			coderesult = coderesult.concat("3");
		}else if ((dShankAngel2 == -90) && shankAngel2.contains("机加")) {
			coderesult = coderesult.concat("4");
		}else if ((dShankAngel2 > 90  && dShankAngel2 < 180) && shankAngel2.contains("折弯")) {
			coderesult = coderesult.concat("5");
		}else if ((dShankAngel2 == 90) && shankAngel2.contains("折弯")) {
			coderesult = coderesult.concat("6");
		}else if ((dShankAngel2 > 90  && dShankAngel2 < 180) && shankAngel2.contains("机加")) {
			coderesult = coderesult.concat("7");
		}else if ((dShankAngel2 == 90) && shankAngel2.contains("机加")) {
			coderesult = coderesult.concat("8");
		}else {
			coderesult = coderesult.concat("9");
		}
		
		// dShankAngel3码位==偏移角度3
		if ("无".equals(shankAngel3) || "0".equals(shankAngel3)) {
			coderesult = coderesult.concat("0");
		}else if ((dShankAngel3 > -180  && dShankAngel3 < -90) && shankAngel3.contains("折弯")) {
			coderesult = coderesult.concat("1");
		}else if ((dShankAngel3 == -90) && shankAngel3.contains("折弯")) {
			coderesult = coderesult.concat("2");
		}else if ((dShankAngel3 > -180  && dShankAngel3 < -90) && shankAngel3.contains("机加")) {
			coderesult = coderesult.concat("3");
		}else if ((dShankAngel3 == -90) && shankAngel3.contains("机加")) {
			coderesult = coderesult.concat("4");
		}else if ((dShankAngel3 > 90  && dShankAngel3 < 180) && shankAngel3.contains("折弯")) {
			coderesult = coderesult.concat("5");
		}else if ((dShankAngel3 == 90) && shankAngel3.contains("折弯")) {
			coderesult = coderesult.concat("6");
		}else if ((dShankAngel3 > 90  && dShankAngel3 < 180) && shankAngel3.contains("机加")) {
			coderesult = coderesult.concat("7");
		}else if ((dShankAngel3 == 90) && shankAngel3.contains("机加")) {
			coderesult = coderesult.concat("8");
		}else {
			coderesult = coderesult.concat("9");
		}
		
				
		logger.info("钳臂部件编码结果：" + coderesult);
		returnMap.put("coderesult", coderesult);
		
		return returnMap;
	}

}
