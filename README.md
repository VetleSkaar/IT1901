[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-green?logo=gitpod)](https://gitpod.stud.ntnu.no/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2021/gr2152/gr2152)

# Group gr2152 repository

## Casino

Welcome to our IT1901 Fall 2021 course application.

With this application we aim to build a casino, where users can gamble using currency.

# Code-Organization

The project “casino” is, in this release, organized in 2 modules, casino-core and casino-UI, respectively with main-code and tests. 

Every module contains:
**src/main/java:**  for application-code
**src/test/java:**  Test code.

Later on in the project we plan to add:

**src/main/resources:** Necessary resources, data files and FXML files for application code
**src/main/resources:** Necessary resources, data files and FXML files for test code
As necessary

Every module contains a pom.xml


# Arkitektur diagram

```plantuml
frame "core" {
  [casino.core]
  [casino.json]
}

frame "ui" {
  [casino.ui]
}

frame "ui" {
  [casino.ui]
}

frame "javafx" {
  [fxml]
}

[Jackson]


[casino.ui] --> [fxml]
[casino.ui] --> [casino.json]
[casino.ui] --> [casino.core]
[casino.json] --> [Jackson]


```

# Code-documentation

In our project we use checkstyle to spot any inconsistencies in our code. 
In the config folder we have our own custom style based google_checks.xml, where we have made some minor modifactions that ensures that we are consistent in the code that we write.

We also have the spotbugs plugin, that we use to detect bugs that our IDE's cannot detect. It also has a filter in the config folder for certain items to exclude from the checks. 

For testing our test coverage, we use jacoco. This gives us a overview over what in the code that needs testing, and lets us know if we have sufficient test coverage. 

Throughout our programming, we talk and communicate with each other online as that is most practical for our group. 

We have also tried out pair programming, where we take turns writing code. In our instance, we found pair programming to be okay, but we also felt that we could get the same job done using screen sharing and talking online using Discord. 

For tackling different issues and development tasks, we found that creating new branches that tackled those issues worked well.
 
 

Every Tuesday and when needed the group gets together and goes over what needs to be done, and this has worked well so far. 

# Core

Casino core contains code for the game logic needed. As per the first release it contains code for the Player-class and tests for the Player class.

# UI

casino-UI contains all classes and logic in relation to the visual representation and user interface of the game. As per the fist release it contains the FXML and controller for the player login screen. 
Later in the project we plan to add a persistence module, with all code related writing and reading data in our domain. This is yet to be implemented. 

# How to run locally

Our application is localized in our UI-module, and uses a javafx plugin.To run the application you wish to first enter the following in the terminal, starting from our group directory:

	
	“cd casino”
	"mvn clean"
	"mvn install"
	“cd ui”
	Run with “mvn javafx:run”
	
# How to run with gitpod
If running with gitpod, press the button and wait for it to load a virtual machine.
Go into correct folder with:

	"mvn install"
	“cd ui”
	Run with “mvn javafx:run”
	Open port view 6080 to see the application

# How to test
To test the whole project, enter:
	“mvn test”
From the project directory.
To test individual modules, enter the given module, and run the same command. 

