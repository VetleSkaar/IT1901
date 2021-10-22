# Release 2

For this release, The main contributions is the new persistence module, connected persistence with login-controller, ensured test-coverage with jacoco and checkstyle plugin, and added new Core logic and tests for blackjack-game to be implemented later. 

There has been implemented a new window for creating a new user that shows up when clicking on the “Create New User”-button.

All the README.md’s have been changed, and we also added an architecture diagram displaying the project.

Along with writing code logic, we created Junit tests to test our code to ensure proper code quality.

To check the quality, we installed Jacoco in order to see what our degree of testing actually covered. This helped us find methods in our coding that were not tested, and then we wrote suitable tests for them.

To ensure consistency, we installed the checkstyle plugin to ensure that the code was uniform across all our files.

In order to spot bugs that our IDE’s did not pickup, we installed the spotbugs plugin.

On the feedback we got from Release 1, we decided to reorganize our project. This meant separating our core logic from the persistence code. In release 1, we had both our files in a folder called core/src/main/java/core.
Now we moved it to: core/src/main/java/casino/core and core/src/main/java/casino/json We also corrected the structure in the ui module.

As per release 2, The runnable program is solely a user database. The user is able to create a new user and store this user information in a json file in the resources module. The user will then be able to log on with this user information.
 
There are still some checkstyle warnings. Many of these have been addressed, The rest will be addressed in later releases. 

Test coverage is not at 100% for release 2. Changes in core-logic are planned for the next release, as the blackjack logic is connected to UI, and the main runnable program. For the next release, the group will decide how to best tackle this issue.  

For tackling issues, we kept making new branches as we found out that worked best for us.

We also tried some physical pair programming, and digital. We found that digital pair programming worked just as well.
