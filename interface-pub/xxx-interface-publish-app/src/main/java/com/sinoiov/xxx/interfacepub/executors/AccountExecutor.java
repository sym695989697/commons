package com.sinoiov.xxx.interfacepub.executors;

import com.sinoiov.basic.interfacepub.annotations.ExecutorCode;
import com.sinoiov.basic.interfacepub.annotations.ExecutorMethodCode;
import com.sinoiov.basic.interfacepub.beans.common.Param;
import com.sinoiov.basic.interfacepub.executor.IExecutor;

@ExecutorCode("10001")
public class AccountExecutor implements IExecutor {

	@Override
	public Param execute(Param param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(Param param) {
		// TODO Auto-generated method stub

	}
	
	@ExecutorMethodCode("01")
	public Param transMoney(Param param){
		
		return null;
	}

}
