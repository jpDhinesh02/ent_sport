package entSport;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import utility.extentReports;

public class launchWeb {

	public void launchKqWeb(WebDriver driver) throws Exception {
		extentReports.createTest("Launch_Kq_Assessment", "Test for launch Application");
		try {
			String Urls[] = { "http://93.127.194.67:3000/", "http://ent-sport.vvmatrimony.com/" };

			for (int i = 0; i <= Urls.length - 1; i++) {
				driver.get(Urls[i]);
				driver.manage().window().maximize();
				try {
					driver.findElement(By.id("details-button")).click();
					driver.findElement(By.id("proceed-link")).click();
				} catch (Exception e) {
				}
				if (i < Urls.length - 1) {
					((JavascriptExecutor) driver).executeScript("window.open()");
					ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(tabs.size() - 1));
				}
			}
			extentReports.logPass("Successfully launch Kq Assessment");
		} catch (Exception e) {
			e.printStackTrace();
			extentReports.logFail(driver, "Launch_Kq", "Failed to Launch Kq application");
		}

	}
}
