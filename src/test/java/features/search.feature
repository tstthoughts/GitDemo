Feature: Search and order vegetables
@Search
Scenario: Search for items and validate results
Given User is on Greencart Landing page
When User searched for "Cucumber" vegetable
Then "Cucumber" results are displayed

@Search
Scenario Outline: Search for items and move to checkout page
Given User is on Greencart Landing page
When User searched for <name> type vegetable
And Added items to cart
And User proceeded to checkout page for purchase
Then verify selected <name> items are displayed in check out

Examples:
|name	 |
|Brinjal |
|Beetroot|