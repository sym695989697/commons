package com.sinoiov.yyzc.common.utils;

public class UUIDUtil {
	public static String newUUID() {
		return java.util.UUID.randomUUID().toString();
	}
	public static String newUUID2() {
		return newUUID().toString().replace("-", "").toUpperCase();
	}
}
