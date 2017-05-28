package ru.project.autotesting.svcm.scheduling;

/**
 * Блокировки для проверки наличия работающих потоков задач.
 * 
 * @author Alimurad A. Ramazanov
 * @since 28.05.2017
 * @version 1.0.0
 *
 */
public interface Lock {

	/**
	 * Возвращает признак наличия блокировки для задачи.
	 * <p>
	 * 
	 * @return {@code true} - если блокировки нет, {@code false} - иначе.
	 */
	boolean isLocked();

	/**
	 * Снимает блокировку запуска задач.
	 * 
	 */
	void unlock();

	/**
	 * Устанавливает блокировку для задачи.
	 */
	void lock();
}
