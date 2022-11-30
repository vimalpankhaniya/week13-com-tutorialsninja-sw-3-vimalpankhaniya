package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

import static java.awt.SystemColor.menu;

public class TopMenuTest extends Utility {

    String baseurl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
        public void selectMenu(By by, String menu){
            WebElement click = driver.findElement(by);
            click.sendKeys(menu);
        }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        //1.1 Mouse hover on “Desktops” Tab and click
        Actions actions = new Actions(driver);
        WebElement desktops  = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(desktops).click().build().perform();
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        clickElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //1.3 Verify the text ‘Desktops’
        verifyTextFromElements(By.xpath(" Verify the text ‘Desktops’"),"Desktops");
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        Actions actions = new Actions(driver);
        WebElement LaptopsNotebooks = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        actions.moveToElement(LaptopsNotebooks).click().build().perform();
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        clickElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //2.3 Verify the text ‘Laptops & Notebooks’
        verifyTextFromElements(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"),"Laptops & Notebooks");
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        Actions actions = new Actions(driver);
        WebElement components = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
        actions.moveToElement(components).click().build().perform();
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        clickElement(By.xpath("//a[contains(text(),'Show All Components')]"));
        //3.3 Verify the text ‘Components’
        verifyTextFromElements(By.xpath("//h2[contains(text(),'Components')]"), "Components");

    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
