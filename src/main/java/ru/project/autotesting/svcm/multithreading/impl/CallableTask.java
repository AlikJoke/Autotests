package ru.project.autotesting.svcm.multithreading.impl;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.project.autotesting.svcm.activity.Activity;

@Component
@Lazy
@Scope("prototype")
public class CallableTask implements Callable<Integer> {

	private int threadNumber;

	@Autowired
	@Qualifier("auth")
	private Activity loginActivity;

	@Autowired
	@Qualifier("monitoring")
	private Activity monitoringActivity;

	@Autowired
	@Qualifier("atmGroupSettings")
	private Activity atmGroupActivity;

	@Autowired
	@Qualifier("monitoringGroup")
	private Activity monitoringGroupActivity;

	protected CallableTask setThreadNumber(int threadNumber) {
		this.threadNumber = threadNumber;
		return this;
	}

	protected CallableTask() {
		this.threadNumber = -1;
	}

	protected CallableTask(int threadNumber) {
		this.threadNumber = threadNumber;
	}

	@Override
	public Integer call() throws Exception {
		this.loginActivity.execute(this.threadNumber);
		this.monitoringActivity.execute(this.threadNumber);
		this.monitoringGroupActivity.execute(this.threadNumber);
		this.atmGroupActivity.execute(this.threadNumber);
		return this.threadNumber;
	}

}
