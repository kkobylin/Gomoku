# Gomoku Game
> Gomoku Game for 2 players write in Java language. Two instances are communicating with each other 
by asynchronous messages and JMS Queue via Glassfish server. Project is based on MVC pattern.

## Technologies
* Java 11
* GlassFish 5
* JMS Queue
* Java FX
* SceneBuilder 10

## Setup
To run the game firstly on one instance of Eclipse in Main file, "playerWhite" variable should be set as True
,on the second (for example in another workspace) should be set as False. After launching the game, appropriate
communicates will tell which player start the game. After two first moves, red rectangle on the last stone
will show whose turn is now.

### Rules
Game is being played on 15x15 board.
White plays first, and players alternate in placing a stone of their color on an empty intersection.
The winner is the first player to get an unbroken row of five stones horizontally, vertically, 
or diagonally. In situation when board is full there is a draw.

