package com.exemplo.Controller;


import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.exemplo.Util.Constraints;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;

public class ViewController implements Initializable{
    
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
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Constraints.setTextFieldDouble(soma1);
        Constraints.setTextFieldDouble(soma2);
        Constraints.setTextFieldMaxLength(soma1, 10);
        Constraints.setTextFieldMaxLength(soma2, 10);
    }    
}
