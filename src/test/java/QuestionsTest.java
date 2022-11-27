import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.practicum.pages.HomePage;

public class QuestionsTest {
    private static WebDriver driver;
    private static HomePage homePage;

    @BeforeClass
    public static void setupDriver(){

        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void checkPriceQuestion(){
        homePage.waitForQuestionsLoad();
        homePage.checkAnswerForQuestion("Сколько это стоит? И как оплатить?","Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
    }
    @Test
    public void checkCountQuestion(){
        homePage.waitForQuestionsLoad();
        homePage.checkAnswerForQuestion("Хочу сразу несколько самокатов! Так можно?","Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
    }
    @Test
    public void checkRentQuestion(){
        homePage.waitForQuestionsLoad();
        homePage.checkAnswerForQuestion("Как рассчитывается время аренды?","Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
    }

    @Test
    public void checkRentTodayQuestion(){
        homePage.waitForQuestionsLoad();
        homePage.checkAnswerForQuestion("Можно ли заказать самокат прямо на сегодня?","Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
    }

    @Test
    public void checkTimeQuestion(){
        homePage.waitForQuestionsLoad();
        homePage.checkAnswerForQuestion("Можно ли продлить заказ или вернуть самокат раньше?","Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
    }

    @Test
    public void checkChargeQuestion(){
        homePage.waitForQuestionsLoad();
        homePage.checkAnswerForQuestion("Вы привозите зарядку вместе с самокатом?","Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
    }

    @Test
    public void checkCanselQuestion(){
        homePage.waitForQuestionsLoad();
        homePage.checkAnswerForQuestion("Можно ли отменить заказ?","Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
    }

    @Test
    public void checkMKADQuestion(){
        homePage.waitForQuestionsLoad();
        homePage.checkAnswerForQuestion("Я жизу за МКАДом, привезёте?","Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }

    @AfterClass
    public static void quit(){
        driver.quit();
    }
}
