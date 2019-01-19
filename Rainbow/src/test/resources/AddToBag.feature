Feature: Add To Bag

  Background:
    Given I am on the Homepage

  @ignore
  Scenario: As a user I want to add item to bag
    And I search for "blouse" in the search input box
    When I click Add to cart button
    Then I see that Item is added to bag
