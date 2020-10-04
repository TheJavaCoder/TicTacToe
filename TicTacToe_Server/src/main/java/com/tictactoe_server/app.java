package com.tictactoe_server;

import com.tictactoe_server.Database.Providers.AccessController;
import com.tictactoe_server.Database.DBController;
import javafx.application.Application;
import javafx.stage.Stage;

public class app extends Application {

    // Used to provide abstraction from a single database provider
    private static DBController db;

    public void start(Stage s) {
        init();

    }

    // setup database controller
    public void init() {
        db = new AccessController();
        db.init();
        System.out.println("---------------------- Finished Loading ---------------------- \n");

    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static DBController getDBController() {
        return db;
    }

}
