package com.tictactoe_server;

import java.util.ArrayList;

public class Player {

    // The unique id of the player in the db
    public int id;

    // The name of the player
    public String name;

    // list of the different games the user has played
    public ArrayList<GameResult> gameHistory;

}
