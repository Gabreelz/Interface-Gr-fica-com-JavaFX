package com.exemplo.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.Entities.Department;
import com.Services.DepartmentService;
import com.exemplo.App;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DepartmentController implements Initializable{

    private DepartmentService service;

    private ObservableList<Department> obsList;
    
    @FXML
    private TableView<Department> tableViewDepartment;

    @FXML
    private TableColumn<Department, Integer> tableColumnId;

    @FXML
    private TableColumn<Department, String> tableColumnName;

    @FXML
    private Button btNew;

    @FXML
    private void onBtNewAction() {
        System.out.println("onBtNewAction");
    }

    public void setDepartmentService(DepartmentService service) {
        this.service = service;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
    }

    private void initializeNodes() {
        // Configura a coluna "ID" da TableView para pegar o valor da propriedade "id" do objet
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        // Configura a coluna "Name" da TableView para pegar o valor da propriedade "name" do objeto
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) App.getMainScene().getWindow();

        // Faz com que a altura da TableView acompanhe dinamicamente a altura da janela
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
    }

    public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartment.setItems(obsList);
	}

    
}
