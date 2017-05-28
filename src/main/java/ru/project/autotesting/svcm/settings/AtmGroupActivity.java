package ru.project.autotesting.svcm.settings;

import java.util.UUID;

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

@Service("atmGroupSettings")
@Scope("prototype")
public class AtmGroupActivity implements Activity {

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

		String name = null;

		driver.get(Constants.Settings.ATM_GROUP_SETTINGS_PAGE);
		multiService.sleep();

		while (true) {

			name = Integer.toHexString(UUID.randomUUID().hashCode());

			element = driver.findElement(By.id(Constants.Settings.SEARCH_GROUP_NAME_INPUT));
			element.clear();
			element.sendKeys(name);

			element = driver.findElement(By.id(Constants.Settings.SEARCH_GROUPS));
			element.click();

			multiService.sleep(1);

			element = driver.findElement(By.id(Constants.Settings.DATA_LIST_GROUP));
			element = element.findElement(By.cssSelector(Constants.Settings.CLASS_CELL_EMPTY));

			if (element != null && element.isDisplayed()) {
				element = driver.findElement(By.id(Constants.Settings.BTN_ADD_ATM_GROUP));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", element);

				element = driver.findElement(By.id(Constants.Settings.GROUP_NAME_INPUT));
				element.sendKeys(name);

				element = driver.findElement(By.id(Constants.Settings.GROUP_DESCX_INPUT));
				element.sendKeys(name + name.hashCode());

				element = driver.findElement(By.id(Constants.Settings.SAVE_ATM_GROUP_BTN));
				element.click();

				multiService.sleep(2);
			}
		}
	}

}
