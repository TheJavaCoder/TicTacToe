package com.tictactoe_server.game;

import com.tictactoe_server.Database.GameResult;
import java.util.ArrayList;

public class Player {

    // The unique id of the player in the db
    public int id;

    // The name of the player
    public String name;

    // list of the different games the user has played
    public ArrayList<GameResult> gameHistory;
    
    public double winPercentage() {
        
        double counter = 0;
        
        for(GameResult gr : gameHistory) {
            if(gr.won) {
                counter++;
            }
        }
        
        return counter / gameHistory.size();
        
    }

}
