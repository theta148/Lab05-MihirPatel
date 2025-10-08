/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxdemo;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

/**
 *
 * @author 6316704
 */
public class Task2 {
    private VBox root;
    private ComboBox<String> beverages;
    private ComboBox<String> appetizers;
    private ComboBox<String> mainCourses;
    private ComboBox<String> desserts;
    
    private Slider tipSlider;
    
    public Task2() {
        
    }
    
    public VBox getView() {
        return root;
    }
}
