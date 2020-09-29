package com.tictactoe_server;

import javafx.application.Application;
import javafx.stage.Stage;

public class app extends Application{

    public static DBController db;
    
    public void start(Stage s) {
        init();
        
    }
    
    public void init() {
        db = new AccessController();
        db.init();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}

