Feature:  Admin Login to HRM home page
In Order To Login to Orange HRM
As a Admin with valid username and password 
I want to Enter Username, Password, click on Login Button to Access to the Application.

Scenario: Positive-Admin Login successfully

Given Admin Navigate to HRM Login page
When Admin Enter valid userName and password
And click on LOGIN Button
Then Admin will Land in Admin HomePage
Then Close The Browser
@Login
Scenario Outline: Negative unable to login
Given Admin Navigate to HRM Login page
When Admin Enter Invalid userName"<un>" and Invalidpassword"<psw>"
And click on LOGIN Button
Then InvalidCredenTial Message will Apear
Then Close The Browser
 Examples: 
 |un|psw|
 |dminsdsafdsafdafsafwq1234|adminvalidi456n|
 