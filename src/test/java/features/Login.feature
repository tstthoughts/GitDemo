Feature: Login Application 

Background:
Given Validate the browser
When Browser is triggered
Then Browser started

@MobileTest
Scenario: Home page default login
Given User is on landing page
When User login to application for username and password
Then home page is populated
And cards are displayed

@RegTest
Scenario: Home page default login with parameters
Given User is on landing page
When User login to application using "john" and "4321"
Then home page is populasted
And cards are not displayed

@RegTest
Scenario: Home page default login with Data Table 
Given User is on landing page
When User singup with following details
| jenny | abcd | john@abcd.com |
Then home page is populated
And cards are not displayed

@RegTest
Scenario Outline: Home page default login with Outline
Given User is on landing page
When User login to application with <Username> and <Password>
Then home page is populated
And cards are not displayed

Examples:
|Username |Password|
|User1	  |Pass1   |
|User2	  |Pass2   |