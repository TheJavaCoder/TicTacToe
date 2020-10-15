/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tictactoe.network;

import java.net.*;
import java.io.*;
import java.util.concurrent.*;


/**
 *
 * @author miked
 */
public class running {
  final static int PORT = 500;


  //using the find socket but would have to be made FINAL
findSocket socket1 = new findSocket();
int Porti = socket1.returnSocket(); 



  public static void main(String[] args) {
//sets up a thread pool of 50 -- should work for game
   ExecutorService pool = Executors.newFixedThreadPool(50);

   try (ServerSocket server = new ServerSocket(PORT)) {
     while (true) {
       try {
         Socket connection = server.accept();
         
         Callable<Void> task = new runTask(connection);
         pool.submit(task);
       } catch (IOException ex) {}
     }
    } catch (IOException ex) {
      System.err.println("Couldn't start server");
    }
  }

  private static class runTask implements Callable<Void> {

    private Socket connection;

    runTask(Socket connection) {
      this.connection = connection;
    }

    @Override
    public Void call() throws IOException {
      try {
          //sets up input and output streams
        InputStream in = new BufferedInputStream(connection.getInputStream());
        OutputStream out = connection.getOutputStream();
        int c;
while ((c = in.read()) != -1) {
          out.write(c);
          out.flush();
        }
      } catch (IOException ex) {
        System.err.println(ex);
      } finally {
        connection.close();
      }
      return null;
    }
  }
}


    
