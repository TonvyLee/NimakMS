package com.nimak.serviceimp;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.h2.store.fs.FileUtils;
import org.hsqldb.lib.FileUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.core.Context;
import com.bstek.dorado.uploader.UploadFile;
import com.bstek.dorado.uploader.annotation.FileResolver;
import com.bstek.dorado.web.DoradoContext;
import com.nimak.utils.NimakConstantSet;

@Component
@Transactional
public class NimakUploadServiceImp {
	
	
	private Logger logger = Logger.getLogger(NimakUploadServiceImp.class);

	// 如果可能，会在后期为管理员添加设置上传路径
	String filePath;
	String relatedFilePath;
	String fileName;

	/**
	 * // 通过ajax设置上传文件的保存路径
	 * 
	 * @param filePath
	 *            传入的相对路径
	 */
	@Expose
	public void setFilePath(String filePath) {
		DoradoContext ctx = DoradoContext.getCurrent();
		HttpServletRequest request = ctx.getRequest();
		String path = request.getRealPath("/");
		this.filePath = path + "\\" + filePath;
		this.relatedFilePath = filePath;
		this.fileName = filePath.substring(filePath.lastIndexOf("\\") + 1,
				filePath.length());
		System.out.println(this.fileName);
		logger.info("文件名称：" + this.fileName);
		System.out.println(this.filePath);
		logger.info("文件路径：" + this.filePath);
	}

	/**
	 * // 通过ajax设置上传文件的保存路径
	 * 
	 * @param filePath
	 *            传入的相对路径
	 */
	@Expose
	public void setFilePathOfHelpDoc(String filePath) {
		DoradoContext ctx = DoradoContext.getCurrent();
		HttpServletRequest request = ctx.getRequest();
		String path = request.getRealPath("/");
		System.out.println(path);
		logger.info("帮助文档文件路径：" + path);
		this.filePath = path + "\\" + filePath;
		this.relatedFilePath = filePath;
		this.fileName = "help";
		System.out.println(this.fileName);
		logger.info("文件名称：" + this.fileName);
		System.out.println(this.filePath);
		logger.info("文件路径：" + this.filePath);
	}

	// 设置存储路径
	private String setDestPath(String destPath) {
		System.setProperty("java.io.tmpdir", destPath);
		return System.getProperty("java.io.tmpdir");
	}

