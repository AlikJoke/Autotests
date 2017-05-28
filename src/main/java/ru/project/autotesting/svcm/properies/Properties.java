package ru.project.autotesting.svcm.properies;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.core.env.Environment;

/**
 * Интерфейс для получения свойств из файлов конфигурации.
 * 
 * @author Alimurad A. Ramazanov
 * @since 28.05.2017
 * @version 1.0.0
 *
 */
public interface Properties {

	/**
	 * Получение некоторого свойства по имени.
	 * <p>
	 * 
	 * @see Environment
	 * @param name
	 *            - имя свойства, не может быть {@code null}.
	 * @return свойство, может быть {@code null}.
	 */
	@Null
	String getProperty(@NotNull String name);

	/**
	 * Установка системного свойства.
	 * <p>
	 * 
	 * @see {@linkplain System#setProperty(String, String)}.
	 * @param name
	 *            - имя свойства, не может быть {@code null}.
	 * @param value
	 *            - значение свойства, может быть {@code null}.
	 */
	void setProperty(@NotNull String name, @Null String value);
}
