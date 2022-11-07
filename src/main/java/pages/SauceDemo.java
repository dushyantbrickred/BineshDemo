package pages;

import com.BaseTest;
import com.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SauceDemo extends BaseTest {

    public static By userName_txt=By.id("user-name");
    public static By password_txt=By.id("password");
    public static By login_btn=By.id("login-button");
    public static By filter_dropdown=By.xpath("//select[@data-test='product_sort_container']");
    public static By allItemPrices_lbl=By.xpath("//div[@class='inventory_item_price']");


    public void loginSauce(String userName,String password)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName_txt));
        driver.findElement(userName_txt).sendKeys(userName);
        driver.findElement(password_txt).sendKeys(password);
        driver.findElement(login_btn).click();
    }

    public void selectBySort(String filterName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(filter_dropdown));
        Select filterSelect=new Select(driver.findElement(filter_dropdown));
        filterSelect.selectByVisibleText(filterName);
    }

    public void verifyItemSortPrices()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(allItemPrices_lbl));
        List<WebElement> itemPricesEle=driver.findElements(allItemPrices_lbl);
        List<Double> sortItems=new ArrayList<>();
        //sortItems.add(2345.90);
        double itemsValue=0;
        for (WebElement ele:itemPricesEle
        ) {
            String item= ele.getText().replaceAll("\\$","");
            itemsValue=Double.parseDouble(item);
            sortItems.add(itemsValue);

        }


        Assert.assertTrue(isSorted(sortItems));
    }

    public boolean isSorted(List<Double> list)
    {
        boolean sorted = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1).compareTo(list.get(i)) > 0) sorted = false;
        }

        return sorted;
    }



}
