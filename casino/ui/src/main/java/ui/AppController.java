package ui;

// import core.Casino;

import io.github.palexdev.materialfx.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewUser.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("New User");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node) event.getSource()).getScene().getWindow().hide();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onSignInClick(ActionEvent event) {
        if (signInUser.getText().isEmpty()) {
            Alert nameFail = new Alert(AlertType.ERROR);
            nameFail.setHeaderText("Failure");
            nameFail.setContentText("Please enter your username");
            nameFail.showAndWait();
        } else if (signInPassword.getText().isEmpty()) {
            Alert passFail = new Alert(AlertType.ERROR);
            passFail.setHeaderText("Failure");
            passFail.setContentText("Please enter your password");
            passFail.showAndWait();
        } else {
            Alert a = new Alert(AlertType.NONE);
            a.setAlertType(AlertType.CONFIRMATION);
            a.setContentText("Confirms that sign in button clicked");
            a.show();
        }

    }

    public String getUsername() {
        return signInUser.getText();
    }

    protected String getPassword() {
        return signInPassword.getText();
    }

}