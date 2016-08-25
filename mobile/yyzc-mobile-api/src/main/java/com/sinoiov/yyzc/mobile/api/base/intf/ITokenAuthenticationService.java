package com.sinoiov.yyzc.mobile.api.base.intf;

import com.sinoiov.yyzc.mobile.api.bean.common.TokenRsult;




public interface ITokenAuthenticationService {
	
	public TokenRsult validateTokenId(String tokenId);
	
}
