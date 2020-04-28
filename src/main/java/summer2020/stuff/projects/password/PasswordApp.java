package summer2020.stuff.projects.password;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
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

    private boolean needsSpecial;
    private boolean needsUppercase;
    private boolean needsLowercase;
    private boolean needsNumber;


    /** {@inheritDoc} **/
    @Override
    public void start(Stage stage) {
        CheckBox specialCheck = new CheckBox("Password must contain a special character");
        CheckBox uppercaseCheck = new CheckBox("Password must contain an uppercase character");
        CheckBox lowercaseCheck = new CheckBox("Password must contain a lowercase character");
        CheckBox numberCheck = new CheckBox("Password must contain a number");
        Button genButton = new Button("generate");

        VBox checkList = new VBox(5, specialCheck, uppercaseCheck, lowercaseCheck, numberCheck);
        VBox root = new VBox(10, checkList, genButton);





        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Password Generator");
        stage.sizeToScene();
        stage.show();
    } // start
} // PasswordApp
