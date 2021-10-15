package casino.ui;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXLabel;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NewUserController {

    @FXML
    private MFXTextField newUserName;

    @FXML
    private MFXPasswordField newUserPassword;

    @FXML
    private MFXDatePicker dateOfBirth;

    @FXML
    private MFXCheckbox termsCheckBox;

    @FXML
    private MFXLabel termsTextBtn;

    @FXML
    private MFXButton newUserCreateBtn;

    @FXML
    boolean validation(ActionEvent event) throws IOException {
        LocalDate minAge = LocalDate.now().minusYears(18);
        boolean isValid = false;
        try {
            if (newUserName.getText().isEmpty()) {
                Alert nameFail = new Alert(AlertType.ERROR);
                nameFail.setHeaderText("Failure");
                nameFail.setContentText("You must type something as username");
                nameFail.showAndWait();
            } else if (newUserPassword.getText().isEmpty()) {
                Alert passFail = new Alert(AlertType.ERROR);
                passFail.setHeaderText("Failure");
                passFail.setContentText("You must type something as password");
                passFail.showAndWait();
            } else if (dateOfBirth.getDate().isAfter(minAge)) {
                Alert dateFail = new Alert(AlertType.ERROR);
                dateFail.setHeaderText("Failure");
                dateFail.setContentText("You must be 18 or older");
                dateFail.showAndWait();
            } else {
                isValid = true;
            }
        } catch (NullPointerException e) {
            Alert dateFail = new Alert(AlertType.ERROR);
            dateFail.setHeaderText("Failure");
            dateFail.setContentText("Please enter your date of birth");
            dateFail.showAndWait();
        }
        return isValid;
    }

    @FXML
    void checkIfAgreed() {
        if (termsCheckBox.isSelected()) {
            newUserCreateBtn.setDisable(false);
        } else {
            newUserCreateBtn.setDisable(true);
        }
    }

    @FXML
    void onTermsBtnClick(MouseEvent event) {
        Alert a = new Alert(AlertType.NONE);
        a.setAlertType(AlertType.INFORMATION);
        a.setContentText("I solemnly swear I am up to no good");
        a.show();

    }

    @FXML
    void returnToLogIn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("LogIn");
        stage.setScene(new Scene(root));
        stage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
        Alert confirm = new Alert(AlertType.INFORMATION);
        confirm.setHeaderText("Confimration");
        confirm.setContentText("New user has succesfully been created");
        confirm.show();
    }

    @FXML
    void onNewUserBtnClick(ActionEvent event) throws IOException {
        if (validation(event) == true) {
            returnToLogIn(event);
        }
    }

    public String getUsername() {
        return newUserName.getText();
    }

    protected String getPassword() {
        return newUserPassword.getText();
    }

}
