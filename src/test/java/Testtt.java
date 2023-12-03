import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import page.PageOne;
import page.PageTwo;

public class Testtt {

    WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teatDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void testFirst() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("input[type='text'")).sendKeys("Василий Иванов");
        driver.findElement(By.cssSelector("input[type='tel'")).sendKeys("+79639676386");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button__text")).click();
        String expecting = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.tagName("p")).getText();
        Assertions.assertEquals(expecting, actual);
    }

    @Test
    public void testSecond(){
        driver.get("http://localhost:9999/");
        PageOne pageOne = new PageOne(driver);
        PageTwo pageTwo = new PageTwo(driver);
        pageOne.sendAll("Иванов Василий", "+75486315982");
        Assertions.assertEquals("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", pageTwo.text());

    }



}
