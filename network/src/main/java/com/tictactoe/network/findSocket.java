/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tictactoe.network;

import java.io.*;
import java.net.*;

/**
 *
 * @author miked
 */
 


public class findSocket {
    public int port;
   
    public int returnSocket(){
    for (int i = 1; i <= 65535; i++) {
    port = i;

      try {
        // the next line will fail and drop into the catch block if
        // there is already a server running on the port
        ServerSocket server = new ServerSocket(port);
      } catch (IOException ex) {
        System.out.println("There is a server on port " + port + ".");
      }
    }
    port++;
    return port;
  
    }
}

