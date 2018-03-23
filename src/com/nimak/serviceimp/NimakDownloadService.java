package com.nimak.serviceimp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.uploader.DownloadFile;
import com.bstek.dorado.uploader.annotation.FileProvider;
import com.nimak.daoimp.TurretComponentDaoImp;
import com.nimak.exception.FileException;
import com.nimak.utils.NimakConstantSet;
import com.nimak.utils.ZipUtil;

@Component
public class NimakDownloadService {
	
	@Resource
	private TurretComponentDaoImp componentDaoImp;
	
	
	//自定义控制台输出
	private static Logger logger= Logger.getLogger(NimakDownloadService.class);

	/**
	 * 下载文件
	 * 
	 * @param parameter
	 * @return
	 * @throws IOException
	 */
	@FileProvider
	public DownloadFile downloadFile1(Map<String, String> parameter)
			throws IOException {
		// 获得文件名
		String filename = new String(parameter.get("filename").getBytes(
				"iso8859-1"), "UTF-8");
		System.out.println("文件名：" + filename);
		// 定义下载路径
		String filepath = new String(parameter.get("path")
				.getBytes("iso8859-1"), "UTF-8");
		System.out.println("文件路径：" + filepath);

		if (new File("WebContent" + "\\" + filepath).exists()) {
			// 获取到对应的InputStream
			System.out.println("下载的文件存在！");
			InputStream inputStream = new FileInputStream("WebContent" + "\\"
					+ filepath);
			// 返回一个供下载文件的文件名
			return new DownloadFile(filename, inputStream);
		} else {
			System.out.println("文件不存在");
			throw new FileException("下载文件不存在！");
		}
	}

	/**
	 * 根据图号下载文件
	 * 
	 * @param parameter
	 * @return
	 * @throws IOException
	 */
	@FileProvider
	public DownloadFile downloadFile(Map<String, String> parameterMap)
			throws IOException {
		String parameter = parameterMap.get("gunDrawingno");
		if (null != parameter) {
			String TURRET3D_PATH = NimakConstantSet.TURRET3D_PATH;
			System.out.println(TURRET3D_PATH);
			String filePath = TURRET3D_PATH + parameter + NimakConstantSet.PRODUCT_EXT;
			// 获取到对应的InputStream
			System.out.println(filePath);
			InputStream inputStream = new FileInputStream(filePath);
			// 返回一个供下载文件的文件名
			return new DownloadFile(parameter+NimakConstantSet.PRODUCT_EXT, inputStream);
		}else {
			return null;
		}

	}
	
