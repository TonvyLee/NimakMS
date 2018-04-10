package com.nimak.utils;

import java.io.File;

import com.nimak.exception.FileException;

/**
 * 文件处理工具
 * 
 * @author BUAA514
 * 
 */
public class NimakFileUtils {

	/**
	 * 根据文件路径删除文件，指的是具体的文件
	 * 
	 * @param path
	 * @return
	 * @throws FileException
	 */
	public String DeleteFileByPath(String path) throws FileException {
		if (null != path) {
			File filePathFile = new File(path);
			if (filePathFile.exists() && filePathFile.isFile()) {
				System.out.println("文件存在！");
				filePathFile.delete();
				// 删除文件父文件夹
				return "成功删除";
			} else {
				throw new FileException("删除文件不存在！");
			}
		} else {
			throw new FileException("删除文件路径为空！");
		}
	}

	/**
	 * 根据文件夹路径删除文件下素有的文件
	 * 
	 * @param directoryPath
	 *            文件夹路径
	 * @return
	 */
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 删除文件夹
	 * 
	 * @param folderPath
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取文件拓展名，根据文件名称
	 * @param filename 文件原始名称，可以一个文件路径，也可以是一个简单文件名
	 * @return
	 */
	public static String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}

	/**
	 * 根据原始文件名称，获取不带扩展名的文件名 
	 * @param filename 文件原始名称，可以一个文件路径，也可以是一个简单文件名
	 * @return
	 */
	public static String getFileNameNoEx(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length()))) {
				return filename.substring(0, dot);
			}
		}
		return filename;
	}

}
