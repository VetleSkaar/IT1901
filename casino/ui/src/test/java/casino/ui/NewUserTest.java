package casino.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

import casino.ui.NewUserController;

public class NewUserTest extends ApplicationTest {

    private NewUserController controller;

    @Override
    public void start(final Stage stage) throws Exception {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("NewUser.fxml"));
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
    public void testFakepassword() {
        String fake = "****";
        String password = "NTNU";
        clickOn("#newUserPassword").write(password);
        assertNotEquals(fake, controller.getPassword());

    }

    @Test
    public void testRealUser() {
        String name = "John Carew";
        String password = "Chill og Spill";
        clickOn("#newUserName").write(name);
        clickOn("#newUserPassword").write(password);
        clickOn("#termsCheckBox");
        clickOn("#termsTextBtn");
        clickOn("#newUserCreateBtn");
        assertNotNull(controller.getUsername());
        assertNotNull(controller.getPassword());

    }

}
