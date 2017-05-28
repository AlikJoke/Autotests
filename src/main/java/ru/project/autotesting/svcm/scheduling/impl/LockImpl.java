package ru.project.autotesting.svcm.scheduling.impl;

import org.springframework.stereotype.Component;

import ru.project.autotesting.svcm.scheduling.Lock;

@Component
public class LockImpl implements Lock {

	private Object lock;

	@Override
	public boolean isLocked() {
		return this.lock != null;
	}

	@Override
	public void lock() {
		this.lock = new Object();
	}

	@Override
	public void unlock() {
		this.lock = null;
	}
}
