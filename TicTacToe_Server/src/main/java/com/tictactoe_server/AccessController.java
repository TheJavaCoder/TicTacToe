
package com.tictactoe_server;

/**
 *
 * @author bapco
 */
public class AccessController implements DBController{

    String dataFilePath = "C:/Data/Test/TicTacToe.accdb";
    
    @Override
    public void init() {
        
        // Steps:
        //   1. Check if the database tables exists
        //   2. If not create the right tables
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Returns a player object with their game history
    @Override
    public Player getPlayer(String name) {
        
        // Steps:
        //   1. Query the player's table with their name
        //   2. Return the row
        //   3. create player object i.e Player player = new Player();
        //   4. Query the games table with the player's id and return the rows
        //   5. Build new ArrayList<GameResults>
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Update player - function that is called twice per game to save the player's state
    @Override
    public void updatePlayer(Player you, Player opponent, boolean won) {
        
        // Steps: 
        //   1. SQL command to insert a new row with your player.id, oppenent's player.id, boolean value, and date of match 
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
