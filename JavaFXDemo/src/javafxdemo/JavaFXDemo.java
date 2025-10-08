/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 6316704
 */
public class JavaFXDemo extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Label bagStyle = new Label("Select Bag Style");
        Label quantityLabel = new Label("Select Quantity");
        
        ListView<String> bagListView = new ListView();
        bagListView.getItems().addAll(
            "Full Decorative", "Beaded", "Pirate Design",
            "Fringed", "Leather", "Plain");
        
        ComboBox<Integer> quantity = new ComboBox<>();
        quantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        Button orderBtn = new Button("Place Order");
        Button clearBtn = new Button("Clear Selections");
        
        HBox row1 = new HBox(10, bagStyle, bagListView, quantityLabel, quantity);
        HBox row2 = new HBox(10, orderBtn, clearBtn);
        VBox root = new VBox(10, row1, row2);
        
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Bag Order Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
