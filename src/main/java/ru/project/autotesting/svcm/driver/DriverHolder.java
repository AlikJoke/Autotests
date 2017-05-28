package ru.project.autotesting.svcm.driver;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.collect.Maps;

import ru.project.autotesting.svcm.properies.Properties;
import ru.project.autotesting.svcm.properies.impl.PropertiesImpl;
import ru.project.autotesting.svcm.utils.Constants;

public class DriverHolder {

	private ConcurrentMap<Integer, WebDriver> drivers;
	private Properties props = new PropertiesImpl();

	private static AtomicReference<DriverHolder> instance = new AtomicReference<>();

	private DriverHolder() {
		drivers = Maps.newConcurrentMap();
		props.setProperty(Constants.DRIVER_PROPERTY_NAME, Constants.DRIVER_PATH);
	}

	public static WebDriver getDriver(Integer thread) {
		WebDriver driver = getDrivers().get(thread);
		if (getDrivers().get(thread) == null) {
			synchronized (DriverHolder.class) {
				if (getDrivers().get(thread) == null) {
					getDrivers().putIfAbsent(thread, driver = new InternetExplorerDriver());
				}
			}
		}
		return driver;
	}

	private static ConcurrentMap<Integer, WebDriver> getDrivers() {
		DriverHolder holder = instance.get();
		if (holder == null)
			instance.compareAndSet(null, new DriverHolder());

		return instance.get().drivers;
	}
}