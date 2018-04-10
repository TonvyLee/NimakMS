package com.nimak.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.velocity.texen.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 设置全局变量
 * 
 * @author BUAA514
 * 
 */
public class PropertyListenter implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
	@SuppressWarnings("unchecked")
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		/**
		 * 读取properties文件 
		 */
		final Logger logger = (Logger) LoggerFactory.getLogger(PropertyListenter.class);
		Properties properties = new Properties();
		InputStream in = null;
		try {
			// 通过类加载器进行获取properties文件流
			in = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties");
			System.out.println("TEST");
			System.out.println("TEST");
			System.out.println("TEST");
			System.out.println("TEST");
			System.out.println("TEST");
			properties.load(in);
		} catch (FileNotFoundException e) {
			logger.error("未找到properties文件");
		} catch (IOException e) {
			logger.error("发生IOException异常");
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				logger.error("properties文件流关闭出现异常");
			}
		}
		/**
		 * 将properties文件转存到map
		 */
		Map<String, String> pros = new HashMap<String, String>((Map) properties);
		/**
		 * 将Map通过ServletContext存储到全局作用域中
		 */
		ServletContext sct = sce.getServletContext();
		sct.setAttribute("configprop", pros);
		Map<String, String> attribute = (Map<String, String>) sct.getAttribute("configprop");
		System.out.println(attribute.get("TURRET_PATH"));
		System.out.println("配置文件成功加载！");
	}
}
