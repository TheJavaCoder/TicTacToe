package com.tictactoe_server;

import java.util.ArrayList;


 // To be a db controller you have to implement these functions
public interface DBController {

    public ArrayList<String> requiredTables = new ArrayList<String>() { { add("users"); add("games"); } };
    
    public ArrayList<String> requiredColumns = new ArrayList<String> () { { add("UserName TEXT(50)"); add("PlayerOne Number, PlayerTwo Number, Win Number, Date Text"); } };
    
    // Init of the db controller (setting up constants for each db type and creating tables if necessary)
    void init();

    // Searching the player in the db by name
    Player getPlayer(String name);

    // updating the player by their id
    void updatePlayer(Player you, Player opponent, boolean won);

    // saving all changes to the db
    void save();

}