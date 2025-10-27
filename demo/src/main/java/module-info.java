module com.exemplo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.exemplo to javafx.graphics; // para permitir que JavaFX instancie App
    opens com.exemplo.Controller to javafx.fxml;
}
