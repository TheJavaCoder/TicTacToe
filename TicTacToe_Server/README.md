# Tic-Tac-Toe Server

## First thoughts on classes and their responsibilities 
(Please send me an email on your thoughts or questions)

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
    * void addPlayer(string name) - adds a player to the user table
    * **Player** getPlayer(string name) - find a user in the db and create if non-existent
    * void updateGameStats(**Player** you, **Player** opponent, boolean won) - add a player record with your username and your opponent if you won or not with date of the match 
    * void save() - will be unused in our implementation but a nice to have in the future if other Databases use it.

* AccessController __(implements DBController)__ - the accessDB specific code to preform the desired functions __(Thanh Nguyen)__
  * Implement the described functions in DBController.java
  * Loaded Driver and connect to the database.
  * void checkPlayer(name) - check if a player is already in the database
      If yes: return to the game, and the player can winning rate/ game
      If no: void newPlayer(name): create new playerID (get the highest playerID + 1) and name
  * void newGame(): when 1 or two player hit "START" to start a game, create new attribute for Games table, include gameID, playerID 1, playerID 2
  * void winning(): get the result from updateGameStates then update database, winning mark "1", losing mark "0"
  * winningRate(name): return winning rate
  
  
* TicTacToe __(implements runnable)__ - class to be used for the game __(Bailey Costello)__
  * METHODS:
    * TicTacToe (Socket p1, Socket p2) - to pass the player's sockets through to this thread
    * run() - to start the game
    * askPlayerForInput(socket) - asks the user for their move and checks it. Only returns when the player has selected a valid move.
    * checkForWin() - checks the board for if someone wins evermove after 3 tie possible after 9 moves maybe before?

