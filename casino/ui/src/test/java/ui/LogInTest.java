package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

public class LogInTest extends ApplicationTest {

    private AppController controller;

    @Override
    public void start(final Stage stage) throws Exception {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
        final Parent root = loader.load();
        this.controller = loader.getController();
        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testController() {
        assertNotNull(this.controller);
    }

    @Test
    public void testingError() {
        String emptyText = "";
        clickOn("#signInUser").write(emptyText);
        assertEquals(emptyText, controller.getUsername());

    }

    @Test
    public void testingNameAndPassword() {
        String firstName = "Erna Solberg";
        String surname = "Solberg";
        String hidden = "???????";
        clickOn("#signInUser").write(firstName);
        clickOn("#signInPassword").write(surname);
        assertEquals(firstName, controller.getUsername());
        assertNotEquals(hidden, controller.getPassword());

    }

}
