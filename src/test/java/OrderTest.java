import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.practicum.pages.HomePage;
import ru.yandex.practicum.pages.OrderPage;

public class OrderTest {
    private WebDriver driver;
    private HomePage homePage;
    private OrderPage orderPage;

    @Before
    public void setupDriver(){

        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void testTopOrderButton(){
        homePage.clickCookieButtonIfPresent();
        homePage.waitForTopButton();
        homePage.clickTopButton();
        fillForm();
    }

    @Test
    public void testBotOrderButton(){
        homePage.clickCookieButtonIfPresent();
        homePage.waitForBotButton();
        homePage.clickBotButton();
        fillForm();
    }
    private void fillForm(){
        orderPage.waitForForm();
        orderPage.setName("Тест");
        orderPage.setLastName("Тестов");
        orderPage.setAddress("Москва");
        orderPage.clickMetro();
        orderPage.waitForSelectMetroLoad();
        orderPage.selectMetro();
        orderPage.setPhone("89121212121");
        orderPage.clickNext();
        orderPage.waitForForm();
        orderPage.clickDate();
        orderPage.waitForDayOfDateLoad();
        orderPage.clickDayOfDate();
        orderPage.clickRent();
        orderPage.waitForRentTimeLoad();
        orderPage.clickRentTimeOption();
        orderPage.clickSubmitOrder();
        orderPage.waitForConfirmLoad();
        orderPage.clickConfirmButton();
        orderPage.checkSuccessModal("Заказ оформлен");
    }
    @After
    public void quit(){
        driver.quit();
    }
}
