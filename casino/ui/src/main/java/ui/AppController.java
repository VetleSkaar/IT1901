package ui;

import core.App;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AppController {
    
    //------------Elements-----------------//

    @FXML
    private TextField signInUser;

    @FXML
    private PasswordField signInPassword;

    @FXML
    private JFXButton signInBtn;

    @FXML
    private JFXButton newUserBtn;

    
    //------------Functions-----------------//
    
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