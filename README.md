# SauceDemo Automation

Web UI Test Automation Framework for SauceDemo using Java, Selenium WebDriver, JUnit 5, and Cucumber.

This project focuses on automating the main e-commerce user flows, including authentication, product browsing, shopping cart management, and checkout.

## Project Overview

The purpose of this project is to practice and demonstrate UI test automation using the Page Object Model (POM) design pattern and Behavior-Driven Development (BDD) with Cucumber.

The framework includes automated functional scenarios organized into Smoke and Regression test suites.

## Technologies & Tools

| Technology | Purpose |
|---|---|
| Java 25 | Programming language |
| Selenium WebDriver 4.51.0 | Browser automation |
| JUnit 5 | Test execution |
| Cucumber 7.34.9 | BDD and Gherkin scenarios |
| PicoContainer | Dependency injection |
| Maven | Build and dependency management |
| Allure Reports | Test execution reporting |
| IntelliJ IDEA | Development environment |
| Git & GitHub | Version control |

## Project Structure

```text
src/
├── main/
│   └── java/
│       └── pages/
│           ├── BasePage.java
│           ├── LoginPage.java
│           ├── ProductsPage.java
│           ├── CartPage.java
│           └── CheckoutPage.java
│
└── test/
    ├── java/
    │   ├── context/
    │   ├── driver/
    │   ├── hooks/
    │   ├── runner/
    │   └── steps/
    │
    └── resources/
        ├── features/
        │   ├── login.feature
        │   ├── products.feature
        │   ├── cart.feature
        │   └── checkout.feature
        ├── allure.properties
        └── junit-platform.properties
```

## Automated Test Modules

| Module | Coverage |
|---|---|
| Login | Successful login and invalid credentials |
| Products | Product listing and adding products to the cart |
| Shopping Cart | Product information and product removal |
| Checkout | Required field validation, order overview, and order completion |

## Test Suites

The framework uses Cucumber tags to organize test execution.

### Smoke Testing

A small set of tests covering the application's main functionalities and critical user flow.

```bash
mvn clean test "-Dcucumber.filter.tags=@smoke"
```

**Current coverage:** 5 scenario executions.

### Regression Testing

Executes the complete set of automated scenarios to verify that existing functionality continues to work as expected.

```bash
mvn clean test "-Dcucumber.filter.tags=@regression"
```

**Current coverage:** 16 scenario executions.

## Test Execution

Make sure Java and Maven are available in your environment and that Google Chrome is installed.

To execute the complete test suite:

```bash
mvn clean test
```

To execute a specific test suite, use the corresponding Cucumber tag commands above.

## Allure Reports

This project uses Allure to generate test execution reports.

After executing the tests, generate the HTML report with:

```bash
allure generate target/allure-results --clean -o target/allure-report
```

Open the report:

```bash
allure open target/allure-report
```

## Design & Architecture

The framework follows the Page Object Model (POM) pattern to separate page interactions from test logic.

Cucumber Step Definitions connect Gherkin scenarios with the corresponding page methods.

PicoContainer manages scenario-scoped dependency injection and shares the test context between Hooks and Step Definitions.

WebDriver initialization and cleanup are handled through Cucumber Hooks.

## Project Status

The Login, Products, Shopping Cart, and Checkout modules have been implemented.

Smoke and Regression test suites are configured and executable.

## Author

**Meredick Rodríguez**

Software Development Student | Aspiring QA Engineer

[GitHub Profile](https://github.com/Meredick)