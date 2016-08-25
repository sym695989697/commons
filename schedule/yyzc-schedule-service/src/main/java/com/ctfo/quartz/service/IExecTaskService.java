package com.ctfo.quartz.service;

import org.quartz.Trigger;

public interface IExecTaskService {
	
	public void execTask(Trigger trigger);
}