	/**
	 * 根据图号打包下载文件钳臂产品的所有相关数模文件，包括组成产品的部件，组成部件的组件或者零件
	 * 
	 * @param parameter
	 * @return
	 * @throws IOException
	 */
	@FileProvider
	public DownloadFile downloadFileTurretZip(Map<String, String> parameterMap)
			throws IOException {
		logger.info("即将打包下载产品及其部件、组件三维数模！");
		String parameter = parameterMap.get("gunDrawingno");
		String armAssemblynoF = parameterMap.get("armAssemblynoF");
		String armAssemblynoM = parameterMap.get("armAssemblynoM");
		System.out.println(parameterMap);
		if (null != parameter && null != armAssemblynoF && null != armAssemblynoM) {
			String TURRET3D_PATH 			= NimakConstantSet.TURRET3D_PATH;
			String TURRETCOMPONENT3D_PATH 	= NimakConstantSet.TURRETCOMPONENT3D_PATH;
			String TURRETARMCOM3D_PATH 		= NimakConstantSet.TURRETARMCOM3D_PATH;
			String TURRETSHANKCOM3D_PATH 	= NimakConstantSet.TURRETSHANKCOM3D_PATH;
			System.out.println(TURRET3D_PATH);
			String filePath = TURRET3D_PATH + parameter + NimakConstantSet.PRODUCT_EXT;
			String filePath1 = TURRETCOMPONENT3D_PATH + armAssemblynoF + NimakConstantSet.WIDGET_EXT;
			String filePath2 = TURRETCOMPONENT3D_PATH + armAssemblynoM + NimakConstantSet.WIDGET_EXT;
			
			List<File> files = new ArrayList<>();
			// 获取到对应的InputStream
			System.out.println(filePath);
			files.add(new File(filePath));
			// 构成产品的部件
			files.add(new File(filePath1));
			files.add(new File(filePath2));
			
			// 构成部件的组件
			Map<String, String> map = componentDaoImp.getPartNos(armAssemblynoF);
			String armComponentno1 = map.get("armComponentno");
			String shankComponentno1 = map.get("shankComponentno");
			String filePathArm1 = TURRETARMCOM3D_PATH +armComponentno1+NimakConstantSet.COMPONENT_EXT;
			String filePathShank1 = TURRETSHANKCOM3D_PATH +shankComponentno1+NimakConstantSet.COMPONENT_EXT;
			
			// 构成部件的组件
			map = componentDaoImp.getPartNos(armAssemblynoM);
			String armComponentno2 = map.get("armComponentno");
			String shankComponentno2 = map.get("shankComponentno");
			String filePathArm2 = TURRETARMCOM3D_PATH +armComponentno2+NimakConstantSet.COMPONENT_EXT;
			String filePathShank2 = TURRETSHANKCOM3D_PATH +shankComponentno2+NimakConstantSet.COMPONENT_EXT;
			
			// 构成部件的组件
			files.add(new File(filePathArm1));
			files.add(new File(filePathShank1));
			files.add(new File(filePathArm2));
			files.add(new File(filePathShank2));
			
			// 批量下载
			return batchDownloadFile(files, parameter+NimakConstantSet.ZIPFILE_SUFFIX);
			
		}else {
			return null;
		}
	}
	
	
	
	
	/**
	 * 根据图号打包下载文件钳臂部件的所有相关数模文件，包括组成部件的组件或者零件
	 * 
	 * @param parameter
	 * @return
	 * @throws IOException
	 */
	@FileProvider
	public DownloadFile downloadFileWidgetsZip(Map<String, String> parameterMap)
			throws IOException {
		logger.info("即将打包下载部件及其组件三维数模！");
		String armAssemblyno 	= parameterMap.get("armAssemblyno");
		String shankComponentno = parameterMap.get("shankComponentno");
		String armComponentno 	= parameterMap.get("armComponentno");
		System.out.println(parameterMap);
		if (null != armAssemblyno && null != shankComponentno && null != armComponentno) {
			String TURRET3D_PATH 			= NimakConstantSet.TURRET3D_PATH;
			String TURRETCOMPONENT3D_PATH 	= NimakConstantSet.TURRETCOMPONENT3D_PATH;
			String TURRETARMCOM3D_PATH 		= NimakConstantSet.TURRETARMCOM3D_PATH;
			String TURRETSHANKCOM3D_PATH 	= NimakConstantSet.TURRETSHANKCOM3D_PATH;
			System.out.println(TURRET3D_PATH);
			String filePath = TURRETCOMPONENT3D_PATH + armAssemblyno + NimakConstantSet.WIDGET_EXT;
			
			List<File> files = new ArrayList<>();
			// 获取到对应的InputStream
			System.out.println(filePath);
			files.add(new File(filePath));
			
			// 构成部件的组件
			Map<String, String> map = componentDaoImp.getPartNos(armAssemblyno);
			String armComponentno1 = map.get("armComponentno");
			String shankComponentno1 = map.get("shankComponentno");
			String filePathArm1 = TURRETARMCOM3D_PATH +armComponentno1+NimakConstantSet.COMPONENT_EXT;
			String filePathShank1 = TURRETSHANKCOM3D_PATH +shankComponentno1+NimakConstantSet.COMPONENT_EXT;
					
			// 构成部件的组件
			files.add(new File(filePathArm1));
			files.add(new File(filePathShank1));			
			// 批量下载
			return batchDownloadFile(files, armAssemblyno+NimakConstantSet.ZIPFILE_SUFFIX);
			
		}else {
			return null;
		}
	}
	
	
	
	
	
