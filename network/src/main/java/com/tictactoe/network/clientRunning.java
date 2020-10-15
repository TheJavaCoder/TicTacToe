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
public class clientRunning {

  public static final String SERVER = "localhost";
  public static final int PORT = 500;
  public static final int TIMEOUT = 2400000;

  public static void main(String[] args) {

    Socket socket = null;
    try {
      socket = new Socket(SERVER, PORT);
socket.setSoTimeout(TIMEOUT);
      OutputStream out = socket.getOutputStream();
      Writer writer = new OutputStreamWriter(out, "UTF-8");
      writer = new BufferedWriter(writer);
      InputStream in = socket.getInputStream();
      BufferedReader reader = new BufferedReader(
          new InputStreamReader(in, "UTF-8"));

      for (String word : args) {
        //tictactoe(variables);
      }

      writer.write("quit\r\n");
      writer.flush();
    } catch (IOException ex) {
      System.err.println(ex);
    } finally { // dispose
      if (socket != null) {
        try {
          socket.close();
        } catch (IOException ex) {
          // ignore
        }
      }

    }
  }
    
}
