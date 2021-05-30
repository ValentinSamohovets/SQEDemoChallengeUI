## Demo Challenge

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: Ruslan_Kashapau@epam.com


#### Expectations
We will be evaluating
1. Naming conventions
2. Code readability
3. Code encapsulation
4. Code structure and organization
5. Quality of test cases
6. Variety  of testing types (examples: boundary, happy path, negative, etc) 


#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/


#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases
   
1. Place order for small pizza without topping, pay by credit card  
2. Place order for small pizza with one topping, pay by cash 
3. Place order for medium pizza with 2 toppings, pay by credit card 
4. Place order for large pizza without toppings, pay by cash
5. Place order for large pizza without 2 toppings, pay by credit card
6. Place order for pizza with 1 topping, and do not select any toppings 
7. Place order for pizza with 2 topping, and select only one topping 
8. Place order for pizza with 2 topping, and do not select any toppings 
9. Place order for 2 pizzas 
10. Place order for 10 pizzas 
11. Place order for 100 pizzas 
12. Try to place an order without personal info 
13. Try to place an order with name only 
14. Try to place an order with phone only 
15. Try to place an order with email only 
16. Try to place an order with name and email
17. Try to place an order with phone and email
18. Try to place an order without payment information  
19. Try to Select both payment method and place an order 
19. Prepare an order and change pizza type, the cost should be changed 
20. Prepare order and click reset, all fields should be set to default 

    - Check all field labels and select options in selects 
    - If some toppings are not covered by test, need to add more tests for toppings      

