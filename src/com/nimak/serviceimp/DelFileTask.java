package com.nimak.serviceimp;

import java.io.File;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoader;

import com.nimak.utils.NimakConstantSet;
import com.nimak.utils.NimakFileUtils;

/**
 * 定时器 
 * @author sxl
 *
 */
public class DelFileTask extends TimerTask{

    private static boolean isRunning = false;  
  
    private ServletContext context = null;  
  
    public DelFileTask() {
		super();
	}
    
    public DelFileTask(ServletContext context) {  
        this.context = context;  
    }  
	@Override
	public void run() {
		
        if (!isRunning) {
        	 
        	context.log("开始执行指定任务"); 
        	/**
        	 * 自己的业务代码
        	 */
        	System.out.println("开始删除文件！");
        	
        	String tempDataPath = ContextLoader
        			.getCurrentWebApplicationContext().getServletContext()
        			.getRealPath("/").replaceAll("\\\\", "/")+File.separator+
        			"TempData/";
        	boolean flag = delAllFile(tempDataPath);
        	if (true == flag) {
				System.out.println("临时文件删除成功！");
			}
        	
	        isRunning = false;  
	        context.log("指定任务执行结束");
        } else {  
            context.log("上一次任务执行还未结束");  
     }
	}
	
	
	public  boolean delAllFile(String path) {
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
	public  void delFolder(String folderPath) {
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
	
	

}
