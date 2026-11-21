Feature: Shopping Cart

  Background:
    Given the user is logged in

  @regression @smoke
  Scenario: Verify that the shopping cart displays product information
    When the user adds the product "Sauce Labs Backpack" to the cart
    And the user opens the shopping cart
    Then the shopping cart should display the product "Sauce Labs Backpack"
    And the shopping cart should display the price "$29.99"

  @regression
  Scenario: Remove a product from the shopping cart
    When the user adds the product "Sauce Labs Backpack" to the cart
    And the user opens the shopping cart
    And the user removes the product "Sauce Labs Backpack"
    Then the shopping cart should be empty
