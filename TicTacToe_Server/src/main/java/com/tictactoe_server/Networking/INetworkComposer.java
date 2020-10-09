/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tictactoe_server.Networking;

import com.tictactoe_server.game.Move;

/**
 *
 * @author bapco
 */
public interface INetworkComposer {
    
    public void close(Object connection);
    
    public String sendGameHistoryData();
    
    public String sendMoveData(Move m);
    
    public String sendIllegalMove();
    
    public String sendGameReadyState();
    
    public String sendGameFinishedState();
    
    public String sendUsername();
    
    public void compose(String s);
    
    public Object createConnection(String server, int port);
    
    public Object acceptConnection(Object server); 
    
}
