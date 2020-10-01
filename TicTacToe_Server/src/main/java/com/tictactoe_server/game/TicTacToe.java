/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tictactoe_server.game;

// The main game class
import java.net.Socket;
import java.util.ArrayList;

public class TicTacToe implements Runnable{

    ArrayList<Player> players;
    
    public TicTacToe(Socket p1, Socket p2) {
    
    }

    public TicTacToe(Player p1, Player p2) {
        players.add(p1);
        players.add(p2);
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
