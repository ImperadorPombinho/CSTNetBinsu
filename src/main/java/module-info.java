module grupoxande.cst {
    requires javafx.controls;
    requires javafx.fxml;

    opens grupoxande.cst to javafx.fxml;
    exports grupoxande.cst;
}
