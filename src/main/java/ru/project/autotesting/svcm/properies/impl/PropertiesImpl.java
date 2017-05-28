package ru.project.autotesting.svcm.properies.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import ru.project.autotesting.svcm.properies.Properties;

@Component
@PropertySource(value = { "classpath:application.properties" })
public class PropertiesImpl implements Properties {

	@Autowired
	private Environment env;

	@Override
	public String getProperty(String name) {
		return env.getProperty(name);
	}

	@Override
	public void setProperty(String name, String value) {
		System.setProperty(name, value);
	}

}
