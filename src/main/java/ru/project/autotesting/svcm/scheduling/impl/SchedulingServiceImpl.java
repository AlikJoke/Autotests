package ru.project.autotesting.svcm.scheduling.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ru.project.autotesting.svcm.multithreading.MultithreadingService;
import ru.project.autotesting.svcm.scheduling.Lock;
import ru.project.autotesting.svcm.scheduling.SchedulingService;

@Service
@PropertySource(value = { "classpath:application.properties" })
public class SchedulingServiceImpl implements SchedulingService {

	@Value("${thread.number:2}")
	private int threadNumber;

	@Autowired
	private Lock lock;

	@Autowired
	private MultithreadingService multiService;

	@PostConstruct
	public void init() {
		if (this.lock == null || this.multiService == null)
			throw new RuntimeException("Beans aren't injected!");
	}

	@Override
	@Scheduled(initialDelay = 10000, fixedDelay = 300000)
	public void start() {
		if (!this.lock.isLocked())
			this.multiService.start(Integer.valueOf(this.threadNumber));
	}

}
