package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginElements {
    public WebDriver driver;

    public loginElements(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement profileMenu(){

        return driver.findElement(By.xpath("//div[@class=\"profile-img\"]"));
    }

    public WebElement mobileNumber() {
        return driver.findElement(By.xpath("//input[@type=\"text\"]"));
    }

    public WebElement password() {
        return driver.findElement(By.xpath("//input[@type=\"password\"]"));
    }

    public WebElement loginBtn() {
        return driver.findElement(By.xpath("//button"));
    }

    public WebElement forgetPass() {
        return driver.findElement(By.xpath("//*[text()='Forgot Password?']"));
    }

    public WebElement otpInput(int index) {
        return driver.findElement(By.xpath("//input[@type=\"text\"][" + index + "]"));
    }
    // public WebElement otpInput() {
    //     return driver.findElement(By.xpath("//input[@type=\"text\"][1]"));
    // }

    public WebElement verifyBtn() {
        return driver.findElement(By.xpath("//button"));
    }

    public WebElement newPass() {
        return driver.findElement(By.xpath("//input[@type=\"password\"][1]"));
    }

    public WebElement cnfrmPass() {
        return driver.findElement(By.xpath("(//input[@type=\"password\"])[2]"));
    }

    public WebElement submitBtn() {
        return driver.findElement(By.xpath("//button"));
    }
}
