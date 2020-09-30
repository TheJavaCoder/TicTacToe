package com.tictactoe_server;

import javafx.application.Application;
import javafx.stage.Stage;

public class app extends Application {

    // Used to provide abstraction from a single database provider
    public static DBController db;

    public void start(Stage s) {
        init();

    }

    // setup database controller
    public void init() {
        db = new AccessController();
        db.init();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
