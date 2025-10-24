module com.exemplo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.exemplo.Controller to javafx.fxml; // <<--- importante
    exports com.exemplo; // se precisar acessar de fora do módulo
}
