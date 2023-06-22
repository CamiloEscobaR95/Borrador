package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePageUI extends PageObject {

    static WebDriver driver = Serenity.sessionVariableCalled("driver");

    static By btnPrueba_locator = By.xpath("//a[contains(text(),'Home')]");

    public static void clickBtn(){
        driver.findElement(btnPrueba_locator).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
