/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public class TicTacToe_Client extends Application {
    //Create TicTacToe Board for the scene
    private Parent createContent()
    {
        Pane root = new Pane();
        root.setPrefSize(450, 450);
        
        for (int i = 0; i < 3; i++){
            for (int j =  0; j < 3; j++){
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
        TextField tfName = new TextField();
        Label lbWinningRate = new Label("Check your winning rate");
        Button btWinningRate = new Button("Check");
        TextField tfWinningRate = new TextField();
        Button btPlay = new Button("Play");
        btPlay.setOnAction(e -> primaryStage.setScene(new Scene(createContent())));
        
        tfName.setAlignment(Pos.CENTER);
        
        GridPane gridpane = new GridPane();
        gridpane.add(lbName, 0, 0);
        gridpane.add(tfName, 1, 0);
        gridpane.add(lbWinningRate, 0 ,1);
        gridpane.add(btWinningRate, 1, 1);
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(gridpane, tfWinningRate, btPlay);
        
        Scene scene = new Scene(vbox, 450, 450);
        
        primaryStage.setTitle("Login - TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    //Create each Tile for TicTacToe Board
    public class Tile extends StackPane{
        private Text text = new Text();
        public Tile(){
            Rectangle border = new Rectangle(150, 150);
            border.setFill(null);
            border.setStroke(Color.BLACK);
            text.setFont(Font.font(50));
            
            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);
            //Set what happens when click a tile
            setOnMouseClicked(event -> {
                  if (event.getButton() == MouseButton.PRIMARY){
                      drawX();
                  }
                  else if (event.getButton() == MouseButton.SECONDARY)
                      drawO();
                  
            });
        }
    
        private void drawX(){
            text.setText("X");
            }
        private void drawO(){
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
    

