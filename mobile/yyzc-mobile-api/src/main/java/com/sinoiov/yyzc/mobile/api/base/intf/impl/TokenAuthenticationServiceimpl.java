package com.sinoiov.yyzc.mobile.api.base.intf.impl;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.sinoiov.yyzc.common.utils.HttpUtil;
import com.sinoiov.yyzc.common.utils.PropertyUtils;
import com.sinoiov.yyzc.mobile.api.base.intf.ITokenAuthenticationService;
import com.sinoiov.yyzc.mobile.api.bean.common.TokenRsult;


/**
 * 验证tokenId
 * @author dxs
 *
 */
@Service("tokenAuthenticationService")
public class TokenAuthenticationServiceimpl implements ITokenAuthenticationService {
	
	private static Log logger = LogFactory.getLog(TokenAuthenticationServiceimpl.class);
	
	private String uaaURL;
	
	public TokenAuthenticationServiceimpl(String tokenValidateUrl) {
		this.uaaURL = tokenValidateUrl;
	}

	public TokenRsult validateTokenId(String tokenId) {
		try{
			String result = HttpUtil.sendHttpPostResquest(uaaURL, "tokenId="+ tokenId);
			logger.info(String.format("tokenId=%s验证结果为%s", tokenId , result));
			TokenRsult uaaTokenRsult = (TokenRsult) JSONObject.toBean(JSONObject.fromObject(result),TokenRsult.class);
			return uaaTokenRsult;
		}catch(Exception e){
			logger.error("验证tokenId异常",e);
		}
		return null;
	}
}
