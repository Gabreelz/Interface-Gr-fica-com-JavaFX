package com.exemplo.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewController {
    
    @FXML
    private Button myButton;

    @FXML
    public void initialize() {
        System.out.println("ViewController initialized");
    }
}
