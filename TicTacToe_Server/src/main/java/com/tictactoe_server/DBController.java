package com.tictactoe_server;


 // To be a db controller you have to implement these functions
interface DBController {

    // Init of the db controller (setting up constants for each db type and creating tables if necessary)
    void init();

    // Searching the player in the db by name
    Player getPlayer(String name);

    // updating the player by their id
    void updatePlayer(Player you, Player opponent, boolean won);

    // saving all changes to the db
    void save();

}