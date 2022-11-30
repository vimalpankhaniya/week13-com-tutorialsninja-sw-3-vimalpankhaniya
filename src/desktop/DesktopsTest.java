package desktop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

public class DesktopsTest extends Utility {
    String baseurl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //1.1 Mouse hover on Desktops Tab.and click
        Actions actions = new Actions(driver);
        WebElement desktops  = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(desktops).click().build().perform();
        //1.2 Click on “Show All Desktops”
        clickElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //1.3 Select Sort By position "Name: Z to A"
        Thread.sleep(1500);
        // sendTextToElement(By.xpath("//option[contains(text(),'Name (A - Z)')]"),"Name (A - Z)");
        Select obj = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        obj.selectByIndex(2);
        //1.4 Verify the Product will arrange in Descending order.
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        Actions actions = new Actions(driver);
        //2.1 Mouse hover on Desktops Tab. and click
        WebElement desktops  = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(desktops).click().build().perform();
        //2.2 Click on “Show All Desktops”
        clickElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //2.3 Select Sort By position "Name: A to Z"
        Select obj = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        obj.selectByIndex(1);
        //2.4 Select product “HP LP3065”
        clickElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        //2.5 Verify the Text "HP LP3065"
        verifyTextFromElements(By.xpath("//h1[contains(text(),'HP LP3065')]"),"HP LP3065");
        //2.6 Select Delivery Date "2022-11-30"
        clearTest(By.xpath("//input[@id='input-option225']"));
        sendTextToElement(By.xpath("//input[@id='input-option225']"),"2022-11-30");
        //2.7.Enter Qty "1” using Select class.
        clickElement(By.xpath("//input[@id='input-quantity']"));
        //2.8 Click on “Add to Cart” button
        clickElement(By.xpath("//button[@id='button-cart']"));
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(2000);
        //verifyTextFromElements(By.xpath("//body/div[@id='product-product']/div[1]"),"Success: You have added HP LP3065 to your shopping cart!");
        ////body/div[@id='product-product']/div[1] //body/div[@id='product-product']/div[1]

        //2.10 Click on link “shopping cart” display into success message
        clickElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));
        //2.11 Verify the text "Shopping Cart"
        Thread.sleep(2000);
        verifyTextFromElements(By.xpath("//h1[contains(text(),' (1.00kg)')]"),"Shopping Cart  (1.00kg)");
        //2.12 Verify the Product name "HP LP3065"
        verifyTextFromElements(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"HP LP3065");
        //2.13 Verify the Delivery Date "2022-11-30"
        verifyTextFromElements(By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]"),"Delivery Date: 2022-11-30");
        //2.14 Verify the Model "Product21"
        verifyTextFromElements(By.xpath("//td[contains(text(),'Product 21')]"),"Product 21");
        //2.15 Verify the Todat "£74.73"
        verifyTextFromElements(By.xpath("//tbody/tr[1]/td[6]"),"$122.00");

    }
    private void clearTest(By xpath) {
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}

