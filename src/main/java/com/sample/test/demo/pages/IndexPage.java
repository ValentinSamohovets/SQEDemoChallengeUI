package com.sample.test.demo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.sample.test.demo.constants.PizzaTypes;

import java.util.List;

public class IndexPage extends BasePage{

    @FindBy(xpath="//*[text()='Pizza Order Form']")
    WebElement pageTitle;

    @FindBy(id="pizza1Pizza")
    WebElement pizza1;

    @FindBy(xpath="//div[@id='pizza1']//select[@class='toppings1']")
    WebElement pizza1Toppings1;

    @FindBy(xpath="//div[@id='pizza1']//select[@class='toppings2']")
    WebElement pizza1Toppings2;

    @FindBy(id="pizza1Qty")
    WebElement pizza1Quantity;

    @FindBy(id="pizza1Cost")
    WebElement pizza1Cost;

    @FindBy(id="ccpayment")
    WebElement radioCreditCard;

    @FindBy(id="cashpayment")
    WebElement radioCash;

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="name")
    WebElement name;

    @FindBy(id="phone")
    WebElement phone;

    @FindBy(id="placeOrder")
    WebElement placeOrderButton;

    @FindBy(id="reset")
    WebElement resetButton;

    @FindBy(id="dialog")
    WebElement dialog;

    @FindBy(xpath="//div[@id='dialog']/p")
    WebElement dialogText;


    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void selectPizza(String value){
        if(!value.equals("")) {
            Select pizzaSelect = new Select(pizza1);
            pizzaSelect.selectByValue(value);
        }
    }

    public void chooseToppings(String[] values){
        switch (values.length){
            case 0:
                break;
            case 1:
                chooseTopping2(values[0]);
                break;
            case 2:
                chooseTopping1(values[0]);
                chooseTopping2(values[1]);
                break;
        }


    }
    private void chooseTopping1(String value){
        Select topping1 = new Select(pizza1Toppings1);
        topping1.selectByValue(value);
    }

    private  void chooseTopping2(String value){
        Select topping2 = new Select(pizza1Toppings2);
        topping2.selectByValue(value);
    }

    public void setQuantity(int quantity){
        pizza1Quantity.clear();
        pizza1Quantity.sendKeys(String.valueOf(quantity)+ Keys.ENTER);
    }

    public String getCost(){
        return pizza1Cost.getAttribute("value");
    }

    public void setName(String value){
        name.clear();
        name.sendKeys(value);
    }

    public void setEmail(String value){
        email.clear();
        email.sendKeys(value);
    }

    public void setPhone(String value){
        phone.clear();
        phone.sendKeys(value);
    }

    public void selectPayment(int i){
        switch(i){
            case 0:
                break;
            case 1:
                radioCreditCard.click();
                break;
            case 2:
                radioCash.click();
                break;
            case 3:
                radioCreditCard.click();
                radioCash.click();
                break;
        }

    }

    public void placeOrder(){
        placeOrderButton.click();
    }

    public void resetButton(){
        resetButton.click();
    }

    public String getDialogMessage(){
        return dialogText.getText();
    }

}
