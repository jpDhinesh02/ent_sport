package entSport;

import org.openqa.selenium.WebDriver;
import mailer.sendMail;
import utility.Components;
import utility.extentReports;

public class Allrunner {
    static login login = new login();
    static launchWeb launch = new launchWeb();
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        driver = Components.startChrome();
        extentReports.initalizeExtent("Ent_Sport");
        launch.launchKqWeb(driver);
        login.loginWeb(driver);
        // login.logout(driver);
        // login.forgetPassword(driver);
        // login.loginWeb(driver);
        extentReports.flush();
        sendMail.sendMailToUser("j9894330583@gmail.com");
    }

}
