/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxdemo;

import java.util.Map;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author 6316704
 */ 
public class Task2 {
    private VBox root;
    
    private final Map<String, Double> beverages = Map.of(
            "Coffee", 2.50, "Tea", 2.00, "Soda", 1.75, "Water", 2.95,
            "Milk", 1.5, "Juice", 2.5
    );
    private final Map<String, Double> appetizers = Map.of(
            "Soup", 4.50, "Salad", 3.75, "Spring Rolls", 5.25, 
            "Garlic Bread", 3.00, "Chips and Salsa", 6.95
    );
    private final Map<String, Double> mainCourses = Map.of(
            "Steak", 15.00, "Grilled Chicken", 13.50, "Chicken Alfredo", 13.95,
            "Turkey Club", 11.90, "Shrimp Scampi", 18.99,"Pasta", 11.75, 
            "Fish and Chips", 12.25
    );
    private final Map<String, Double> desserts = Map.of(
            "Apple Pie", 3.75, "Carrot Cake", 4.50, "Mid Pie", 4.75, 
            "Pudding", 3.25, "Apple Crisp", 5.98
    );
    
    private ComboBox<String> beverageBox;
    private ComboBox<String> appetizerBox;
    private ComboBox<String> mainCourseBox;
    private ComboBox<String> dessertBox;
    
    private Slider tipSlider;
    private Label subtotalLabel;
    private Label taxLabel;
    private Label tipLabel;
    private Label totalLabel;
    
    public Task2() {
        beverageBox = createComboBox(beverages);
        appetizerBox = createComboBox(appetizers);
        mainCourseBox = createComboBox(mainCourses);
        dessertBox = createComboBox(desserts);
        
        tipSlider = new Slider(0.0, 20.0, 0.0); 
        tipSlider.setShowTickMarks(true);
        tipSlider.setShowTickLabels(true);
        tipSlider.setMajorTickUnit(5);
        tipSlider.setBlockIncrement(1);
        
        Label tipPercentLabel = new Label("Tip: 0%");
        tipSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            tipPercentLabel.setText(String.format("Tip: %.0f%%", newVal.doubleValue()));
            updateBill();
        });
        
        subtotalLabel = new Label("$0.00");
        taxLabel = new Label("$0.00");
        tipLabel = new Label("$0.00");
        totalLabel = new Label("$0.00");
        
        Button clearBtn = new Button("Clear Bill");
        clearBtn.setOnAction(e -> clearBill());

        GridPane menuGrid = new GridPane();
        menuGrid.setHgap(10);
        menuGrid.setVgap(10);
        menuGrid.add(new Label("Beverage:"), 0, 0);
        menuGrid.add(beverageBox, 1, 0);
        menuGrid.add(new Label("Appetizer:"), 0, 1);
        menuGrid.add(appetizerBox, 1, 1);
        menuGrid.add(new Label("Main Course:"), 0, 2);
        menuGrid.add(mainCourseBox, 1, 2);
        menuGrid.add(new Label("Dessert:"), 0, 3);
        menuGrid.add(dessertBox, 1, 3);

        GridPane billGrid = new GridPane();
        billGrid.setHgap(10);
        billGrid.setVgap(10);
        billGrid.add(new Label("Subtotal:"), 0, 0);
        billGrid.add(subtotalLabel, 1, 0);
        billGrid.add(new Label("Tax (10%):"), 0, 1);
        billGrid.add(taxLabel, 1, 1);
        billGrid.add(tipPercentLabel, 0, 2);
        billGrid.add(tipLabel, 1, 2);
        billGrid.add(new Label("Total:"), 0, 3);
        billGrid.add(totalLabel, 1, 3);
                
        root = new VBox(20);
        root.getChildren().addAll(menuGrid, tipSlider, billGrid, clearBtn);
    }
    
    public VBox getView() {
        return root;
    }
    
    private ComboBox<String> createComboBox(Map<String, Double> items) {
        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll(items.keySet());
        combo.setValue("None");
        combo.setPrefWidth(150);
        return combo;
    }
    
    private void updateBill() {
        double subtotal = beverages.get(beverageBox.getValue())
                + appetizers.get(appetizerBox.getValue())
                + mainCourses.get(mainCourseBox.getValue())
                + desserts.get(dessertBox.getValue());

        double tax = subtotal * 0.10;
        double tipPercent = tipSlider.getValue() / 100.0;
        double tip = subtotal * tipPercent;
        double total = subtotal + tax + tip;

        subtotalLabel.setText(String.format("$%.2f", subtotal));
        taxLabel.setText(String.format("$%.2f", tax));
        tipLabel.setText(String.format("$%.2f", tip));
        totalLabel.setText(String.format("$%.2f", total));
    }
    
    private void clearBill() {
        beverageBox.setValue("");
        appetizerBox.setValue("");
        mainCourseBox.setValue("");
        dessertBox.setValue("");
        tipSlider.setValue(0.0);
        subtotalLabel.setText("$0.00");
        taxLabel.setText("$0.00");
        tipLabel.setText("$0.00");
        totalLabel.setText("$0.00");
    }
}
