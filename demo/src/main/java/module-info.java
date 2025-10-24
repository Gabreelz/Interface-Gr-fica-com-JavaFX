module com.exemplo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens com.exemplo.Controller to javafx.fxml; // <<--- importante
    exports com.exemplo; // se precisar acessar de fora do módulo
}
