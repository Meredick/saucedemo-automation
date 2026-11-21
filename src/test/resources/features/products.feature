Feature: Products

  Background:
    Given the user is logged in

  @regression @smoke
  Scenario: Verify that the product list display product names and prices
    Then the product list should contain 6 products
    And all products should display a name
    And all products should display a price

  @regression @smoke
  Scenario: Add a product to the shopping cart
    When the user adds the product "Sauce Labs Backpack" to the cart
    Then the cart counter should display 1
    And the product "Sauce Labs Backpack" button should display "Remove"

  @regression
  Scenario: Add multiple products to the shopping cart
    When the user adds the product "Sauce Labs Backpack" to the cart
    And the user adds the product "Sauce Labs Bike Light" to the cart
    Then the cart counter should display 2