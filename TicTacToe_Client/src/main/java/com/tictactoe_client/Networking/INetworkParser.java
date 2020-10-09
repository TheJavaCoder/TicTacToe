package com.tictactoe_client.Networking;



public interface INetworkParser {
    
    
    public void parse(String message);
    
    
    
    public Move getMove(String message);
    
    
    
}
