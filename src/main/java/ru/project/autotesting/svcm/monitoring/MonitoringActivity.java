package ru.project.autotesting.svcm.monitoring;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ru.project.autotesting.svcm.activity.Activity;
import ru.project.autotesting.svcm.driver.DriverHolder;
import ru.project.autotesting.svcm.multithreading.MultithreadingService;
import ru.project.autotesting.svcm.utils.Constants;

@Service("monitoring")
@Scope("prototype")
public class MonitoringActivity implements Activity {

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
		while (true) {
			element = driver.findElement(By.name(Constants.MonitoringConstants.FILTER_GROUPS));
			element.click();

			element = (new WebDriverWait(driver, 15)).until(ExpectedConditions
					.presenceOfElementLocated(By.id(Constants.MonitoringConstants.SELECT_ALL_GROUPS)));

			element = driver.findElement(By.id(Constants.MonitoringConstants.SELECT_ALL_GROUPS));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);

			element = driver.findElement(By.id(Constants.MonitoringConstants.BTN_FILTER_GROUPS));
			element.click();

			multiService.sleep(2);

			element = driver.findElement(By.id(Constants.MonitoringConstants.BTN_SEARCH));
			element.click();

			multiService.sleep(3);
		}
	}

}
