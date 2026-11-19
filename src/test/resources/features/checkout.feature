
Feature: Checkout

  Background:
    Given the user is logged in


  Scenario: Navigate to checkout overview with valid information
    When the user adds the product "Sauce Labs Backpack" to the cart
    And the user opens the shopping cart
    And the user proceeds to checkout
    And the user enters valid checkout information
    Then the user should be directed to the checkout overview page


  Scenario Outline: Validate required checkout information
    When the user adds the product "Sauce Labs Backpack" to the cart
    And the user opens the shopping cart
    And the user proceeds to checkout
    And the user enters checkout information with an empty "<field>"
    Then the user should see the checkout error "<error_message>"

    Examples:
      | field      | error_message                   |
      | first name | Error: First Name is required   |
      | last name  | Error: Last Name is required    |


  Scenario: Verify product information in checkout overview
    When the user adds the product "Sauce Labs Backpack" to the cart
    And the user opens the shopping cart
    And the user proceeds to checkout
    And the user enters valid checkout information
    Then the checkout overview should display the product "Sauce Labs Backpack"
    And the checkout overview should display the correct quantity and price


  Scenario: Complete an order successfully
    When the user adds the product "Sauce Labs Backpack" to the cart
    And the user opens the shopping cart
    And the user proceeds to checkout
    And the user enters valid checkout information
    And the user completes the order
    Then the user should see the order confirmation message "Thank you for your order!"
