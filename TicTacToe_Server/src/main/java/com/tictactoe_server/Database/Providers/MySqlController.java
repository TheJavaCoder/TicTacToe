package com.tictactoe_server.Database.Providers;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tictactoe_server.Database.DBController;
import com.tictactoe_server.game.Player;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;


public class MySqlController implements DBController {

    private DatabaseConnectionProperties dbProperties;
    
    String propertiesPathAndFile; 
    String propertiesPath;
    
    public MySqlController() {
        try {
            propertiesPathAndFile = MySqlController.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            propertiesPath = propertiesPathAndFile.replaceAll(propertiesPathAndFile.substring(propertiesPathAndFile.lastIndexOf("/") + 1), "DatabaseConnectionProperties.yml");
        } catch (URISyntaxException ex) {
        }
    }
    
    public MySqlController(String path) {
        propertiesPath = path;
    }
    
    @Override
    public void init() {
        try {
            
            
            File file = new File(propertiesPath);
            
            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            
            dbProperties = om.readValue(file, DatabaseConnectionProperties.class);
            
            
        
        } catch (IOException | UnsupportedOperationException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addPlayer(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
