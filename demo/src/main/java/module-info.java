module com.exemplo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    // Abre o pacote principal para o JavaFX conseguir carregar a classe App
    opens com.exemplo to javafx.graphics;

    // Abre o pacote de controladores para o FXML poder injetar os componentes
    opens com.exemplo.Controller to javafx.fxml;

    // Abre o pacote de entidades para o PropertyValueFactory conseguir acessar via reflexão
    opens com.Entities to javafx.base;

    // Exporta pacotes que precisam ser visíveis por outros módulos (opcional, mas recomendado)
    exports com.exemplo;
    exports com.exemplo.Controller;
    exports com.Entities;
}
