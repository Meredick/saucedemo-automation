Feature: Login

  Background:
    Given The user is on the login page

  Scenario: Successful login
    When the user enters "standard_user" as username and "secret_sauce" as password
    Then the user should be directed to the products page

  Scenario Outline: Login with invalid credentials
    When the user enters "<username>" as username and "<password>" as password
    Then the user should see an error message "<expectedMessage>"

    Examples:
      |username        | password       | expectedMessage                                                           |
      |standard_user   | wrong_password | Epic sadface: Username and password do not match any user in this service |
      |standard_user   |                | Epic sadface: Password is required                                        |
      |                | secret_sauce   | Epic sadface: Username is required                                        |
      |                |                | Epic sadface: Username is required                                        |
      |locked_out_user | secret_sauce   | Epic sadface: Sorry, this user has been locked out.                       |

