# How to set up a selenium project using gradle?

## Prerequisite

- Install [JDK](https://www.oracle.com/java/technologies/downloads/)

- Install [Intellij Community Edition](https://www.jetbrains.com/idea/download/#section=linux)

## Add a java project using gradle

File > New > Project > New Project

    Name: YourProjectName

    Location: Your project location

    Language: Java

    Build System: Gradle

    JDK: Your jdk

    Gradle DSL: Groovy

    Add sample code: unchecked

## Add selenium dependencies

- Add the Selenium Java dependency from [maven central](https://mvnrepository.com/repos/central) to ***build.gradle***

- For example,

      testImplementation('org.seleniumhq.selenium:selenium-java:4.13.0')

- Load Gradle Changes

    ![LoadGradleChanges](https://user-images.githubusercontent.com/52661397/204166225-82c7f921-18f8-4f8e-b157-4e68773d25a1.png)

## Add tests

If you would like to use example tests from this repo, follow these steps:

- Copy the [src](src) directory to yourProject

- Add the following dependencies to ***build.gradle***

      implementation 'org.testng:testng:7.0.0'

      implementation 'io.github.bonigarcia:webdrivermanager:5.6.0'

      implementation('com.deque.html.axe-core:selenium:4.8.0')

If you would like to parallel run SitesAdminTest, follow this guide:

- [Run Test Suite](https://www.jetbrains.com/help/idea/testng.html#run-test-suite)