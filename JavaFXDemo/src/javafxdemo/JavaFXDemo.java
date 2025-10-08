/* https://github.com/theta148/Lab05-MihirPatel
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafxdemo;

import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick 1 or 2 for a task");
        
        int num = scanner.nextInt();
        
        if (num == 1) {
            Task1 task1 = new Task1();
            
            VBox root = new VBox(task1.getView());
       
            Scene scene = new Scene(root, 800, 400);
            primaryStage.setTitle("Bag Order Form");
            primaryStage.setScene(scene);
            primaryStage.show();
        } else if (num == 2) {
            Task2 task2 = new Task2();
            
            VBox root = new VBox(task2.getView());
       
            Scene scene = new Scene(root, 800, 400);
            primaryStage.setTitle("Order Calculator");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }
}
