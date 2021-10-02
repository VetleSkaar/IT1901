package ui;

// import core.Casino;

import io.github.palexdev.materialfx.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AppController {

    // ------------Elements-----------------//

    @FXML
    private MFXTextField signInUser;

    @FXML
    private MFXPasswordField signInPassword;

    @FXML
    private MFXButton signInBtn;

    @FXML
    private MFXButton newUserBtn;

    // ------------Functions-----------------//

    @FXML
    void onNewUserClick(ActionEvent event) {
        Alert a = new Alert(AlertType.NONE);
        a.setAlertType(AlertType.CONFIRMATION);
        a.setContentText("Confirms that create new user button clicked");
        a.show();
    }

    @FXML
    void onSignInClick(ActionEvent event) {
        Alert a = new Alert(AlertType.NONE);
        a.setAlertType(AlertType.CONFIRMATION);
        a.setContentText("Confirms that sign in button clicked");
        a.show();

    }

}