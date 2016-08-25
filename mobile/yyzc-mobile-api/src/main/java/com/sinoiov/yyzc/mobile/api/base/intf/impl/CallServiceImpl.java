package com.sinoiov.yyzc.mobile.api.base.intf.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

import com.alibaba.fastjson.JSON;
import com.ctfo.util.DateUtil;
import com.sinoiov.yyzc.common.exception.ClientException;
import com.sinoiov.yyzc.common.log.LogServiceUtils;
import com.sinoiov.yyzc.common.utils.MD5Utils;
import com.sinoiov.yyzc.common.utils.PropertyUtils;
import com.sinoiov.yyzc.common.utils.RandomUtil;
import com.sinoiov.yyzc.mobile.api.base.intf.ICallService;
import com.sinoiov.yyzc.mobile.api.base.intf.IJsonService;
import com.sinoiov.yyzc.mobile.api.base.intf.ITokenAuthenticationService;
import com.sinoiov.yyzc.mobile.api.bean.common.Body;
import com.sinoiov.yyzc.mobile.api.bean.common.ErrorMsgConstants.Common;
import com.sinoiov.yyzc.mobile.api.bean.common.Head;
import com.sinoiov.yyzc.mobile.api.bean.common.MobileApiLog;
import com.sinoiov.yyzc.mobile.api.bean.common.Parameter;
import com.sinoiov.yyzc.mobile.api.bean.common.TokenRsult;

public class CallServiceImpl implements ICallService,InitializingBean {
	
	protected static final Log log = LogFactory.getLog(CallServiceImpl.class);
	
	private Map<String, IJsonService> services;
	
	private String tokenValidateUrl;
	
	private String charset;
	
	private String tempLocation;
	
	private String fileMaxSize;
	
