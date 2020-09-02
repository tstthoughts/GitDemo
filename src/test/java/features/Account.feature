Feature: Application Login

@MobileTest
Scenario: Home page default login with parameters
Given User is on landing page
When User login to application using "john" and "4321"
Then home page is populated
And cards are not displayed