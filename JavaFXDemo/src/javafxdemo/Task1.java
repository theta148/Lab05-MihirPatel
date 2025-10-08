/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxdemo;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author 6316704
 */
public class Task1 {
    private VBox root;
    private HBox row1;
    private HBox row2;
    private HBox row3;
    private Label bagStyle;
    private Label quantityLabel;
    
    private ListView<String> bagListView;
    private Button orderBtn;
    private Button clearBtn;
    private ComboBox<Integer> quantity; 
    
    private RadioButton small;
    private RadioButton medium;
    private RadioButton large; 
    private ToggleGroup sizeGroup;
    
    private String message;
    
    public Task1(){
        bagStyle = new Label("Select Bag Style: ");
        quantityLabel = new Label("Select Quantity: ");
        
        bagListView = new ListView();
        bagListView.getItems().addAll(
            "Full Decorative", "Beaded", "Pirate Design",
            "Fringed", "Leather", "Plain");
        
        quantity = new ComboBox<>();
        quantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        small = new RadioButton("Small");
        medium = new RadioButton("Medium");
        large = new RadioButton("Large");
        
        sizeGroup = new ToggleGroup();
        small.setToggleGroup(sizeGroup);
        medium.setToggleGroup(sizeGroup);
        large.setToggleGroup(sizeGroup);
        
        orderBtn = new Button("Place Order");
        orderBtn.setOnAction(e -> Order());
        
        clearBtn = new Button("Clear Selections");
        clearBtn.setOnAction(e -> Clear());
        
        row1 = new HBox(10, bagStyle, bagListView, quantityLabel, quantity);
        row2 = new HBox(10, small, medium, large);
        row3 = new HBox(10, orderBtn, clearBtn);
        bagStyle.setTranslateY(30);
        quantityLabel.setTranslateY(30);
        root = new VBox(10, row1, row2, row3);
    }

    public VBox getView() {
        return root;
    }
    
    private void Order() {
        if (quantity.getValue() == 1) {
            message = String.format("You ordered 1 %s %s Bag.",
                sizeGroup.getSelectedToggle().getUserData(), bagListView.getSelectionModel().getSelectedItem());
        } else {
            message = String.format("You ordered %d %s %s Bags.", 
                    quantity.getValue(), 
                    sizeGroup.getSelectedToggle().getUserData(), 
                    bagListView.getSelectionModel().getSelectedItem());
        }
        
        System.out.println(message);
    }

    private void Clear() {
        bagListView.getSelectionModel().clearSelection();
        small.setSelected(false);
        medium.setSelected(false);
        large.setSelected(false);
        quantity.getItems().clear();
    }
}
