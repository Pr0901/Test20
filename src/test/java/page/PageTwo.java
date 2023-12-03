package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageTwo {

    WebDriver driver;

    private By texting = By.tagName("p");

    public PageTwo(WebDriver driver) {
        this.driver = driver;
    }

    public String text(){
       String textMassege = driver.findElement(texting).getText();
       return textMassege;
    }
}
