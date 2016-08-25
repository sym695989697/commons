package com.sinoiov.yyzc.common.hessian;

import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.caucho.hessian.client.HessianProxyFactory;

public class SinoiovHessianProxyFactoryBean extends HessianProxyFactoryBean {
	
	private HessianProxyFactory proxyFactory = new HessianProxyFactory();
	
	private int readTimeOut = 10000;

    public int getReadTimeOut() {
        return readTimeOut;
    }

    public void setReadTimeOut(int readTimeOut) {
        this.readTimeOut = readTimeOut;
    }

    @Override
    public void afterPropertiesSet() {
    	super.setServiceUrl(super.getServiceUrl() + super.getServiceInterface().getName());
    	proxyFactory.setReadTimeout(readTimeOut);
        setProxyFactory(proxyFactory);
        super.afterPropertiesSet();
    }
}
