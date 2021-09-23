package ui;

// import core.Casino;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AppController {

    // ------------Elements-----------------//

    @FXML
    private TextField signInUser;

    @FXML
    private PasswordField signInPassword;

    @FXML
    private Button signInBtn;

    @FXML
    private Button newUserBtn;

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