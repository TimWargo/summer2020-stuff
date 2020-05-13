package summer2020.stuff.projects.password;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import summer2020.stuff.utility.StringFormer;
import java.util.LinkedList;
import java.util.Random;

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
    private Random rand;

    /** {@inheritDoc} **/
    @Override
    public void start(Stage stage) {
        /* Initializes the checkboxes */
        specialCheck = new CheckBox("Contains a special character");
        uppercaseCheck = new CheckBox("Contains an uppercase character");
        lowercaseCheck = new CheckBox("Contains a lowercase character");
        numberCheck = new CheckBox("Contains a number");

        /* Initializes various objects for the application */
        Button genButton = new Button("generate");
        Text message = new Text("Your password is: ");
        Text password = new Text("");
        Region space = new Region();
        TextField field = new TextField();

        /* Initializes and formats the title */
        Label title = new Label("Password Generator");
        title.setFont(Font.font("Symbol", FontWeight.EXTRA_BOLD, 28));
        HBox titleBox = new HBox(title);
        titleBox.setAlignment(Pos.CENTER);

        Text specialTextMessage = new Text("Words you want included into the password:");

        /* Begins the heirarchy */
        HBox specialText = new HBox(8, specialTextMessage, field);
        HBox box = new HBox(message, password, space, genButton);
        HBox.setHgrow(space, Priority.ALWAYS);
        VBox checkList = new VBox(5, specialCheck, uppercaseCheck, lowercaseCheck,
                                  numberCheck, specialText);

        /* Creates functionality for the button */
        rand = new Random();
        genButton.setOnAction(e -> {
                getConditions();
                try {
                    password.setText(generatePassword(field.getText()));
                } catch (IndexOutOfBoundsException ioobe) {
                    Alert alert = new Alert(Alert.AlertType.NONE,
                                            "cannot generate password based"
                                            + " on supplied requirements.",
                                            ButtonType.CLOSE);
                    alert.getDialogPane().getStylesheets().add("file:src/main/resources/projects/password/main.css");
                    alert.show();
                } // try
            });

        Text version = new Text(" Version 1.2.110");

        /* Final heirarchy adjustments */
        VBox root = new VBox(10, titleBox, checkList, box, version);
        root.setPadding(new Insets(5, 5, 5, 5));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("file:src/main/resources/projects/password/main.css");
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


    /**
     * Generates a password based off of the specified requirements for the password and the custom
     * string.
     * @param str the initial string used to generate the password.
     * @return A string representing a password based on the requirements.
     */
    private String generatePassword(String str) {
        LinkedList<String> pass = new LinkedList<>();
        LinkedList<Integer> options = new LinkedList<>();
        pass.add(str);
        if (needsSpecial) {
            options.add(1);
        } // if
        if (needsUppercase) {
            options.add(2);
        } // if
        if (needsLowercase) {
            options.add(3);
        } // if
        if (needsNumber) {
            options.add(4);
        } // if
        do {
            if (options.size() <= 0) {
                throw new IndexOutOfBoundsException();
            } else {
                int temp = options.get(rand.nextInt(options.size()));
                if (temp == 1) {
                    pass.add(rand.nextInt(pass.size() + 1),
                             Character.toString(StringFormer.randomSpecial()));
                } else if (temp == 2) {
                    pass.add(rand.nextInt(pass.size() + 1),
                             Character.toString(StringFormer.randomUppercase()));
                } else if (temp == 3) {
                    pass.add(rand.nextInt(pass.size() + 1),
                             Character.toString(StringFormer.randomLowercase()));
                } else if (temp == 4) {
                    pass.add(rand.nextInt(pass.size() + 1),
                             Character.toString(StringFormer.randomNumber()));
                } // if
            } // if
        } while (!isSatisfied(pass.stream().reduce(str, (a, b) -> a + b))
                 && pass.stream().reduce(str, (a, b) -> a + b).length() < 15);
        return pass.stream().reduce("", (a, b) -> a + b);
    } // generatePassword

    /**
     * Helper method to check that the given password satisfies
     * the given boolean conditions the password must meet.
     * @param str the password that is being checked.
     * @return true if the password satisfies each of the conditions and the password is
     * between 7 and 15 characters long. Returns false otherwise.
     */
    private boolean isSatisfied(String str) {
        int[] specialVal = new int[] {33, 35, 36, 37, 38, 42, 63, 64, 126};
        boolean s = false;
        boolean u = false;
        boolean l = false;
        boolean n = false;
        for (int i = 0; i < str.length(); i++) {
            /* Checks special characters */
            for (int j = 0; j < specialVal.length; j++) {
                if (str.charAt(i) == (char) specialVal[j]) {
                    s = true;
                } // if
            } // for
            /* Checks uppercase, then lowercase, then numbers */
            if (str.charAt(i) > 64 && str.charAt(i) < 91) {
                u = true;
            } else if (str.charAt(i) > 96 && str.charAt(i) < 123) {
                l = true;
            } else if (str.charAt(i) > 47 && str.charAt(i) < 58) {
                n = true;
            } // if
        } // for
        return (!needsSpecial || (needsSpecial && s)) && (!needsUppercase || (needsUppercase && u))
            && (!needsLowercase || (needsLowercase && l)) && (!needsNumber || (needsNumber && n))
            && str.length() > 7 && str.length() < 15;
    } // isSatisfied



} // PasswordApp
