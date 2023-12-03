package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageOne {

    protected WebDriver driver;

    private By userName = By.cssSelector("input[type='text'");
    private By telName = By.cssSelector("input[type='tel'");
    private By galochka = By.className("checkbox__box");
    private By send = By.className("button__text");


    public PageOne(WebDriver driver){
        this.driver = driver;
    }

    public PageOne sendAll(String name, String tel) {
        driver.findElement(userName).sendKeys(name);
        driver.findElement(telName).sendKeys(tel);
        driver.findElement(galochka).click();
        driver.findElement(send).click();
        return new PageOne(driver);
    }


}
