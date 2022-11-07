package sauceDemoTest;

import com.BaseTest;
import org.testng.annotations.Test;
import pages.SauceDemo;

public class SauceDemoTest extends BaseTest {

    @Test(description = "Verification of Sauce Demo sort functionality")
    public void sauceDemoCardAddCheck()
    {
        SauceDemo sauceDemo=new SauceDemo();
        sauceDemo.loginSauce("standard_user","secret_sauce");
        sauceDemo.selectBySort("Price (low to high)");
        sauceDemo.selectBySort("Price (high to low)");
        sauceDemo.verifyItemSortPrices();
    }
}
