package Testcases;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends TestBase {

    @Test
    public void TC01() {
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        JavascriptExecutor js = (JavascriptExecutor) Constant.DRIVER;
        js.executeScript("arguments[0].scrollIntoView()", loginPage.getBtnLogin());

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD).getErrorMessage();

        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
