package com.sinoiov.yyzc.commons.mongodb.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZipUtil {
	//压缩
	public static String compress(String str) throws IOException {
		if (str == null || str.length() == 0) {
			return str;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(str.getBytes());
		gzip.close();
		return out.toString("ISO-8859-1");
	}

	//解压
	public static String uncompress(String str) throws IOException {
		if (str == null || str.length() == 0) {
			return str;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(
				str.getBytes("ISO-8859-1"));
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[256];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}
		// toString()使用平台默认编码，也可以显式的指定如toString(&quot;GBK&quot;)
		return out.toString();
	}
	
	public static void main(String[] args) {
		String str = "eyJib2R5Ijp7InB3ZCI6Ijg4ODg4OCIsInVzZXJOYW1lIjoiMTMzOTQxMTQxMTYifSwiaGVhZCI6eyJjYWxsVGltZSI6IjEzNTgyMzk5NDEyNzAiLCJzZXF1ZW5jZU51bSI6IjEwMjI3MzM1MzQ0NzExMTkwNzgiLCJzZXJ2Q29kZSI6IlMxMDAxIn0sInNpZ24iOiJmMWU5N2Y3MzYwZjcyNDBkNjAzNGMxYTBhMDdjNzdhZiJ9";
		System.out.println(str.length());
		try {
			str = GZipUtil.compress(str);
			System.out.println(str);
			System.out.println(str.length());
			str = GZipUtil.uncompress(str);
			System.out.println(str);
			System.out.println(str.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
