package ru.project.autotesting.svcm.activity;

/**
 * Базовый интерфейс для различных автотестов.
 * 
 * @author Alimurad A. Ramazanov
 * @since 28.05.2017
 * @version 1.0.0
 *
 */
public interface Activity {

	/**
	 * Выполнение некоторой операции.
	 * <p>
	 * 
	 * @see WebDriver
	 * @see WebElement
	 * @param threadNumber
	 *            - номер потока, работающий с текущим экземпляром реализации
	 *            {@link Activity}.
	 * @throws InterruptedException
	 */
	void execute(int threadNumber) throws InterruptedException;
}
