package com.sinoiov.basic.interfacepub.executor;

import com.sinoiov.basic.interfacepub.beans.common.Param;

public interface IExecutor {

	public Param execute(Param param);
	
	public void validate(Param param);
}
