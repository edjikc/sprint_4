package ru.yandex.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private final WebDriver driver;

    //Элемент главной формы
    private final By form = By.className("Order_Form__17u6u");

    //Поле ввода имени
    private final By name = By.xpath("//input[@placeholder='* Имя']");
    //Поле ввода фамилии
    private final By lastName = By.xpath("//input[@placeholder='* Фамилия']");
    //Поле ввода заказа
    private final By address = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле ввода метро
    private final By metro = By.className("select-search__input");

    //Поле ввода телефона
    private final By phone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Список представленных метро
    private final By metroSelect = By.className("select-search__options");
    //Метро в выподающем списке
    private final By metroButton = By.xpath("//li[@class='select-search__row']/button");
    //Кнопка Далее
    private final By nextButton = By.xpath("//button[text()='Далее']");

    //Поле ввода даты
    private final By date = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Кнопка отправки заказа
    private final By submitOrder = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Кнопка выбора конкретной даты
    private final By dayOfDate = By.className("react-datepicker__day");
    //Кнопка выпадающего списка с временем аренды
    private final By rentTime = By.className("Dropdown-control");
    //Выбор конкретного срока аренды
    private final By rentTimeOption = By.className("Dropdown-option");
    //Модальное окно с подтверждением заказа
    private final By confirmOrder = By.className("Order_Modal__YZ-d3");
    //Кнопка подтверждения заказа
    private final By confirmOrderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    //Модальное окно с сообщением об успешном заказе
    private final By successModal = By.xpath("//div[text()='Заказ оформлен']");
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForForm(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(form));
    }

    public void setName(String val){
        driver.findElement(name).sendKeys(val);
    }

    public void setLastName(String val){
        driver.findElement(lastName).sendKeys(val);
    }

    public void setAddress(String val){
        driver.findElement(address).sendKeys(val);
    }

    public void setPhone(String val){
        driver.findElement(phone).sendKeys(val);
    }

    public void clickMetro(){
        driver.findElement(metro).click();
    }

    public void waitForSelectMetroLoad(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(metroSelect));
    }

    public void selectMetro(){
        driver.findElement(metroButton).click();
    }

    public void clickNext(){
        driver.findElement(nextButton).click();
    }

    public void clickDate(){
        driver.findElement(date).click();
    }

    public void waitForDayOfDateLoad(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(dayOfDate));
    }

    public void clickDayOfDate(){
        driver.findElement(dayOfDate).click();
    }

    public void clickRent(){
        driver.findElement(rentTime).click();
    }

    public void waitForRentTimeLoad(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(rentTimeOption));
    }

    public void clickRentTimeOption(){
        driver.findElement(rentTimeOption).click();
    }

    public void clickSubmitOrder(){
        driver.findElement(submitOrder).click();
    }

    public void waitForConfirmLoad(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(confirmOrder));
    }

    public void clickConfirmButton(){
        driver.findElement(confirmOrderButton).click();
    }

    public void checkSuccessModal(String message){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElementLocated(successModal, message));
    }
}
