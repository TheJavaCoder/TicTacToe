package com.tictactoe_server.Networking;

import com.tictactoe_server.game.Move;
import com.tictactoe_server.game.Player;


public interface INetworkParser {
    
    
    public void parse(String message);
    
    public Player getPlayer(String message);
    
    public Move getMove(String message);
    
    
    
}
