# Test Automation Framework 

This is a Java-based test automation framework designed for web application testing. 
It leverages Java 11, TestNG for test execution, OpenCSV and Apache POI for data-driven testing, Faker library for generating fake test data, and LambdaTest for cloud-based cross-browser testing. 
The framework supports headless mode for faster execution and uses Maven Surefire Plugin for running tests from the command line. Test results are reported using ExtentReports, and logging is handled with Log4j.
The framework follows a modular, scalable design with the Page Object Model (POM) to ensure maintainability and reusability. 
It is suitable for testing web applications, with robust reporting and logging capabilities.

## Author

- Jampani Kotaiah
- [@Git Hub](https://github.com/JampaniKotaiah)

## Tech Stack

**Programming Language:** Java 11

## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/JampaniKotaiah)

## Prerequisites

- **Java 11**: Install JDK 11 (e.g., OpenJDK or Oracle JDK).
- **Maven**: Install Apache Maven (version 3.6.0 or higher) for dependency management and test execution.
- **Git**: For cloning the repository.
- **LambdaTest Account**: Required for cloud-based testing. Set up credentials (username and access key) from LambdaTest. 
- **IDE**: IntelliJ IDEA, Eclipse, or any Java-compatible IDE for development (optional).
- **Browser Drivers**: For local execution, download browser drivers (e.g., ChromeDriver, GeckoDriver) compatible with your browser versions and place them in the system PATH or project directory.

##Features

- **Java 11**: Core programming language for the framework.
- **TestNG**: Test execution and management with support for data-driven testing.
- **Data-Driven Testing**:
    OpenCSV: Reads test data from CSV files.
    Apache POI: Reads test data from Excel files (XLSX/XLS).
- **Faker Library**: Generates realistic fake data for testing (e.g., names, emails).
- **LambdaTest Integration**: Runs tests on a cloud-based platform for cross-browser and cross-platform testing.
- **Headless Mode**: Supports headless browser execution for faster test runs.
- **Maven Surefire Plugin**: Enables command-line test execution with configurable parameters.
- **ExtentReports**: Generates detailed HTML test reports with screenshots for failed tests.
- **Log4j**: Provides comprehensive logging for debugging and tracking test execution.
- **CLI Parameters**: Supports three parameters: browser, isLambdaTest, and isHeadless for flexible test execution.


## Setup Instructions

**Clone the Repository:**

```bash
  git clone: https://github.com/JampaniKotaiah/TestAutomationFramework.git
  cd TestAutomationFramework
```

**Running Tests on LambdaTest:**

```bash
    mvn test -Dbrowser=chrome -DisLambda=true -disHeadless=false -X
```

**Running tests on chrome browser on local machine in Headless mode:**

```bash
    mvn test -Dbrowser=chrome -DisLambda=false -disHeadless=true -X
```

**Reports & Logs:**
- ExtentReports:
    Reports are generated in ./reports.html.
    Includes test status, steps, and screenshots for failed tests.
- Log4j:
    Logs are generated in ./logs/directory.

```bash
Integrated the project Github Actions:

This Automation framework is Integrated with github actions
The tests will be executed at 11:30 PM IST every single day

