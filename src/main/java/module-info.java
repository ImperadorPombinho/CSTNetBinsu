module grupoxande.cst {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens grupoxande.cst to javafx.fxml;
    exports grupoxande.cst;
}
