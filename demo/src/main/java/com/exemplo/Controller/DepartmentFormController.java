package com.exemplo.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.Entities.Department;
import com.Services.DepartmentService;
import com.exemplo.Util.Alerts;
import com.exemplo.Util.Constraints;
import com.exemplo.Util.utils;
import com.exemplo.db.DbException;
import com.exemplo.model.exception.Validation_exception;
import com.listeners.DataChangeListener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable {
    
    private Department entity;

    private DepartmentService service;

    private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private Label lblError;

    @FXML
    private Button btSave;

    @FXML
    private Button btCancel;

    public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}

    public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}

    @FXML
	public void onBtSaveAction(ActionEvent event) {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		try {
			entity = getFormData();
			service.safeOrUpdate(entity);
            notifyDataChangeListeners();
			utils.atualStage(event).close();
		}
        catch (Validation_exception e){
            set
        }
		catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	@FXML
	public void onBtCancelAction(ActionEvent event) {
		utils.atualStage(event);
	}

    private Department getFormData() {
		Department obj = new Department();
		
        Validation_exception exception = new Validation_exception("Validation error");

		obj.setId(utils.tryParseToInt(txtId.getText()));

        if(txtName.getText() == null || txtName.getText().trim.equals(  "")){
            exception.addErros("name", "Field can't be empty");
        }

		obj.setName(txtName.getText()); 

        if (exception.getErrors().size() > 0) {
			throw exception;
		}
		
		return obj;
	}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
    }

    private void initializeNodes() {
        Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
    }

    public Department getEntity() {
        return entity;
    }

    public void setEntity(Department entity) {
        this.entity = entity;
    }

    public void updateFormData(){
        if(entity == null){
            throw new IllegalStateException("Entity was null");
        }
        txtId.setText(String.valueOf(entity.getId()));
        txtName.setText(entity.getName());
    }

    private void notifyDataChangeListeners() {
		for (DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();
		}
	}

    private void setErrorMessage(Map<String, String> errors) {
        Set<String> fields = errors.keySet();

        if (fields.contains("name")){
            labelErrorName.setText(errors.get("name"));
        }
    }
}
