package ru.project.autotesting.svcm.auth;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ru.project.autotesting.svcm.activity.Activity;
import ru.project.autotesting.svcm.driver.DriverHolder;
import ru.project.autotesting.svcm.multithreading.MultithreadingService;
import ru.project.autotesting.svcm.utils.Constants;

@Service("auth")
@Scope("prototype")
public class LoginActivity implements Activity {

	@Autowired
	private MultithreadingService multiService;

	@PostConstruct
	public void init() {
		if (this.multiService == null)
			throw new RuntimeException("Multithreading service isn't injected yet!");
	}

	@Override
	public void execute(int threadNumber) throws InterruptedException {
		WebElement element = null;
		WebDriver driver = DriverHolder.getDriver(threadNumber);

		driver.get(Constants.START_PAGE);

		element = driver.findElement(By.id(Constants.LoginConstants.LOGIN_FORM));
		element.sendKeys(Constants.LoginConstants.USER_NAME);

		element = driver.findElement(By.id(Constants.LoginConstants.PASSWORD_FORM));
		element.sendKeys(Constants.LoginConstants.USER_PWD);

		element = driver.findElement(By.id(Constants.LoginConstants.LOGIN_BUTTON_FORM));
		element.click();

		this.multiService.sleep();
	}

}
