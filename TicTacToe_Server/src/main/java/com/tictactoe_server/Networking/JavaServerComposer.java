/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tictactoe_server.Networking;

import com.tictactoe_server.game.Move;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bapco
 */
public class JavaServerComposer implements INetworkComposer{

    
    @Override
    public String sendGameHistoryData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sendMoveData(Move m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sendIllegalMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sendGameReadyState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sendGameFinishedState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sendUsername() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void compose(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object createConnection(String server, int port) {
        
        try {
            ServerSocket connection = new ServerSocket(port);
            
            return connection;
        } catch (IOException ex) {
        
            return null;
        }
    }
    
    public Object acceptConnection(Object server) {
        try {
            return ((ServerSocket) server).accept();
        } catch (IOException ex) {
            Logger.getLogger(JavaServerComposer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void close(Object connection) {
        try {
            ((ServerSocket)connection).close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
