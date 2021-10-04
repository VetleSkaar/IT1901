package ui;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXLabel;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

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
    void onTermsBtnClick(MouseEvent event) {
        Alert a = new Alert(AlertType.NONE);
        a.setAlertType(AlertType.INFORMATION);
        a.setContentText("I solemnly swear I am up to no good");
        a.show();

    }

}
