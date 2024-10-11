package Elements;

import org.openqa.selenium.*;

public class signupElements {
    WebDriver driver;
    
    public signupElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement signUp(){
        return driver.findElement(By.xpath("//div[text()='Sign in']"));
    }

    public WebElement mobileNumber() {
        return driver.findElement(By.xpath("//input[@type=\"text\"]"));
    }

    public WebElement signInBtn() {
        return driver.findElement(By.xpath("//button"));
    }

    public WebElement otpInput(int index) {
        return driver.findElement(By.xpath("//input[@type=\"text\"][" + index + "]"));
    }

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
