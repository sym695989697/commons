package com.sinoiov.yyzc.mobile.client;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSON;
import com.sinoiov.yyzc.mobile.bean.Parameter;
import com.sinoiov.yyzc.mobile.utils.MD5Utils;
import com.sinoiov.yyzc.mobile.utils.RandomUtil;


public class HttpAgent {
	
	public static Parameter send(String url, Parameter param) throws Exception {
		return send(url, param, true, "UTF-8", 5, 5000);
	}
	
	public static Parameter send(String url, Parameter param, boolean getOrPost, String charset, int signCut, int timeout) throws Exception {
		HttpURLConnection conn = null;
		DataOutputStream outStream = null;
		InputStream in = null;
		String sign = param.getSign();
		try {
			List<File> files = null;
			if(param.getFiles() != null) {
				files = param.getFiles();
				param.setFiles(null);
			}
			String md5 = MD5Utils.getDefaultMd5String(JSON.toJSONString(param)) + RandomUtil.createRandom(signCut);
			System.out.println(">>>>>>>>>>>>>>>>>> 【Request】 MD5 is 【" + md5 + "】  <<<<<<<<<<<<<<<<<<<<<<<");
			param.setSign(md5);
			String base64Content = Base64.encodeBase64String(JSON.toJSONString(param).getBytes(Charset.forName(charset)));
			System.out.println(">>>>>>>>>>>>>>>>>> 【Request】BASE64 is 【" + base64Content + "】  <<<<<<<<<<<<<<<<<<<<<<<");
			
			String BOUNDARY = UUID.randomUUID().toString();
			String PREFIX = "--";
			String LINEND = "\r\n";
			String MULTIPART_FROM_DATA = "multipart/form-data";
			
			URL uri = new URL(url);
			conn = (HttpURLConnection) uri.openConnection();
			conn.setReadTimeout(timeout);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod(getOrPost == true ? "GET" : "POST");
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("Charsert", charset);
			conn.setRequestProperty("Content-Type", MULTIPART_FROM_DATA + ";boundary=" + BOUNDARY);
			
			StringBuilder sb = new StringBuilder();
			sb.append(PREFIX);
			sb.append(BOUNDARY);
			sb.append(LINEND);
			sb.append("Content-Disposition: form-data; name=\"" + "param" + "\"" + LINEND);
			sb.append("Content-Type: text/plain; charset=" + charset + LINEND);
			sb.append("Content-Transfer-Encoding: 8bit" + LINEND);
			sb.append(LINEND);
			sb.append(base64Content);
			sb.append(LINEND);
			outStream = new DataOutputStream(conn.getOutputStream());
			outStream.write(sb.toString().getBytes());
			if(files != null) {
				for(File file : files) {
					sb = new StringBuilder();
					sb.append(PREFIX);
					sb.append(BOUNDARY);
					sb.append(LINEND);
					sb.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"" + LINEND);
					sb.append("Content-Type: application/octet-stream; charset=" + charset + LINEND);
					sb.append(LINEND);
					outStream.write(sb.toString().getBytes()); 
					InputStream is = new FileInputStream(file);
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len = is.read(buffer)) != -1) {
						outStream.write(buffer, 0, len);
					}
					is.close();
					outStream.write(LINEND.getBytes());
				}
			}
			byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINEND).getBytes();
			outStream.write(end_data);
			outStream.flush();
			in = conn.getInputStream();
			int ch;
			sb = new StringBuilder();
			while ((ch = in.read()) != -1) {
				sb.append((char) ch);
			}
			System.out.println(">>>>>>>>>>>>>>>>>> 【Response】BASE64 is 【" + sb.toString() + "】  <<<<<<<<<<<<<<<<<<<<<<<");
			String decode = new String(Base64.decodeBase64(sb.toString()), charset);
			System.out.println(">>>>>>>>>>>>>>>>>> 【Response】BASE64 decode is 【" + decode + "】  <<<<<<<<<<<<<<<<<<<<<<<");
			Parameter result = (Parameter)JSON.parseObject(decode, Parameter.class);
			String localMD5 = result.getSign().substring(0, result.getSign().length() - 5);
			result.setSign(sign);
			String newMD5 = MD5Utils.getDefaultMd5String(JSON.toJSONString(result));
			if(!localMD5.equals(newMD5)) {
				System.out.println(">>>>>>>>>>>>>>>>>> 【Response】MD5不一致，返回【" + localMD5 + "】，实际【" + newMD5 + "】  <<<<<<<<<<<<<<<<<<<<<<<");
				throw new Exception(">>>>>>>>>>>>>>>>>> 【Response】MD5不一致，返回【" + localMD5 + "】，实际【" + newMD5 + "】  <<<<<<<<<<<<<<<<<<<<<<<");
			}
			
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// TODO: handle finally clause
			if(in != null) {
				in.close();
			}
			if(outStream != null) {
				outStream.close();
			}
			if(conn != null) {
				conn.disconnect();
			}
		}
	}
}
