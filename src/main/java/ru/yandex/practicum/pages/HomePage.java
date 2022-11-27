package ru.yandex.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class HomePage {
    private final WebDriver driver;

    //Верхняя кнопка заказа
    private final By topOrderButton = By.className("Button_Button__ra12g");

    //Нижняя кнопка заказа
    private final By botOrderButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");

    //Кнопки вопросов в аккордионе
    private final By question = By.className("accordion__button");

    //Путь до ответа на вопрос относительно элемента вопроса
    private final By answer = By.xpath("./../../div[@data-accordion-component='AccordionItemPanel']");
    //Список вопросов в аккордионе
    private final By accordionQuestions = By.xpath("//div[@data-accordion-component='Accordion']");

    //Кнопка принятия куки
    private final By cookieButton = By.id("rcc-confirm-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieButtonIfPresent(){
        List<WebElement> elements = driver.findElements(cookieButton);
        if (!elements.isEmpty()){
            elements.get(0).click();
        }
    }

    public void waitForTopButton(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(topOrderButton));
    }
    public void waitForBotButton(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(botOrderButton));
    }
    public void waitForAnswerLoad(WebElement answerElement, String answerString) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElement(answerElement, answerString));
    }

    //Ожидание загрузки списка вопросов
    public void waitForQuestionsLoad(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionQuestions));
    }

    //Метод проверки и поиска вопроса по тексту
    public WebElement checkContainsQuestion(String questionString){
        List<WebElement> elements = driver.findElements(question);
        Optional<WebElement> questionElement = elements.stream()
                .filter(webElement -> webElement.getText().equals(questionString))
                .findFirst();
        Assert.assertTrue(questionElement.isPresent());
        return questionElement.get();
    }

    public void checkAnswerForQuestion(String question, String answer){
        clickCookieButtonIfPresent();
        WebElement questionElement = checkContainsQuestion(question);
        assertThat("Вопросы не совпадают", questionElement.getText(), is(question));
        questionElement.click();
        WebElement answerForQuestion = getAnswerForQuestion(questionElement);
        waitForAnswerLoad(answerForQuestion, answer);
    }

    public void clickTopButton(){
        driver.findElement(topOrderButton).click();
    }
    public void clickBotButton(){
        driver.findElement(botOrderButton).click();
    }
    private WebElement getAnswerForQuestion(WebElement element){
        return element.findElement(answer);
    }

}
