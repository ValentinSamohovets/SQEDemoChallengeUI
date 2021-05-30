package com.sample.test.demo.tests;

import com.sample.test.demo.pages.IndexPage;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class PlaceOrderTest extends BaseTest{

    @Test(dataProvider = "testData")
    public void placeOrder(String pizza, String[] toppings, int quantity, Double cost, String name,
                           String email, String phone, int type, String message){
        IndexPage indexPage = new IndexPage(driver);
        indexPage.selectPizza(pizza);
        indexPage.chooseToppings(toppings);
        indexPage.setQuantity(quantity);
        assertEquals(Double.valueOf(indexPage.getCost()), cost);
        indexPage.setName(name);
        indexPage.setEmail(email);
        indexPage.setPhone(phone);
        indexPage.selectPayment(type);
        indexPage.placeOrder();
        assertEquals(indexPage.getDialogMessage(),message);
    }

}
