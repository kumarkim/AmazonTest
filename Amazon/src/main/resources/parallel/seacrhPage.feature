Feature: Amazon Search feature

Scenario: Search for book Kim
Given user is on amazon search Page
When user types "Kim" on the search box
And User clicks on search
Then The book "Kim" by "Rudayd Kipling" is displayed
And User clicks on the searched Item

