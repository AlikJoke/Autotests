package ru.project.autotesting.svcm.scheduling;

import ru.project.autotesting.svcm.multithreading.MultithreadingService;

/**
 * Интерфейс запуска периодических задач.
 * 
 * @author Alimurad A. Ramazanov
 * @since 28.05.2017
 * @version 1.0.0
 *
 */
public interface SchedulingService {

	/**
	 * Запуск периодической задачи.
	 * <p>
	 * 
	 * @see {@linkplain MultithreadingService#start(int)}
	 */
	void start();
}
