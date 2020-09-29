package com.tictactoe_server;

interface DBController {

    // Init of the db controller (setting up constances)
    void init();

    // Searching the player in the db by name
    Player searchPlayer(String name);

    // updating the player by their id
    void updatePlayer(Player you, Player opponent, boolean won);

    // saving all changes to the db
    void save();

}