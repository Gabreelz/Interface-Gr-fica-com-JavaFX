package com.exemplo.Controller;

import com.exemplo.Util.Alerts;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ViewController {
    
    @FXML
    private Button myButton;

    @FXML
    public void initialize() {
        Alerts.showAlert(
        "Aviso importante",           // title
        "Verifique suas configurações", // header
        "Certifique-se de que todos os campos foram preenchidos corretamente.", // content
        Alert.AlertType.INFORMATION  // tipo de alerta
    );
    }
}
