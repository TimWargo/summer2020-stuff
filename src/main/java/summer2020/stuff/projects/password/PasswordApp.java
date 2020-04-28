package summer2020.stuff.projects.password;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class that creates a password-making application where the user can generate passwords
 * that satisfy the password requirements that they specify. Future developments will include
 * the ability to include custom input words into the password. The purpose of the program is to
 * enable the user to generate more secure passwords by randomizing the characters and numbers used.
 */
public class PasswordApp extends Application {

    /** {@inheritDoc} **/
    @Override
    public void start(Stage stage) {

        VBox root = new VBox();





        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Password Generator");
        stage.sizeToScene();
        stage.show();
    } // start
} // PasswordApp
