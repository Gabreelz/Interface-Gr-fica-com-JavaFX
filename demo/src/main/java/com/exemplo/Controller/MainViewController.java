package com.exemplo.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

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
        System.out.println("About menu item clicked");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
