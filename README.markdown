# How to set up a selenium project with Java?

## Prerequisite

- Install [JDK 11 or above](https://www.oracle.com/java/technologies/downloads/)

- Install [Intellij Community Edition](https://www.jetbrains.com/idea/download/#section=linux)

## Add a java project using gradle

- File > New > Project > New Project

        Name: YourProjectName
        
        Location: Your project location
        
        Language: Java
        
        Build System: Gradle
        
        JDK: Your jdk
        
        Gradle DSL: Groovy
        
        Add sample code: unchecked


## Add required dependencies

- Add required dependencies from [maven central](https://mvnrepository.com/repos/central) to ***build.gradle***

- For example,

      implementation('junit:junit:4.13.1')
      implementation('io.github.bonigarcia:webdrivermanager:5.7.0')
      implementation('org.seleniumhq.selenium:selenium-java:4.18.1')

- Load Gradle Changes

    ![LoadGradleChanges](https://user-images.githubusercontent.com/52661397/204166225-82c7f921-18f8-4f8e-b157-4e68773d25a1.png)

## Add driver classes to encapsulate selenium APIs under src/main/java/driver

## Add page object classes to wrap specific tasks under test/java/com/selenium

## Add tests under test/java/com/selenium

If you would like to use example codes from this repo, follow these steps:

- Copy the [src](src) directory to yourProject

- Add the following dependencies to ***build.gradle***

      implementation 'org.testng:testng:7.0.0'

      implementation('com.deque.html.axe-core:selenium:4.8.0')

If you would like to parallel run SitesAdminTest, follow this guide:

- [Run Test Suite](https://www.jetbrains.com/help/idea/testng.html#run-test-suite)

## Run single test in the class

### Intellij

- Right-click on the method name in the code editor and select:

  - Run ***testLogin()***

- Click on the method name in the code editor and press the key combination:

  - ***ctrl + shift + F10***

### Command Line

- Run  `./gradlew clean test --tests SignInTest.testLogin`