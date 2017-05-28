package ru.project.autotesting.svcm.monitoring;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ru.project.autotesting.svcm.activity.Activity;
import ru.project.autotesting.svcm.driver.DriverHolder;
import ru.project.autotesting.svcm.multithreading.MultithreadingService;
import ru.project.autotesting.svcm.utils.Constants;

@Service("monitoring")
@Scope("prototype")
public class MonitoringATMActivity implements Activity {

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
		driver.get(Constants.MonitoringConstants.MONITORING_ATM_NAME);
		
		while (true) {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			/*
			element = (new WebDriverWait(driver, 15)).until(ExpectedConditions
					.presenceOfElementLocated(By.id(Constants.MonitoringConstants.SELECT_ALL_GROUPS)));
			 */
			element = driver.findElement(By.id(Constants.MonitoringConstants.FILTER_GROUPS));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);

			element = driver.findElement(By.id(Constants.MonitoringConstants.SELECT_ALL_GROUPS));
			element.click();
			
			element = driver.findElement(By.id(Constants.MonitoringConstants.BTN_FILTER_GROUPS));
			element.click();

			multiService.sleep(3);

			element = driver.findElement(By.id(Constants.MonitoringConstants.BTN_SEARCH));
			element.click();

			multiService.sleep();
			break;
		}
	}

}
