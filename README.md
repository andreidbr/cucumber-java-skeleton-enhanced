# Cucumber Java Skeleton Enhanced
![An enhanced Cucumber Java Skeleton project with the essential dependencies](cucumber-automation-framework-skeleton-header.png)

Cucumber is a great BDD framework, but I've found the official Cucumber Java Skeleton project as lacking. As such, I decided to create an enhanced skeleton that includes some sample back-end and front-end tests.

Check out all the details on my website: https://andreidobra.com/blog/cucumber-advantages-disadvantages and on this YouTube video: https://youtu.be/tF8dsGpCBgI

If you're looking for a simple test automation framework without Java, check out my other free repo: https://github.com/andreidbr/test-automation-framework-skeleton

## About the repo
I've added sample feature files with:
- back-end tests using Rest Assured
- front-end tests using Selenium
- general tests showing how to use data tables
- all feature files demonstrate some essential Cucumber features like Background steps, Before and After hooks, or Scenario Outlines, Cucumber Expressions

The test runner uses JUnit 5, and I've configured Cucumber PrettyReports plugin that automatically generates reports in `target/cucumber/cucumber-html-reports`

## Using it

Prerequisites:
- Java JDK 17 installed
- Apache Maven installed
- Google Chrome installed. If you use other browsers, you will need to modify the webdriver instantiated in `src/test/resources/com/andreidobra/frontend.feature` and `src/test/java/com/andreidobra/stepdefs/FrontendStepDefs.java`
- optional: IntelliJ Community Edition installed

To execute it, run `mvn test`. It will run all scenarios that match the tags explicitly declared in `src/test/java/com/andreidobra/runner/RunCucumberTest.java`