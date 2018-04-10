package com.nimak.utils;

import java.util.Map;

import org.springframework.web.context.ContextLoader;

import com.bstek.dorado.core.Context;

/**
 * 封装常数类主要 所有路径采用"/"
 * 
 * @author BUAA514
 * 
 */
public class NimakConstantSet {

	@SuppressWarnings("unchecked")
	private static String FILEPATHCONFIG = ((Map<String, String>) Context
			.getCurrent().getAttribute("configprop")).get("FILEPATHCONFIG");
	private static String CONTEXTPATH = ContextLoader
			.getCurrentWebApplicationContext().getServletContext()
			.getRealPath("/").replaceAll("\\\\", "/");
	
	@SuppressWarnings("unchecked")
	private static Map<String, String> configMap = (Map<String, String>) (Context.getCurrent().getAttribute("configprop"));
	

	// 文件上传后的路径，暂用相对路径---》turret 2D
	@SuppressWarnings("unchecked")
	public static final String TURRET2D_PATH = (FILEPATHCONFIG
			.equals("relative") == true ? (CONTEXTPATH + "/" + configMap.get("TURRET2D_PATH"))
			: (configMap.get("TURRET2D_PATH")));

	// 文件上传后的路径，暂用相对路径---》turret 3D
	public static String TURRET3D_PATH = (FILEPATHCONFIG
			.equals("relative") == true ? (CONTEXTPATH + "/" + configMap.get("TURRET3D_PATH")) 
			: (configMap.get("TURRET3D_PATH")));
	
	// ContextPath
	public static String CONTEXT_PATH = ContextLoader
			.getCurrentWebApplicationContext().getServletContext()
			.getRealPath("/");

	// 文件上传后的路径，暂用相对路径---》turretcomponent 2D
	public static String TURRETCOMPONENT2D_PATH = (FILEPATHCONFIG
			.equals("relative") == true ? (CONTEXTPATH + "/" + configMap.get("TURRETCOMPONENT2D_PATH"))
			: configMap.get("TURRETCOMPONENT2D_PATH"));

	// 文件上传后的路径，暂用相对路径---》turretcomponent 3D
	public static String TURRETCOMPONENT3D_PATH = (FILEPATHCONFIG
			.equals("relative") == true ? (CONTEXTPATH + "/" + configMap.get("TURRETCOMPONENT3D_PATH"))
			: (configMap.get("TURRETCOMPONENT3D_PATH")));

	// 文件上传后的路径，暂用相对路径---》turretarmsPART 2D
	public static String TURRETARM2D_PATH = (FILEPATHCONFIG
			.equals("relative") == true ? (CONTEXTPATH + "/" + configMap.get("TURRETARM2D_PATH"))
			: (configMap.get("TURRETARM2D_PATH")));

	// 文件上传后的路径，暂用相对路径---》turretarmsPART 3D
	public static String TURRETARM3D_PATH = (FILEPATHCONFIG
			.equals("relative") == true ? (CONTEXTPATH + "/" + configMap.get("TURRETARM3D_PATH"))
			: (configMap.get("TURRETARM3D_PATH")));
	
	// 文件上传后的路径，暂用相对路径---》turretarmsPARTATTACHEDPAGE
	public static String TURRETARMATTACHEDPAGE_PATH= (FILEPATHCONFIG
			.equals("relative") == true ? (CONTEXTPATH + "/" + configMap.get("TURRETARMATTACHEDPAGE_PATH")) 
			: (configMap.get("TURRETARMATTACHEDPAGE_PATH")));

	// 文件上传后的路径，暂用相对路径---》turretarmsCOMP 2D
	public static String TURRETARMCOM2D_PATH = (FILEPATHCONFIG
			.equals("relative") == true ? (CONTEXTPATH + "/" + configMap.get("TURRETARMCOM2D_PATH"))
			: (configMap.get("TURRETARMCOM2D_PATH")));

	// 文件上传后的路径，暂用相对路径---》turretarmsCOMP 3D
	public static String TURRETARMCOM3D_PATH = (FILEPATHCONFIG
			.equals("relative") == true ? (CONTEXTPATH + "/" + configMap.get("TURRETARMCOM3D_PATH"))
			: (configMap.get("TURRETARMCOM3D_PATH")));

	// 文件上传后的路径，暂用相对路径---》turretshankPART 2D
	public static String TURRETSHANK2D_PATH = (FILEPATHCONFIG
			.equals("relative") == true ? (CONTEXTPATH + "/" + configMap.get("TURRETSHANK2D_PATH"))
			: (configMap.get("TURRETSHANK2D_PATH")));

	// 文件上传后的路径，暂用相对路径---》turretshankPARTturretshankPART 3D
	public static String TURRETSHANK3D_PATH = (FILEPATHCONFIG
			.equals("relative") == true ? (CONTEXTPATH + "/" + configMap.get("TURRETSHANK3D_PATH"))
			: (configMap.get("TURRETSHANK3D_PATH")));

	// 文件上传后的路径，暂用相对路径---》turretshankCOMP 2D
	public static String TURRETSHANKCOM2D_PATH = (FILEPATHCONFIG
			.equals("relative") == true ? (CONTEXTPATH + "/" + configMap.get("TURRETSHANKCOM2D_PATH"))
			: (configMap.get("TURRETSHANKCOM2D_PATH")));

	// 文件上传后的路径，暂用相对路径---》turretshankCOMP 3D
	public static String TURRETSHANKCOM3D_PATH = (FILEPATHCONFIG
			.equals("relative") == true ? (CONTEXTPATH + "/" + configMap.get("TURRETSHANKCOM3D_PATH"))
			: (configMap.get("TURRETSHANKCOM3D_PATH")));
	
	// 文件上传后的路径，暂用相对路径---》tempData
	public static String TEMPDATA_PATH = (FILEPATHCONFIG
				.equals("relative") == true ? (CONTEXTPATH + "/" + configMap.get("TEMPDATA_PATH"))
				: (configMap.get("TEMPDATA_PATH")));
	
	
	
	
	//文件后缀名设置，便于文件下载
	// 产品文件后缀名
	public static String PRODUCT_EXT = configMap.get("PRODUCT_EXT");
	// 产品文件后缀名-2D
	public static String PRODUCT_2D_EXT = configMap.get("PRODUCT_2D_EXT");
	// 部件文件后缀名
	public static String WIDGET_EXT = configMap.get("WIDGET_EXT");	
	// 部件文件后缀名-2D
	public static String WIDGET_2D_EXT = configMap.get("WIDGET_2D_EXT");
	// 组件文件后缀名
	public static String COMPONENT_EXT = configMap.get("COMPONENT_EXT");
	// 组件文件后缀名-工艺附属页
	public static String COMPONENT_PAGE_EXT = configMap.get("COMPONENT_PAGE_EXT");
	// 组件文件后缀名-2D
	public static String COMPONENT_2D_EXT = configMap.get("COMPONENT_2D_EXT");
	
	// 压缩文件后缀名
	public static String ZIPFILE_SUFFIX = configMap.get("ZIPFILE_SUFFIX");
	
	
}
