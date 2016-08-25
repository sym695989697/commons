package com.ctfo.upp.baseservice.impl;

import com.ctfo.base.intf.internal.SecretKeyManager;
import com.ctfo.upp.baseservice.utils.SecretUtils;
import com.ctfo.upp.exception.UPPException;

public class SecretKeyManagerImpl  implements SecretKeyManager {
	
	/***
	 * 根据UUID生成一个随机密钥
	 */
	@Override
	public String generateSecretKey() throws UPPException {
		return SecretUtils.encryptSHA1();
	}

}
