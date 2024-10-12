package entSport;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Elements.loginElements;
import utility.Components;
import utility.extentReports;
import utility.getPassword;
import utility.jsonUtilites;

public class login {
    String jsonPath = System.getProperty("user.dir") + "/data/loginCredentials.json";

    public void loginWeb(WebDriver driver) throws Exception {
        extentReports.createTest("Ent_Login", "Test for login ENT-Sport");
        try {
            Components.implicitlyWait(driver, 60);
            loginElements loginEle = new loginElements(driver);
            loginEle.profileMenu().click();
            String mobileNumber = jsonUtilites.getJsonValue(0, jsonPath, "users", "mobileNumber");
            String password = jsonUtilites.getJsonValue(0, jsonPath, "users", "password");
            loginEle.mobileNumber().sendKeys(mobileNumber);
            loginEle.password().sendKeys(password);
            loginEle.submitBtn().click();
            extentReports.logPass("Successfully login with Ent application");
        } catch (Exception e) {
            extentReports.logFail(driver, "Ent_Login", "Failed to login with Ent application");
        }
    }

    public void forgetPassword(WebDriver driver) throws Exception {
        extentReports.createTest("Ent_Forgetpassword", "Test for Ent forget Password ");
        try {
            Components.implicitlyWait(driver, 60);
            loginElements loginEle = new loginElements(driver);
            String mobileNumber = jsonUtilites.getJsonValue(0, jsonPath, "users", "mobileNumber");
            loginEle.mobileNumber().sendKeys(mobileNumber);
            loginEle.forgetPass().click();
            Thread.sleep(5000);
            // otp(driver, mobileNumber, "forget password");
            loginEle.verifyBtn().click();
            loginEle.newPass().sendKeys(jsonUtilites.getJsonValue(jsonPath, "newpass"));
            loginEle.cnfrmPass().sendKeys(jsonUtilites.getJsonValue(jsonPath, "confrmpass"));
            loginEle.submitBtn().click();
            Thread.sleep(1000);
            // driver.findElement(By.xpath("//button[1]")).click();
            extentReports.logPass("Successfully reset password on forget password flow");
        } catch (Exception e) {
            extentReports.logFail(driver, "Forget_Flow", "Failed to reset password on forget password flow");
        }

    }

        // ! I'm not lazy, I’m just in a 'try-catch' loop.

    public void logout(WebDriver driver) {
        driver.findElement(By.xpath("//button[text()='Logout']")).click();
    }

    public static void otp(WebDriver driver, String username, String page) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        String otp;
        if (page.toLowerCase().trim().equals("login")) {
            otp = getPassword.getLoginEmailOtp(username);
        } else {
            otp = getPassword.getForgotPasswordMobileOtp(username);
        }
        wait.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='OTP Verification']"))));
        loginElements loginEle = new loginElements(driver);
        char[] otpArray = otp.toCharArray();
        for (int i = 1; i <= 6; i++) {
            otp = String.valueOf(otpArray[i - 1]);
            loginEle.otpInput(i).sendKeys(otp);
        }
    }
}
