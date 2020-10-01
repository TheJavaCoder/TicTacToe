package com.tictactoe_server.Database.Providers;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tictactoe_server.Database.DBController;
import com.tictactoe_server.game.Player;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;

public class MySqlController implements DBController {

    private DatabaseConnectionProperties dbProperties;

    String propertiesPathAndFile;
    String propertiesPath;

    private Connection conn;

    public MySqlController() {
        try {
            propertiesPathAndFile = MySqlController.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            propertiesPath = propertiesPathAndFile.replaceAll(propertiesPathAndFile.substring(propertiesPathAndFile.lastIndexOf("/") + 1), "DatabaseConnectionProperties.yml");
        } catch (URISyntaxException ex) {
            System.out.println("Couldn't find the DatabaseConnectionProperties.yml file");
        }
    }

    public MySqlController(String path) {
        propertiesPath = path;
    }

    @Override
    public void init() {
        try {

            // Pull the db configuration
            File file = new File(propertiesPath);

            ObjectMapper om = new ObjectMapper(new YAMLFactory());

            // Parse that shit
            dbProperties = om.readValue(file, DatabaseConnectionProperties.class);
            
            System.out.println("Attempting to connect to: '" + dbProperties.host + "' on port: " + dbProperties.port);

        } catch (IOException | UnsupportedOperationException ex) {
            // Whoops.. No file or couldn't parse the file
            if (ex instanceof IOException) {
                System.out.println("Couldn't find the DatabaseConnectionProperties.yml file");
            } else if (ex instanceof UnsupportedOperationException){
                System.out.println("Issue with the DatabaseConnectionProperties.yml referance the example file");
            }
        }
    }

    @Override
    public void addPlayer(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPlayer(int id) {
        return "";
    }
    
    @Override
    public Player getPlayer(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateGameStats(Player you, Player opponent, boolean won) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
