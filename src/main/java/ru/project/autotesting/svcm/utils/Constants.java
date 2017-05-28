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

		public final static String MONITORING_ATM_NAME = "http://localhost:7001/SVCM/pages/monitoring/atmActualState.xhtml";
		public final static String MONITORING_GROUP_PAGE = "http://localhost:7001/SVCM/pages/monitoring/groupActualState.xhtml";

		public final static String SELECT_ALL_GROUP_PAGE = "filterform:selectedGroup:selectTable:j_idt84";

		public final static String FILTER_GROUPS = "filterform:selectedGroup:overlayToggle";
		public final static String SELECT_ALL_GROUPS = "filterform:selectedGroup:selectTable:j_idt123";
		public final static String BTN_FILTER_GROUPS = "filterform:selectedGroup:selectTable:submitGroupFilterButton";
		public final static String BTN_SEARCH = "filterform:searchButton";
	}

	public class Settings {

		public final static String ATM_GROUP_SETTINGS_PAGE = "http://localhost:7001/SVCM/pages/settings/atmGroup.xhtml";

		public final static String BTN_ADD_ATM_GROUP = "mainform:addGroupButton";
		public final static String GROUP_DESCX_INPUT = "groupDescriptionInput";
		public final static String GROUP_NAME_INPUT = "groupNameInput";
		public final static String SAVE_ATM_GROUP_BTN = "popupSubmitButton";
		public final static String SEARCH_GROUP_NAME_INPUT = "filterform:groupName";
		public final static String DATA_LIST_GROUP = "mainform:groupList_data";
		public final static String SEARCH_GROUPS = "filterform:searchButton";
		public final static String CLASS_CELL_EMPTY = ".ui-widget-content.ui-datatable-empty-message";
	}
}
