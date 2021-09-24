[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-green?logo=gitpod)](https://gitpod.stud.ntnu.no/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2021/gr2152/gr2152)

# Group gr2152 repository

## Casino#

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

# core

Casino core contains code for the game logic needed. As per the first release it contains code for the Player-class and tests for the Player class.

# UI

casino-UI contains all classes and logic in relation to the visual representation and user interface of the game. As per the fist release it contains the FXML and controller for the player login screen. 
Later in the project we plan to add a persistence module, with all code related writing and reading data in our domain. This is yet to be implemented. 

# How to run locally

Our application is localized in our UI-module, and uses a javafx plugin.To run the application you wish to first enter the following in the terminal, starting from our group directory:

	“cd casino”
	“cd ui”
    “mvn compile”
    Test with “mvn test”
	Run with “mvn javafx:run”
	
# How to run with gitpod
If running with gitpod, press the button and wait for it to load a virtual machine.
Go into correct folder with cd ui

# How to test
To test the whole project, enter:
	“mvn test”
From the project directory.
To test individual modules, enter the given module, and run the same command. 

