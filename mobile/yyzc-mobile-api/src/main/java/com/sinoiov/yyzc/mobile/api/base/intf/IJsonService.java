package com.sinoiov.yyzc.mobile.api.base.intf;

import com.sinoiov.yyzc.common.exception.ClientException;
import com.sinoiov.yyzc.mobile.api.bean.common.Body;
import com.sinoiov.yyzc.mobile.api.bean.common.Parameter;

public interface IJsonService {

	/**
	 * 执行服务
	 * 
	 * @param Json对象
	 * @return
	 * @throws ClientException
	 */
	public Body execute(Parameter request) throws ClientException;

	/**
	 * 校验业务数据合法性
	 * 
	 * @param request
	 */
	void validate(Parameter request) throws ClientException;

	/**
	 * 根据不同的command转换成不同的Body对象
	 * 
	 * @param request
	 */
	Parameter convertParameter(String request);

}
