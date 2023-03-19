# BattleShip_Game

## About
This game was built using Gradle and utilizes javaFX for the UI. If you have gradle installed on your system you should be able to use the commands "gradle build" and "gradle run". If you don't have gradle installed you should still be able to run the application with the "./gradlew build" and "./gradlew run" commands. However, these two later commands would require you to be located in the root folder of the project.

## Playing the game
Once the application is running you get a choice to play either a 2-player game or versus the computer. The first thing you have to do after you have made your choise is to place your ships. Select a ship on the right and choose to place it horizontally or vertically. Then click on a cell. The ship will expand downwards or to the right depending on your orientation choice. You can place on ship of each size. When the board setup is complete the game starts. Now you try to find the opponent's ships by selecting cells on their board. The cell will turn blue if you missed and red if you got a hit. If you hit, you can select a new cell. The game is over when one player has lost all their ships.

## Documentation
For documentation of the project i have used javadoc. To view the documentation you can open the file "index.html" file in your browser. The file is stored in app/build/docs/javadoc

## Improvements
If I had more time to work on this projects I would have focused on writing more test cases. Especially to test the functionality of the classes in package uiComponents. They are of course tested by running and trying the program, but there are no unit tests for them. I would also have tried to differentiate even more between the game logic and the UI. Other than that I would have liked to improve the AI. As for now it checks adjacent cells around its latest hit, but it doesn't go back to an old hit and check the the adjacent cells that it didn't get to check before.