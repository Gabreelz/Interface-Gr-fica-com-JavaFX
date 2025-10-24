package com.exemplo.Controller;


import java.util.Locale;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;

public class ViewController {
    
    @FXML
    private TextField soma1;
    
    @FXML
    private TextField soma2;
    
    @FXML 
    private Button btnSomar;

    @FXML
    private Labeled labelResultado;

    @FXML
    public void onBtnSomarClick() {
        Locale.setDefault(Locale.US);
        double num1 = Double.parseDouble(soma1.getText());
        double num2 = Double.parseDouble(soma2.getText());
        double resultado = num1 + num2;
        labelResultado.setText(String.format("%.2f", resultado));
    }
}
