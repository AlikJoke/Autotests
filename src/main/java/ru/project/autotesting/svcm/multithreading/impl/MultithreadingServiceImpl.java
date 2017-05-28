package ru.project.autotesting.svcm.multithreading.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.project.autotesting.svcm.multithreading.MultithreadingService;

@Service
public class MultithreadingServiceImpl implements MultithreadingService {

	@Autowired
	private ObjectFactory<CallableTask> tasks;

	@Override
	public void start(int threadNumber) {
		if (threadNumber < 1)
			throw new IllegalArgumentException("Number of threads can't be less than 1");

		ExecutorService service = Executors.newFixedThreadPool(threadNumber);
		for (int i = 0; i < threadNumber; i++)
			service.submit(tasks.getObject().setThreadNumber(i));
	}

	@Override
	public void sleep() throws InterruptedException {
		this.sleep(5);
	}

	@Override
	public void sleep(float seconds) throws InterruptedException {
		int roundSeconds = Math.round(seconds);
		if (roundSeconds < 0)
			throw new IllegalArgumentException("Number of seconds can't < 0");

		Thread.sleep(roundSeconds * 1000);
	}

}
