package ru.project.autotesting.svcm.multithreading;

import java.util.concurrent.ExecutorService;

import ru.project.autotesting.svcm.multithreading.impl.CallableTask;

/**
 * Сервис многопоточной работы автотестов.
 * 
 * @author Alimirad A. Ramazanov
 * @since 27.05.2017
 * @version 1.0.0
 *
 */
public interface MultithreadingService {

	/**
	 * Запускает автотесты в указанном количестве потоков.
	 * <p>
	 * 
	 * @see ExecutorService
	 * @see CallableTask
	 * 
	 * @param threadNumber
	 *            - количество потоков, в котором будут запущены автотесты.
	 */
	void start(int threadNumber);

	/**
	 * Останавливает текущий поток на 5 секунд.
	 * <p>
	 * 
	 * @see {@linkplain Thread#sleep(long)}.
	 * @throws InterruptedException
	 */
	void sleep() throws InterruptedException;

	/**
	 * Останавливает текущий поток на указанное количество секунд.
	 * <p>
	 * 
	 * @param seconds
	 *            - количество секунд, на которое поток должен прервать работу.
	 * @see {@linkplain Thread#sleep(long)}.
	 * @throws InterruptedException
	 */
	void sleep(float seconds) throws InterruptedException;
}