	private String signCut;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(charset)) {
			charset = "UTF-8";
		}
		if(StringUtils.isBlank(tempLocation)) {
			tempLocation = "/tmp/file/";
		}
		if(StringUtils.isBlank(fileMaxSize)) {
			fileMaxSize = "3145728";
		}
		if(StringUtils.isBlank(getSignCut())) {
			signCut = "5";
		}
	}
	
	@Override
	public String call(HttpServletRequest req) {
		String request = "";
		String response = "";
		String commond = "";
		String status = "failed";
		String fileLog = "";
		String tokenId="";
		List<File> files = null;
		Parameter result = new Parameter();
		Parameter param = new Parameter();
		Head head = new Head();
		Body body = null;
		try{
			Map<String, Object> argsMap = this.getParam(req);
			if(argsMap.get("param") == null){
				throw new ClientException("BASE000001", Common.BASE000001);
			}
			
			if(argsMap.get("param") != null) {
				request = getBase64Decode(argsMap.get("param").toString());
				param = convertJsonToParameter(request.trim());
			}
			if(argsMap.get("file") != null) {
				files = (List<File>) argsMap.get("file");
				for(File file : files) {
					fileLog += file.getName() + "|";
				}
			}
			
			log.info(">>>>>>>>>>>>>>>>>>>>>>>> 接收到的客户端参数为：" + "【" + request + "】，【" + fileLog + "】  <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			
			commond = param.getHead().getServerCode();
			if(!this.validateSign(request, param.getSign())){
				throw new ClientException("BASE000002", Common.BASE000002);
			}
			tokenId=param.getHead().getToken();
			if(StringUtils.isNotBlank(tokenValidateUrl) && !this.validateToken(tokenId)){
				throw new ClientException("BASE000009", Common.BASE000009);
			}
			IJsonService service = services.get(commond);
			if (service == null) {
				throw new ClientException("BASE000003", Common.BASE000003);
			}
			param = service.convertParameter(request);
			param.setFiles(files);
			service.validate(param);
			body = service.execute(param);
			result.setBody(body);
			head.setStatus("success");
			head.setSequenceCode(param.getHead().getSequenceCode());
			status = "success";
		}catch (NullPointerException e) {
			log.error(e.getMessage(), e);
			head.setStatus("failed");
			head.setErrorMessage(Common.BASE000006);
		} catch (ClientException e) {
			log.error(e.getMessage(), e);
			head.setStatus("failed");
			head.setErrorMessage(e.getMessage());
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			head.setStatus("failed");
			head.setErrorMessage(Common.BASE000008);
		}finally{
			head.setRequestTime(param.getHead().getRequestTime());
			head.setResponseTime(String.valueOf(System.currentTimeMillis()));
			result.setHead(head);
			result.setSign(PropertyUtils.getValueByKey("SIGN_KEY"));
			response = JSON.toJSONString(result);
			
			String newSign = MD5Utils.getDefaultMd5String(response) + RandomUtil.createRandom(Integer.valueOf(signCut));
			result.setSign(newSign);
			response = JSON.toJSONString(result);

			MobileApiLog mobileApiLog = new MobileApiLog();
			mobileApiLog.setAction(commond);
			mobileApiLog.setHandleTime(DateUtil.getDateStr(DateUtil.DEFAULT_FORMATSTR, new Date()));
			mobileApiLog.setRequest("【" + request + "】，【" + fileLog + "】");
			mobileApiLog.setResponse(response);
			mobileApiLog.setState(status);
			LogServiceUtils.saveLog(mobileApiLog);
			this.del(tempLocation);
		}
		return Base64.encodeBase64String(response.toString().getBytes(Charset.forName(getCharset())));
	}
	
	private String getBase64Decode(String args){
		String decode = "";
		try {
			decode = new String(Base64.decodeBase64(args), getCharset());
			if(!StringUtils.startsWith(decode, "{") || !StringUtils.endsWith(decode, "}")){
				throw new ClientException("E000005", Common.BASE000005);
			}
		} catch (UnsupportedEncodingException e) {
			throw new ClientException("E000004", Common.BASE000004);
		}
		return decode;
	}
	
	private Parameter convertJsonToParameter(String json){
		try{
	        Parameter param = (Parameter)JSON.parseObject(json, Parameter.class);
	        return param;
		}catch(Exception e){
			throw new ClientException("E000005", Common.BASE000005);
		}
	}

	private boolean validateSign(String json, String signValue){
		try{
			String sourceStr = json.replaceAll(signValue, PropertyUtils.getValueByKey("SIGN_KEY"));
			String md5Str = MD5Utils.getDefaultMd5String(sourceStr);
			String sign = signValue.substring(0, signValue.length() - Integer.valueOf(signCut).intValue());
			if(md5Str.equalsIgnoreCase(sign)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			throw new ClientException("E000002", Common.BASE000002);
		}
	}

	private boolean validateToken(String tokenId){
		try{
			ITokenAuthenticationService tokenService = new TokenAuthenticationServiceimpl(tokenValidateUrl);
			TokenRsult tokenRsult = tokenService.validateTokenId(tokenId);
			if("success".equals(tokenRsult.getResult())){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			throw new ClientException("E000009", Common.BASE000009);
		}
	}
	
	public Map<String, IJsonService> getServices() {
		return services;
	}

	public void setServices(Map<String, IJsonService> services) {
		this.services = services;
	}

	private Map<String, Object> getParam(HttpServletRequest request) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("param", null);
		resultMap.put("file", null);
		if(FileUpload.isMultipartContent(request)) {//包含文本附件
			//查看图片的临时目录是否存在，不存在则创建
			File file = new File(getTempLocation());
			if(!file.exists() && !file.isDirectory()) {
				file.mkdirs();
			}
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setFileSizeMax(Long.valueOf(getFileMaxSize()));
			List items = fileUpload.parseRequest(request);
			Iterator it = items.iterator();
			List<File> listFiles = new ArrayList<File>();
			while(it.hasNext()){
				FileItem fileItem = (FileItem)it.next();
				if(fileItem.isFormField()){
					resultMap.put("param", new String(fileItem.getString().getBytes("ISO-8859-1"), getCharset()));//参数
				}else{
					//文本
					File newFile = new File(getTempLocation() + fileItem.getName());
					fileItem.write(newFile);
					listFiles.add(newFile);
				}
			}
			resultMap.put("file", listFiles);
		}else {//无文本附件
			resultMap.put("param", new String(request.getParameter("param").getBytes("ISO-8859-1"), getCharset()));
		}
		return resultMap;
	}
	
	public void del(String filePath){
		File f = new File(filePath);
		if(f.exists()&&f.isDirectory()){
			if(f.listFiles().length==0){
				f.delete();
			}else{
				File del[]=f.listFiles();
				int i = f.listFiles().length;
				for(int j=0;j<i;j++){
					if(del[j].isDirectory()){
						del(del[j].getAbsolutePath());
					}
					del[j].delete();
				}
			}
		}
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getTempLocation() {
		return tempLocation;
	}

	public void setTempLocation(String tempLocation) {
		this.tempLocation = tempLocation;
	}

	public String getFileMaxSize() {
		return fileMaxSize;
	}

	public void setFileMaxSize(String fileMaxSize) {
		this.fileMaxSize = fileMaxSize;
	}

	public String getSignCut() {
		return signCut;
	}

	public void setSignCut(String signCut) {
		this.signCut = signCut;
	}

	public String getTokenValidateUrl() {
		return tokenValidateUrl;
	}

	public void setTokenValidateUrl(String tokenValidateUrl) {
		this.tokenValidateUrl = tokenValidateUrl;
	}

}