	/**
	 * 根据图号下载钳臂部件三维数模文件
	 * 
	 * @param parameter
	 * @return
	 * @throws IOException
	 */
	@FileProvider
	public DownloadFile downloadTurretComponentFile(Map<String, String> parameterMap)
			throws IOException {
		String parameter = parameterMap.get("armAssemblyno");
		if (null != parameter) {
			String TURRETCOMPONENT3D_PATH = NimakConstantSet.TURRETCOMPONENT3D_PATH;
			System.out.println(TURRETCOMPONENT3D_PATH);
			String filePath = TURRETCOMPONENT3D_PATH + parameter + NimakConstantSet.WIDGET_EXT;
			// 获取到对应的InputStream
			System.out.println("即将下载钳臂部件三维数模文件" + filePath);
			logger.info("即将下载钳臂部件三维数模文件===" + filePath);
			InputStream inputStream = new FileInputStream(filePath);
			// 返回一个供下载文件的文件名
			return new DownloadFile(parameter+NimakConstantSet.WIDGET_EXT, inputStream);
		}else {
			return null;
		}

	}
	
	
	
	
	/**
	 * 根据图号下载钳臂组件、零件；电极握杆组件或者零件
	 * 
	 * @param parameter
	 * @return
	 * @throws IOException
	 */
	@FileProvider
	public DownloadFile downloadTurretArmCompFiles(Map<String, String> parameterMap)
			throws IOException {
		String COMPONENT_EXT = NimakConstantSet.COMPONENT_EXT;
		// 钳臂组件
		String armComponentno 	= parameterMap.get("armComponentno");
		// 电极握杆组件
		String shankComponentno = parameterMap.get("shankComponentno");
		// 钳臂零件
		String armDrawingno 	= parameterMap.get("armDrawingno");
		// 电极握杆零件
		String shankDrawingno 	= parameterMap.get("shankDrawingno");
		
		// 下载钳臂组件
		if (null != armComponentno) {
			// 钳臂组件三维数模文件路径
			String TURRETARMCOM3D_PATH = NimakConstantSet.TURRETARMCOM3D_PATH;
			System.out.println(TURRETARMCOM3D_PATH);
			String filePath = TURRETARMCOM3D_PATH + armComponentno + COMPONENT_EXT;
			// 获取到对应的InputStream
			System.out.println("即将下载钳臂部件三维数模文件" + filePath);
			logger.info("即将下载钳臂部件三维数模文件===" + filePath);
			
			File file = new File(filePath);
			if (!file.exists()) {
				logger.info("文件不存在===" + filePath);
				return null;
			}
			InputStream inputStream = new FileInputStream(filePath);
			// 返回一个供下载文件的文件名
			return new DownloadFile(armComponentno+COMPONENT_EXT, inputStream);
		}else if(null != shankComponentno) {
			// 电极握杆组件三维数模文件路径
			String TURRETSHANKCOM3D_PATH = NimakConstantSet.TURRETSHANKCOM3D_PATH;
			System.out.println(TURRETSHANKCOM3D_PATH);
			String filePath = TURRETSHANKCOM3D_PATH + shankComponentno + COMPONENT_EXT;
			// 获取到对应的InputStream
			System.out.println("即将下载钳臂部件三维数模文件" + filePath);
			logger.info("即将下载钳臂部件三维数模文件===" + filePath);
			
			File file = new File(filePath);
			if (!file.exists()) {
				logger.info("文件不存在===" + filePath);
				return null;
			}
			InputStream inputStream = new FileInputStream(filePath);
			// 返回一个供下载文件的文件名
			return new DownloadFile(shankComponentno+COMPONENT_EXT, inputStream);
		}else if(null != armDrawingno) {
			// 钳臂零件三维数模文件路径
			String TURRETARM3D_PATH = NimakConstantSet.TURRETARM3D_PATH;
			System.out.println(TURRETARM3D_PATH);
			String filePath = TURRETARM3D_PATH + armDrawingno + COMPONENT_EXT;
			// 获取到对应的InputStream
			System.out.println("即将下载钳臂部件三维数模文件" + filePath);
			logger.info("即将下载钳臂部件三维数模文件===" + filePath);
			
			File file = new File(filePath);
			if (!file.exists()) {
				logger.info("文件不存在===" + filePath);
				return null;
			}
			InputStream inputStream = new FileInputStream(filePath);
			// 返回一个供下载文件的文件名
			return new DownloadFile(armDrawingno+COMPONENT_EXT, inputStream);
		}else if(null != shankDrawingno) {
			// 电极握杆零件三维数模文件路径
			String TURRETSHANK3D_PATH = NimakConstantSet.TURRETSHANK3D_PATH;
			System.out.println(TURRETSHANK3D_PATH);
			String filePath = TURRETSHANK3D_PATH + shankDrawingno + COMPONENT_EXT;
			// 获取到对应的InputStream
			System.out.println("即将下载钳臂部件三维数模文件" + filePath);
			logger.info("即将下载钳臂部件三维数模文件===" + filePath);
			
			File file = new File(filePath);
			if (!file.exists()) {
				logger.info("文件不存在===" + filePath);
				return null;
			}
			InputStream inputStream = new FileInputStream(filePath);
			// 返回一个供下载文件的文件名
			return new DownloadFile(shankDrawingno+COMPONENT_EXT, inputStream);
		}
		return null;

	}
	