	// 上传函数
	/**
	 * 上传钳体三维数模文件方法
	 * 
	 * @param file
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@FileResolver
	public Map<String, String> uploadTurretFile(UploadFile file,
			Map<String, Object> parameter) throws Exception {
		// 上传文件原始名称
		String fileOldName = new String(file.getFileName()
				.getBytes("iso8859-1"), "UTF-8");
		// 判断上传文件类型标志
		String fileTag = (String)parameter.get("tag");
		// 上传文件应有的名称
		String fileNameCustomString = (String) parameter.get("gunDrawingno");

		Map<String, String> data = new HashMap<String, String>();
		

		if (!"null".equals(fileNameCustomString)
				&& StringUtils.isNotEmpty(fileNameCustomString)) {
			// 设置文件名称
			String str = new String(
					(fileNameCustomString + fileOldName.substring(fileOldName
							.lastIndexOf("."))).getBytes("iso8859-1"), "UTF-8");

			// 上传后文件表达
			File destFile = null;
			if ("upload2DDrawing".equals(fileTag)) {
				System.out.println("upload2dDrawing");
				logger.info("判断上传文件时三维数模还是二位图纸，flag=" + fileTag);
				destFile = getDestFile(str, new File(
						setDestPath(NimakConstantSet.TURRET2D_PATH)));
			}
			if ("uploadDrawing".equals(fileTag)){
				System.out.println("upload2dDrawing");
				logger.info("判断上传文件时三维数模还是二位图纸，flag=" + fileTag);
				destFile = getDestFile(str, new File(
						setDestPath(NimakConstantSet.TURRET3D_PATH)));
			}
					
			if (destFile != null) {
				try {
					file.transferTo(destFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				data.put("fileName",
						URLEncoder.encode(destFile.getName(), "UTF-8"));
				data.put("absolutePath",
						URLEncoder.encode(destFile.getAbsolutePath(), "UTF-8"));
				data.put("relatedPath",
						URLEncoder.encode(destFile.getPath(), "UTF-8"));
			}else {
				data.put("returnValue", "E_Fail");
			}
		} else {
			data.put("returnValue", "E_Fail");
		}
		return data;
	}
	
	
	
	/**
	 * 上传钳体三维数模文件方法
	 * 
	 * @param file
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@FileResolver
	public Map<String, String> uploadTurretComponentFile(UploadFile file,
			Map<String, Object> parameter) throws Exception {
		
		// 上传文件原始名称
		String fileOldName = new String(file.getFileName()
				.getBytes("iso8859-1"), "UTF-8");
		// 判断上传文件类型标志
		String fileTag = (String)parameter.get("tag");
		// 上传文件应有的名称
		String fileNameCustomString = (String) parameter.get("armAssemblyno");

		Map<String, String> data = new HashMap<String, String>();

		if (!"null".equals(fileNameCustomString)
				&& StringUtils.isNotEmpty(fileNameCustomString)) {
			// 设置文件名称
			String str = new String(
					(fileNameCustomString + fileOldName.substring(fileOldName
							.lastIndexOf("."))).getBytes("iso8859-1"), "UTF-8");

			// 上传后文件表达
			File destFile = null;
			if ("upload2DDrawing".equals(fileTag)) {
				System.out.println("upload2dDrawing");
				logger.info("判断上传文件时三维数模还是二位图纸，flag=" + fileTag);
				destFile = getDestFile(str, new File(
						setDestPath(NimakConstantSet.TURRETCOMPONENT2D_PATH)));
			}
			if ("uploadDrawing".equals(fileTag)){
				destFile = getDestFile(str, new File(
						setDestPath(NimakConstantSet.TURRETCOMPONENT3D_PATH)));
			}
					
			if (destFile != null) {
				try {
					file.transferTo(destFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				data.put("fileName",
						URLEncoder.encode(destFile.getName(), "UTF-8"));
				data.put("absolutePath",
						URLEncoder.encode(destFile.getAbsolutePath(), "UTF-8"));
				data.put("relatedPath",
						URLEncoder.encode(destFile.getPath(), "UTF-8"));
			}else {
				data.put("returnValue", "E_Fail");
			}
		} else {
			data.put("returnValue", "E_Fail");
		}
		return data;
	}
	
	
	/**
	 * 上传电极握杆组件或者零件的二维图或者三维数模
	 * @param file
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@FileResolver
	public Map<String, String> uploadShankFile(UploadFile file,
			Map<String, Object> parameter) throws Exception {
		logger.info("开始上传shank文件！");
		// 上传文件原始名称
		
		String fileOldName = new String(file.getFileName()
				.getBytes("iso8859-1"), "UTF-8");
		// 判断上传文件类型标志，三维数模或者二维图纸
		String fileTag = (String)parameter.get("tag");
		// 上传文件应有的名称，将文件名称设置为零件图号
		String fileNameCustomString = (String) parameter.get("shankDrawingno");

		Map<String, String> data = new HashMap<String, String>();

		if (!"null".equals(fileNameCustomString)
				&& StringUtils.isNotEmpty(fileNameCustomString)) {
			// 设置文件名称
			String str = new String(
					(fileNameCustomString + fileOldName.substring(fileOldName
							.lastIndexOf("."))).getBytes("iso8859-1"), "UTF-8");

			// 上传后文件表达
			File destFile = null;
			if ("upload2DDrawing".equals(fileTag)) {
				System.out.println("upload2dDrawing");
				destFile = getDestFile(str, new File(
						setDestPath(NimakConstantSet.TURRETSHANK2D_PATH)));
			}
			if ("uploadDrawing".equals(fileTag)){
				destFile = getDestFile(str, new File(
						setDestPath(NimakConstantSet.TURRETSHANK3D_PATH)));
			}
					
			if (destFile != null) {
				try {
					file.transferTo(destFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				data.put("fileName",
						URLEncoder.encode(destFile.getName(), "UTF-8"));
				data.put("absolutePath",
						URLEncoder.encode(destFile.getAbsolutePath(), "UTF-8"));
				data.put("relatedPath",
						URLEncoder.encode(destFile.getPath(), "UTF-8"));
			}else {
				data.put("returnValue", "E_Fail");
			}
		} else {
			data.put("returnValue", "E_Fail");
		}
		return data;
	}
	
	/**
	 * 上传钳臂组件或者零件的二维图或者三维数模
	 * @param file
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@FileResolver
	public Map<String, String> uploadTurretArmFile(UploadFile file,
			Map<String, Object> parameter) throws Exception {
		logger.info("开始上传钳臂组件或者零件文件！\n");
		
		// 上传文件原始名称		
		String fileOldName = new String(file.getFileName()
				.getBytes("iso8859-1"), "UTF-8");
		
		// 判断上传文件类型标志，三维数模或者二维图纸
		String fileTag = (String)parameter.get("tag");
		
		// 上传文件应有的名称，将文件名称设置为零件图号
		String fileNameCustomString = (String) parameter.get("armDrawingno");

		Map<String, String> data = new HashMap<String, String>();

		if (!"null".equals(fileNameCustomString)
				&& StringUtils.isNotEmpty(fileNameCustomString)) {
			// 设置文件名称
			String str = new String(
					(fileNameCustomString + fileOldName.substring(fileOldName
							.lastIndexOf("."))).getBytes("iso8859-1"), "UTF-8");

			// 上传后文件表达
			File destFile = null;
			if ("upload2DDrawing".equals(fileTag)) {
				System.out.println("upload2dDrawing");
				destFile = getDestFile(str, new File(
						setDestPath(NimakConstantSet.TURRETARM2D_PATH)));
			}
			if ("uploadDrawing".equals(fileTag)){
				destFile = getDestFile(str, new File(
						setDestPath(NimakConstantSet.TURRETARM3D_PATH)));
			}
					
			if (destFile != null) {
				try {
					file.transferTo(destFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				data.put("fileName",
						URLEncoder.encode(destFile.getName(), "UTF-8"));
				data.put("absolutePath",
						URLEncoder.encode(destFile.getAbsolutePath(), "UTF-8"));
				data.put("relatedPath",
						URLEncoder.encode(destFile.getPath(), "UTF-8"));
			}else {
				data.put("returnValue", "E_Fail");
			}
		} else {
			data.put("returnValue", "E_Fail");
		}
		
		logger.info("完成上传钳臂组件或者零件文件！\n");
		return data;
	}
	
	
	
	
	
	

	// 获取文件，必须的
	@SuppressWarnings("unused")
	private File getDestFile1(String fileName, File folder) {
		File destFile;
		try {
			fileName.getBytes("iso8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!new File(folder, fileName).exists()) {
			destFile = new File(folder, fileName);
		} else {
			int i = 1, lastDotPos = fileName.lastIndexOf("."), len = fileName
					.length();
			String prefix = null, suffix = null, destFileName;
			//
			if (lastDotPos == len - 1 || lastDotPos == -1) {
				prefix = fileName;
				suffix = "";
			} else if (lastDotPos != -1) {
				prefix = fileName.substring(0, lastDotPos);
				suffix = fileName.substring(lastDotPos + 1);
			}
			do {
				if (suffix.length() == 0) {
					destFileName = String.format("%s_%d", prefix, i++);
				} else {
					destFileName = String.format("%s_%d.%s", prefix, i++,
							suffix);
				}
				destFile = new File(folder, destFileName);
			} while (destFile.exists());
		}
		FileUtils.createDirectory(destFile.getParent());
		//FileUtil.makeDirectories(destFile.getParent());
		return destFile;
	}

	// 直接覆盖源文件
	private File getDestFile(String fileName, File folder) {
		File destFile;
		try {
			fileName.getBytes("iso8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		destFile = new File(folder, fileName);
		FileUtils.createDirectory(destFile.getParent());
		//FileUtil.makeDirectories(destFile.getParent());
		
		return destFile;
	}
	
	
	// 钳臂零件三位数莫文件位置：NimakConstantSet.TURRETARM3D_PATH
	// 钳臂零件莫文件位置：NimakConstantSet.TURRETARM2D_PATH
	
	
	
	
	
	
}
