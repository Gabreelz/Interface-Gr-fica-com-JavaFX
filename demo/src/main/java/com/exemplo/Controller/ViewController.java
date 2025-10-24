package com.exemplo.Controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.Entities.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ViewController implements Initializable{
    
    @FXML
    private ComboBox<Person> comboBoxPerson;
    
    private ObservableList<Person> obsList;
    
    @FXML
    public void onComboBoxPersonAction() {
        Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
        System.out.println(person);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List<Person> list = new ArrayList<>();
            list.add(new Person(1, "Peter Parker", "clarimDiario@gmail.com"));
            list.add(new Person(2, "Tony Stark", "stark@gmail.com"));
            list.add(new Person(3, "Steve Rogers", "Ameria@gmail.com"));

            obsList = FXCollections.observableArrayList(list);
            comboBoxPerson.setItems(obsList);

            //Para o ComboBox mostrar somente o nome da pessoa
            Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
                @Override
                    protected void updateItem(Person item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? "" : item.getName());
                }
            };
            
    comboBoxPerson.setCellFactory(factory);
    comboBoxPerson.setButtonCell(factory.call(null));
    }    
}
