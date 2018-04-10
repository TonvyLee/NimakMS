package com.nimak.utils;

import org.apache.commons.lang.StringUtils;
import org.hsqldb.lib.StringUtil;

public class NimakStringUtils {
	
	/**
	 * 为oldString添加相同字符串，做特殊处理
	 * @param oldString
	 * @param addedString
	 * @return
	 */
	public static String AddCharToBothSides(String oldString,String addedString) {
		return addedString+oldString+addedString;		
	}

	
	
}
