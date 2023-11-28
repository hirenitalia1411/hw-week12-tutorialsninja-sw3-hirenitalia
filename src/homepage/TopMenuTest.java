package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;
import java.util.Objects;

public class TopMenuTest extends Utility {

    static String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']"));
        for (WebElement element: topMenuList) {
            if(Objects.equals(element.getText(), menu)){
                clickOnElement(By.xpath("//div[@class = 'dropdown-menu']//a[normalize-space()='"+menu+"']"));
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        Thread.sleep(200);
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Desktops']"));
        //selectMenu("Show AllDesktops");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        verifyTheStringMessage(By.tagName("h2"), "Desktops");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        Thread.sleep(200);
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //selectMenu("Show AllDesktops");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        verifyTheStringMessage(By.tagName("h2"), "Laptops & Notebooks");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        Thread.sleep(200);
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Components']"));
        //selectMenu("Show AllDesktops");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllComponents']"));
        verifyTheStringMessage(By.tagName("h2"), "Components");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
