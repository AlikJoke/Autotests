package ru.project.autotesting.svcm.multithreading.impl;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import ru.project.autotesting.svcm.multithreading.MultithreadingService;
import ru.project.autotesting.svcm.scheduling.Lock;

@Service
public class MultithreadingServiceImpl implements MultithreadingService {

	@Autowired
	private ObjectFactory<CallableTask> tasks;

	@Autowired
	private Lock lock;

	@Override
	public void start(int threadNumber) {
		if (threadNumber < 1)
			throw new IllegalArgumentException("Number of threads can't be less than 1");

		lock.lock();

		ExecutorService service = Executors.newFixedThreadPool(threadNumber);
		List<Future<Integer>> futures = Lists.newArrayList();
		for (int i = 0; i < threadNumber; i++)
			futures.add(service.submit(tasks.getObject().setThreadNumber(i)));

		while (true) {
			if (futures.stream().filter(task -> !task.isDone()).count() == 0) {
				lock.unlock();
				break;
			}
		}
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
