package summer2020.stuff.projects.password;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import summer2020.stuff.utility.StringFormer;
import java.util.List;

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
    CheckBox specialCheck;
    CheckBox uppercaseCheck;
    CheckBox lowercaseCheck;
    CheckBox numberCheck;


    /** {@inheritDoc} **/
    @Override
    public void start(Stage stage) {
        specialCheck = new CheckBox("Contains a special character");
        uppercaseCheck = new CheckBox("Contains an uppercase character");
        lowercaseCheck = new CheckBox("Contains a lowercase character");
        numberCheck = new CheckBox("Contains a number");
        Button genButton = new Button("generate");
        Text message = new Text("Your password is: ");
        Text password = new Text("");
        Region space = new Region();
        TextField field = new TextField();
        Label title = new Label("Password Generator");
        HBox titleBox = new HBox(title);
        titleBox.setAlignment(Pos.CENTER);
        Text specialTextMessage = new Text("Words you want included into the password:");
        HBox specialText = new HBox(8, specialTextMessage, field);
        HBox box = new HBox(message, password, space, genButton);
        HBox.setHgrow(space, Priority.ALWAYS);
        VBox checkList = new VBox(5, specialCheck, uppercaseCheck, lowercaseCheck,
                                  numberCheck, specialText);
        genButton.setOnAction(e -> {
                getConditions();
                password.setText(StringFormer.generatePassword(field.getText(), needsSpecial, needsUppercase,
                                                               needsLowercase, needsNumber));
            });
        VBox root = new VBox(10, titleBox, checkList, box);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Password Generator");
        stage.sizeToScene();
        stage.show();
    } // start

    /**
     * Determines the conditions for the password being generated
     */
    private void getConditions() {
        needsSpecial = specialCheck.isSelected();
        needsLowercase = lowercaseCheck.isSelected();
        needsUppercase = uppercaseCheck.isSelected();
        needsNumber = numberCheck.isSelected();
    } // getConditions
} // PasswordApp
