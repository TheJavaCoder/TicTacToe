package com.tictactoe_server;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccessController implements DBController {

    String dataFilePath = "C:/Data/Test/";
    String dataFile = "TicTacToe.accdb";

    private Connection conn;

    @Override
    public void init() {
        try {
            // create the directory if it doesn't exist.
            new File(dataFilePath).mkdirs();

            // Attempt to load the driver...
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Loaded Access Driver!");

            // Attempting to connect to the DB
            conn = DriverManager.getConnection("jdbc:ucanaccess://" + dataFilePath + dataFile + ";newdatabaseversion=V2010");
            System.out.println("Access Database connected!");

            // Building the statement object
            
            // Get meta data
            DatabaseMetaData dbMeta = conn.getMetaData();

            // For loop through the required tables
            for (int i = 0; i < requiredTables.size(); i++) {

                // Getting the table name
                String t = requiredTables.get(i);

                // Checking if the table exists
                ResultSet results = dbMeta.getTables(null, null, t, new String[]{"TABLE"});

                // Whoops it exists
                if (results.next()) {
                    System.out.println(t + " table already exists... Skipping");
                } else {
                    // Need to create the table 
                    String queryBuilder = "CREATE TABLE " + t + " (ID COUNTER PRIMARY KEY, ";

                    // Need to grab the column requirements.
                    queryBuilder = queryBuilder + requiredColumns.get(i) + ")";

                    conn.createStatement().executeUpdate(queryBuilder);

                    System.out.println("Created Table: [" + t + "]");
                }
            }

        } catch (Exception e) {
            System.out.println(" Make sure the ucanaccess.jdbcd driver is configured in your project... ");
        }
    }

    // Adds a player to the user table
    @Override
    public void addPlayer(String name) {
        try {
            String q = "INSERT INTO users (UserName) VALUES (?)";
            PreparedStatement pst = conn.prepareStatement(q);
            pst.setString(1, name);
            
            System.out.println("Added user: " + name);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
        //   6. Add the gameresults to the player object and return it
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Update game status - function that is called twice per game to save the player's state
    @Override
    public void updateGameStats(Player you, Player opponent, boolean won) {

        // Steps: 
        //   1. SQL command to insert a new row with your player.id, oppenent's player.id, boolean value, and date of match 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
