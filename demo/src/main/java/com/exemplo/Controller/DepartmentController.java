package com.exemplo.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.Entities.Department;
import com.Services.DepartmentService;
import com.exemplo.App;
import com.exemplo.Util.Alerts;
import com.exemplo.Util.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
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
    private void onBtNewAction(ActionEvent event) {
        Stage parentStage = utils.atualStage(event);
        Department obj = new Department();
        createDialogForm(obj,"/com/exemplo/DepartmentForm.fxml", parentStage);
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

    private void createDialogForm(Department obj, String absoluteName, Stage parentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            Pane pane = loader.load();

            DepartmentFormController controller = loader.getController();
            controller.setEntity(obj);
            controller.setDepartmentService(new DepartmentService());
            controller.updateFormData();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Enter Department data");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();

        } catch (Exception e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
        }
    }

    
}
