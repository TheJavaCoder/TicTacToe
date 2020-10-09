package com.tictactoe_server;

import com.tictactoe_server.Database.Providers.AccessController;
import com.tictactoe_server.Database.DBController;
import com.tictactoe_server.Networking.INetworkComposer;
import com.tictactoe_server.Networking.INetworkParser;
import com.tictactoe_server.Networking.JavaServerComposer;
import com.tictactoe_server.Networking.JavaServerParser;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class app extends Application {

    // Used to provide abstraction from a single database provider
    private static DBController db;

    private TextArea debug;

    INetworkComposer networkComposer = new JavaServerComposer();
    INetworkParser networkParser = new JavaServerParser();
    Object serverSocket;

    public void start(Stage s) {

        s.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                networkComposer.close(serverSocket);
                serverSocket = null;
            }
        });

        VBox vbox = new VBox();

        debug = new TextArea();
        debug.setPadding(new Insets(6));
        debug.setEditable(false);
        vbox.getChildren().add(debug);

        Button b = new Button("View leaderboard");
        b.setOnAction(e -> displayRecords());
        vbox.getChildren().add(b);
        b.setPadding(new Insets(6));
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 350, 200);

        s.setScene(scene);

        s.setTitle("TicTacToe Server");

        s.show();

        server();

    }

    public void server() {
        new Thread(() -> {

            serverSocket = networkComposer.createConnection("", 2000);

            Platform.runLater(() -> {

                debug.appendText("Starting Server...");
            });

            while (serverSocket != null) {
                Object socket = networkComposer.acceptConnection(serverSocket);

                Platform.runLater(() -> {

                    debug.appendText("\nConnected a client!");

                });
            }

        }).start();
    }

    public void displayRecords() {

        StackPane secondaryLayout = new StackPane();

        Scene secondaryWindow = new Scene(secondaryLayout, 230, 100);

        Stage newWindow = new Stage();

        newWindow.setTitle("Records");
        newWindow.setScene(secondaryWindow);

        newWindow.show();

    }

    // setup database controller
    public static void loadDatabase() {
        db = new AccessController();
        db.init();
        System.out.println("---------------------- Finished Loading ---------------------- \n");

    }

    public static void main(String[] args) {
        loadDatabase();
        launch(args);
    }

    public static DBController getDBController() {
        return db;
    }

}
