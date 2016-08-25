package com.ctfo.upp.baseservice.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.ctfo.upp.utils.UUIDUtil;



/***
 * 密钥工具类
 * 
 * @author liugz
 * 
 */
public class SecretUtils {
	/***
	 * 加密
	 * @return
	 */
	public static String encryptSHA1() {
		MessageDigest md = null;
		String strDes = null;
		byte[] bt =UUIDUtil.newUUID().getBytes();
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(bt);
			strDes = bytes2Hex(md.digest()); // to HexString
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Invalid algorithm.");
			return null;
		}
		return strDes.toUpperCase();
	}
	
	/***
	 * byte转16进制
	 * @param bts
	 * @return
	 */
	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}
}
