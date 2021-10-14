module casino.ui {
    requires casino.core;
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    opens ui to javafx.graphics, javafx.fxml;
}
