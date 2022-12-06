# How to set up a selenium project using gradle?

## 1. Prerequisite

  - Install [JDK](https://www.oracle.com/java/technologies/downloads/)

  - Download [chromedriver](https://chromedriver.chromium.org/downloads)

  - Install [Intellij Community Edition](https://www.jetbrains.com/idea/download/#section=linux)

## 2. Add a java project using gradle

File > New > Project > New Project

    Name: YourProjectName

    Location: Your project location

    Language: Java

    Build System: Gradle

    JDK: Your jdk

    Gradle DSL: Groovy

    Add sample code: unchecked

## 3. Add selenium dependencies

  - Add the Selenium Java dependency from [maven central](https://mvnrepository.com/repos/central) to **build.gradle**

  - For example,
  
        testImplementation('org.seleniumhq.selenium:selenium-java:4.6.0')

  - Load Gradle Changes

      ![LoadGradleChanges](https://user-images.githubusercontent.com/52661397/204166225-82c7f921-18f8-4f8e-b157-4e68773d25a1.png)

## 4. Add tests

If you would like to use example tests from this repo, follow these steps:

  - Copy the [src](https://github.com/Tim-Cao/seleniumproject/tree/master/src/) directory to yourProject

  - Replace the [chromedriver path](https://github.com/Tim-Cao/seleniumproject/blob/master/src/main/java/driver/BrowserDriver.java#L33) by your chromedriver path

  - Add the axe-core dependency **testImplementation('com.deque.html.axe-core:selenium:4.3.2')** to **build.gradle**
