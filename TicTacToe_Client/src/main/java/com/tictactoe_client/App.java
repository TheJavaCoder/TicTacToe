/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tictactoe_client;

import com.tictactoe_client.Networking.INetworkComposer;
import com.tictactoe_client.Networking.INetworkParser;
import com.tictactoe_client.Networking.JavaServerComposer;
import com.tictactoe_client.Networking.JavaServerParser;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Thanh Nguyen
 */
public class App extends Application {
    //Create TicTacToe Board for the scene

    TextField tfName;
    Socket socket;

    // Build the composer and parser of the connection to the server.. 
    INetworkComposer networkComposer = new JavaServerComposer();
    INetworkParser networkParser = new JavaServerParser();

    Object serverConnection;

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(450, 450);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 150);
                tile.setTranslateY(i * 150);
                root.getChildren().add(tile);
            }
        }
        return root;
    }

    @Override
    public void start(Stage primaryStage) {
        Label lbName = new Label("Please enter your name");
        tfName = new TextField();
        TextField serverAddress = new TextField("127.0.0.1");
        Label lbServerAddress = new Label("Enter server address");

        serverAddress.setAlignment(Pos.CENTER);

        Button btPlay = new Button("Play");

        // Asks for server connection string
        btPlay.setOnAction(e -> attemptServerConnection(primaryStage, serverAddress.getText()));

        tfName.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(8));
        vbox.getChildren().addAll(lbName, tfName, lbServerAddress, serverAddress, btPlay);

        Scene scene = new Scene(vbox, 300, 125);

        primaryStage.setTitle("Login - TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // new scene that will attempt the server connection
    public void attemptServerConnection(Stage s, String connectionString) {

        VBox enterConnectionAddress = new VBox();
        enterConnectionAddress.setAlignment(Pos.CENTER);
        enterConnectionAddress.setPadding(new Insets(5));

        Stage newWindow = new Stage();

        Label connecting = new Label("Attempting to connect to the server");
        enterConnectionAddress.getChildren().add(connecting);

        Scene secondaryWindow = new Scene(enterConnectionAddress, 300, 100);
        newWindow.setTitle("");
        newWindow.setScene(secondaryWindow);
        newWindow.show();

        Platform.runLater(() -> {
            serverConnection = networkComposer.createConnection(connectionString, 2000);

            if (serverConnection == null) {
                connecting.setText("Couldn't connect, confirm server address.");
                
                Platform.runLater(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    newWindow.close();
                });
                 
                
            }else {
                connecting.setText("Connected!");
            }
                
            
        });

    }

    //Create each Tile for TicTacToe Board
    public class Tile extends StackPane {

        private Text text = new Text();

        public Tile() {
            Rectangle border = new Rectangle(150, 150);
            border.setFill(null);
            border.setStroke(Color.BLACK);
            text.setFont(Font.font(50));

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);
            //Set what happens when click a tile
            setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    drawX();
                } else if (event.getButton() == MouseButton.SECONDARY) {
                    drawO();
                }

            });
        }

        private void drawX() {
            text.setText("X");
        }

        private void drawO() {
            text.setText("O");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
