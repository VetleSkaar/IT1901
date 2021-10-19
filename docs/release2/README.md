# Release 2

For this release, we worked further on the game logic and made improvements to the UI.

There has been implemented a new window for creating a new user that shows up when clicking on the “Create New User”-button.

All the README.md’s have been changed, and we also added an architecture diagram displaying the project.

For tackling issues, we kept making new branches as we found out that worked best for us.

We also tried some pair programming in real life, and also over discord. We found that pair programming over discord worked just as well.

Along with writing code logic, we created Junit tests to test our code to ensure proper code quality.

To check that quality, we installed Jacoco in order to see what our degree of testing actually covered. This helped us find methods in our coding that were not tested, and then we wrote suitable tests for them.

To ensure consistency, we installed the checkstyle plugin to ensure that the code was uniform across all our files.

In order to spot bugs that our IDE’s did not pickup, we installed the spotbugs plugin.

On the feedback we got from Release 1, we decided to reorganize our project. This meant separating our core logic from the persistence code. In release 1, we had both our files in a folder called core/src/main/java/core.

Now we moved it to:
core/src/main/java/casino/core and core/src/main/java/casino/json
We also corrected the structure in the ui module.
