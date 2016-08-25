package com.ctfo.upp.baseservice.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctfo.base.dao.beans.AuthInfo;
import com.ctfo.base.dao.beans.UPPlatform;
import com.ctfo.base.dao.beans.UPPlatformCallbackUrl;
import com.ctfo.base.dao.beans.UPPlatformCallbackUrlExampleExtended;
import com.ctfo.base.dao.beans.UPPlatformExampleExtended;
import com.ctfo.base.intf.internal.PlatformRegisterManager;
import com.ctfo.base.intf.internal.SecretKeyManager;
import com.ctfo.upp.exception.UPPException;
import com.ctfo.upp.models.Paginator;
import com.ctfo.upp.support.UppGenericManagerImpl;
import com.ctfo.upp.utils.UUIDUtil;
/***
 * 平台注册管理service处理类
 * @author liugz
 *
 */
public class PlatformRegisterManagerImpl extends UppGenericManagerImpl<Object, Object> implements PlatformRegisterManager{
	
	private static Log logger = LogFactory.getLog(PlatformRegisterManagerImpl.class);
	private SecretKeyManager secretKeyManager;
	/***
	 * 注册接入平台，返回秘钥和分配的唯一ID
	 * @param platform 平台信息实体
	 * @return
	 * @throws UPPException
	 */
	@Override
	public AuthInfo register(UPPlatform platform) throws UPPException {
		AuthInfo info=null;
		if(platform==null){
			throw new UPPException("platform is null");
		}
		try {
			platform.setId(UUIDUtil.newUUID());
			platform.setStoreCode(UUIDUtil.newUUID());
			platform.setPrivateKey(secretKeyManager.generateSecretKey());
			//保存DB
			this.addModel(platform);
			info=new AuthInfo(platform.getStoreCode(), platform.getPrivateKey());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return info;
	}

	@Override
	public void modifyRegisterPlatform(UPPlatform platform) throws UPPException {
		//判断条件
		try {
			super.updateObjAll(platform);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public void removeRegisterPlatform(String uuid) throws UPPException {
		try {
			UPPlatform platform=new UPPlatform();
			platform.setId(uuid);
			this.removeModel(platform);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public UPPlatform getRegPlatformById(String uuid) throws UPPException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paginator<UPPlatform> queryRegPlatformByPage(
			UPPlatformExampleExtended exampleExtended) throws UPPException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UPPlatform> queryRegisterPlatform(
			UPPlatformExampleExtended exampleExtended) throws UPPException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UPPlatformCallbackUrl addCallbackURL(
			UPPlatformCallbackUrl platformCallbackUrl) throws UPPException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyCallbackURL(UPPlatformCallbackUrl callbackPlatformURL)
			throws UPPException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCallbackURL(String uuid) throws UPPException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UPPlatformCallbackUrl> queryCallbackURL(
			UPPlatformCallbackUrlExampleExtended exampleExtended)
			throws UPPException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UPPlatformCallbackUrl getCallbackURLById(String callbackURLUUID)
			throws UPPException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paginator<UPPlatformCallbackUrl> queryCallbackURLByPage(
			UPPlatformCallbackUrlExampleExtended exampleExtended)
			throws UPPException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public SecretKeyManager getSecretKeyManager() {
		return secretKeyManager;
	}

	public void setSecretKeyManager(SecretKeyManager secretKeyManager) {
		this.secretKeyManager = secretKeyManager;
	}
}
