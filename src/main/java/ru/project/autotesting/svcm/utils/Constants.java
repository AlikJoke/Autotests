package ru.project.autotesting.svcm.utils;

/**
 * Класс, содержащий различные константы для работы через Selenium API (DOM id,
 * URL страниц и т.д.).
 * 
 * @author Alimurad A. Ramazanov
 * @since 27.05.2017
 * @version 1.0.0
 *
 */
public class Constants {

	// захардкодим пока
	public final static String START_PAGE = "http://localhost:7001/SVCM/login.xhtml";
	public final static String DRIVER_PATH = "C:\\Users\\qqqqq\\Documents\\iedriver\\IEDriverServer.exe";
	public final static String DRIVER_PROPERTY_NAME = "webdriver.ie.driver";

	public class LoginConstants {

		public final static String USER_NAME = "admin";
		public final static String USER_PWD = "admin1";

		public final static String LOGIN_FORM = "loginForm:login";
		public final static String PASSWORD_FORM = "loginForm:password";
		public final static String LOGIN_BUTTON_FORM = "loginForm:loginButton";
	}

	public class MonitoringConstants {

		public final static String FILTER_GROUPS = "filterform:selectedGroup:overlayToggle";
		public final static String SELECT_ALL_GROUPS = "filterform:selectedGroup:selectTable:j_idt91";
		public final static String BTN_FILTER_GROUPS = "filterform:selectedGroup:selectTable:submitGroupFilterButton";
		public final static String BTN_SEARCH = "filterform:searchButton";
	}
}
