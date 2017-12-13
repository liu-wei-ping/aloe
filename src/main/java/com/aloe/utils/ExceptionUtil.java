package com.aloe.utils;

import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * 异常处理工具类
 * 
 * @author liu wp
 * @date 2017年9月27日
 */
public class ExceptionUtil {

	/**
	 * 获取异常的堆栈信息
	 *
	 * @param t
	 * @return
	 */
	public static String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		try {
			try {
				t.printStackTrace(pw);
			} catch (Exception e) {
			}
			return sw.toString();
		} finally {
			pw.close();
		}
	}
}