	/**
	 * 按钮直接绑定downloadaction实现下载功能，出现问题
	 * 
	 * @param parameter
	 * @return
	 * @throws IOException
	 */
	@FileProvider
	public DownloadFile download3DModel(String parameter) throws IOException {
		int last = parameter.lastIndexOf("\\");
		String fileName = parameter.substring(last + 1);
		String filePath = parameter.substring(0, last + 1);
		System.out.println(fileName);
		System.out.println(filePath);
		// 获取到对应的InputStream
		InputStream inputStream = new FileInputStream(filePath);
		// 返回一个供下载文件的文件名
		return new DownloadFile(fileName, inputStream);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Expose
	public Map downloadt(String path) {
		System.out.println(path);
		int last = path.lastIndexOf("\\");
		String fileName = path.substring(last + 1);
		Map result = new HashMap();
		result.put("path", path);
		result.put("filename", fileName);
		return result;
	}
	
	
	/*public DownloadFile batchDownloadFile(File[] files) {
		//生成的ZIP文件名为Demo.zip    
        String tmpFileName = "Demo.zip";    
        byte[] buffer = new byte[1024];    
        String strZipPath = "FilePath" + tmpFileName;
        try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(    
			        strZipPath)); 
			for (int i = 0; i < files.length; i++) {    
			    FileInputStream fis = new FileInputStream(files[i]);    
			    out.putNextEntry(new ZipEntry(files[i].getName()));    
			    //设置压缩文件内的字符编码，不然会变成乱码    
			    out.setEncoding("GBK");    
			    int len;    
			    // 读入需要下载的文件的内容，打包到zip文件    
			    while ((len = fis.read(buffer)) > 0) {    
			        out.write(buffer, 0, len);    
			    }    
			    out.closeEntry();    
			    fis.close();    
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		return null;
	}
*/
	/**
	 * 批量下载文件，实现思路，创建临时文件zip，然后作为输入流下载，下载成功后删除该临时文件
	 * @param files： 要打包的文件列表
	 * @param fileName : 打包下载显示的文件名称
	 * @return
	 */
	public DownloadFile batchDownloadFile(List<File> files,String fileName) {
		logger.info("开始正在打包文件======");
		//生成的ZIP文件名为随机    
        String strZipPath = NimakConstantSet.TEMPDATA_PATH + fileName;
        logger.info("打包文件名======"+strZipPath);
        
        // 打包文件
        ZipOutputStream out = null;
        try {
        	out = new ZipOutputStream(new FileOutputStream(    
			        strZipPath)); 
        	out.setEncoding("GBK");
        	try {
				ZipUtil.zipFile(files, out);
			} catch (ServletException e) {
				e.printStackTrace();
			}    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        // 将打包好的文件返回
        try {
			return new DownloadFile(fileName, new FileInputStream(strZipPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.info("服务器打包临时文件没有成功生成！");
			e.printStackTrace();
		}
		return null;
	}
}
