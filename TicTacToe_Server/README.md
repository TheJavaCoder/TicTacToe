# Tic-Tac-Toe Server

## First thoughts on classes and their responsibilities 

* app.java - the networking code and thread management and spawning off new game instances threads with the player sockets __(Mike Webb)__
* Player.java - object representing the player __(Bailey Costello)__
  * public int id - the unique id of the player
  * public String name - the name of the player
  * public ArrayList<**GameResult**> gameHistory - the objects representing the history of the player 
* GameResult - object that represents a past game __(Bailey Costello)__
  * public String opponent - the name of the player that was played
  * public Date date - the time that the game was played
  * public boolean won - the result of the game
* DBController.java - interface for db abstraction __(Bailey Costello)__
  * METHODS:
    * void init() - connection method
    * **Player** searchPlayer(string name) - find a user in the db and create if non-existent
    * void updatePlayer(**Player** you, **Player** opponent, boolean won) - add a player record with your username and your opponent if you won or not with date of the match 
* AccessController __(implements DBController)__ - the accessDB specific code to preform the desired functions __(Thanh Nguyen)__
  * Implement the described functions in DBController.java
* TicTacToe __(implements runnable)__ - class to be used for the game __(Bailey Costello)__
  * METHODS:
    * TicTacToe (Socket p1, Socket p2)
    * run() - to start the game
    * askPlayerForInput(socket) - asks the user for their move and checks it. 
    * checkForWin() - checks the board for if someone wins evermove after 3 tie possible after 9 moves maybe before?

