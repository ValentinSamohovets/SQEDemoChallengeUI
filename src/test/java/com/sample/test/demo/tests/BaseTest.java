package com.sample.test.demo.tests;

import com.sample.test.demo.Configuration;
import com.sample.test.demo.DriverHelper;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseTest {
    private Configuration config = new Configuration();
    protected String url;
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void init(){
        url = config.getUrl();
        driver = new DriverHelper().getDriver();
        navigateToSite();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();
            driver.close();

        } catch (Exception e) {
        }
    }

    // All parameters can be moved to other more sophisticated place.
    // Also such approach gives an ability to manipulate with test parameters.
    @DataProvider(name = "testData")
    public static Object[][] testsDataDealer(){
        Object [] happyPathTest = {PizzaTypes.SMALL_NOTOPPINGS.getDisplayName(), new String[0], 1, PizzaTypes.SMALL_NOTOPPINGS.getCost(), "Valentin", "some@email.com", "1234567", 1, "Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings"};
        Object [] positiveTest = {PizzaTypes.SMALL_ONETOPPINGS.getDisplayName(), new String[] {PizzaToppings.EXTRACHEESE.getDisplayName()}, 2, PizzaTypes.SMALL_ONETOPPINGS.getCost()*2, "Valentin", "some@email.com", "1234567", 2, "Thank you for your order! TOTAL: 15 Small 6 Slices - 1 topping"};
        Object [] negativeTest = {PizzaTypes.LARGE_THREETOPPINGS.getDisplayName(), new String[] {PizzaToppings.ITALIANHAM.getDisplayName(), PizzaToppings.MANGOS.getDisplayName()}, 1, PizzaTypes.LARGE_THREETOPPINGS.getCost(), "", "", "", 2, "Missing name\nMissing phone number"};
        Object [] negativeTestWithFail = {"", new String[0], 0, 0., "Valentin", "", "1234567", 0, "Sorry. Your order cannot be placed!"};

        return new Object[][] { happyPathTest, positiveTest, negativeTest, negativeTestWithFail};
    }

    private void navigateToSite() {
        driver.get(url);
    }
}
