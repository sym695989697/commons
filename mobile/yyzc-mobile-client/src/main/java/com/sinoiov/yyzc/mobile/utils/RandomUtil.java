package com.sinoiov.yyzc.mobile.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomUtil {
	
	/**
	 * 格式为：yyyyMMddHHmmssSSS + N位随机数
	 */
	public static String createRandomyyyyMMddHHmmssSSS(int num) {
		StringBuffer result = new StringBuffer();
		Random random = new Random();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateTime = sdf.format(new Date()).toString();
		result = result.append(dateTime);
		for (int i = 0; i < num; i++) {
			result = result.append(random.nextInt(10));
		}
		return result.toString();
	}
	
	/**
	 * 格式为：yyyyMMddHHmmss + N位随机数
	 */
	public static String createRandomyyyyMMddHHmmss(int num) {
		StringBuffer result = new StringBuffer();
		Random random = new Random();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateTime = sdf.format(new Date()).toString();
		result = result.append(dateTime);
		for (int i = 0; i < num; i++) {
			result = result.append(random.nextInt(10));
		}
		return result.toString();
	}
	
	/**
	 * 随机数字和字母组合
	 */
	public static String createRandom(int num) {
		StringBuffer result = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			if(random.nextBoolean()) {
				result = result.append((char)(97 + random.nextInt(26)));
			}else {
				result = result.append(random.nextInt(10));
			}
		}
		return result.toString();
	}
	
}
