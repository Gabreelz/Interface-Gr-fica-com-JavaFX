package com.exemplo.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.exemplo.App;
import com.exemplo.Util.Alerts;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{
    
    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemSellerAction() {
        System.out.println("Seller menu item clicked");
    }

    @FXML
    public void onMenuItemDepartmentAction() {
        System.out.println("Department menu item clicked");
    }

    @FXML
    public void onMenuItemAboutAction() {       
        loadView("/com/exemplo/About.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    // Tela About - 
    // Método para carregar uma nova view About dentro da interface principal
    private synchronized void loadView(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();
            
            Scene mainScene = App.getMainScene();
                
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
            
            // Guarda o menu principal
            Node mainMenu = mainVBox.getChildren().get(0);
            
            // Limpa todos os elementos do VBox principal
            mainVBox.getChildren().clear();
            
            // Adiciona novamente o menu principal para que ele permaneça fixo
            mainVBox.getChildren().add(mainMenu);
            
            // Adiciona todos os elementos da nova view carregada ao VBox principal
            mainVBox.getChildren().addAll(newVBox.getChildren());
        } 
        catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
        }
    }
}
