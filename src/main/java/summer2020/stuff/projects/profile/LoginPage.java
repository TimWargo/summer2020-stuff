package summer2020.stuff.projects.profile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LoginPage extends Scene {

    private Button logButton;
    private Scanner fileScan;
    private TextField userField;
    private TextField passField;


    public LoginPage(Stage stage) {
        super(new Group());
        stage.setTitle("Login");
        Label title = new Label("Log In");
        title.setPadding(new Insets(0, 0, 10, 0));
        Hyperlink passLink = new Hyperlink("Forgot Password?");
        passLink.setFont(Font.font("times new roman", 14));
        passLink.setPadding(new Insets(0, 0, 10, 0));
        passLink.setOnAction(event -> System.out.println("hi"));
        HBox box = new HBox(passLink);
        box.setAlignment(Pos.CENTER_RIGHT);
        Region r2 = new Region();
        r2.setMinHeight(5);
        Label signText = new Label("Need an account?");
        signText.setFont(Font.font("times new roman", 14));
        Hyperlink signUp = new Hyperlink("Sign up");
        signUp.setFont(Font.font("times new roman", 14));
        HBox signBox = new HBox(5, signText, signUp);
        signBox.setAlignment(Pos.CENTER);
        Region r3 = new Region();
        r3.setMinHeight(20);
        Label version = new Label("Version 1.0.152");
        HBox box2 = new HBox(version);
        box2.setAlignment(Pos.CENTER_LEFT);
        loginFunctionality();
        VBox baseTop = new VBox(10, title, userField, passField);
        baseTop.setAlignment(Pos.TOP_CENTER);
        VBox baseBot = new VBox(10, logButton, r2, signBox, r3, box2);
        baseBot.setAlignment(Pos.TOP_CENTER);
        VBox base = new VBox(baseTop, box, baseBot);
        base.setAlignment(Pos.TOP_CENTER);
        base.setPadding(new Insets(50, 20, 5, 20));
        base.setMinWidth(300);
        base.setMinHeight(200);
        this.setRoot(base);
        
    } // LoginPage

    /**
     * Private method that deals with the functionality of the log-in feature.
     */
    private void loginFunctionality() {
        try {
            fileScan = new Scanner(new File("target/classes/projects/profile/Accounts.txt."));
        } catch(NullPointerException npe) {
            System.out.println("Could not find file specified");
        } catch(FileNotFoundException fnfe) {
            System.out.println("Could not find file specified");
        } // try
        userField = new TextField("username");
        passField = new TextField("password");
        logButton = new Button("Log In");
        logButton.setTextAlignment(TextAlignment.CENTER);
        logButton.setMaxWidth(300);
        logButton.setOnAction(event -> {
            String user = new String(userField.getText());
            String pass = new String(passField.getText());
            while(fileScan.hasNext()) {
                if (fileScan.nextLine().contains("Account #")) {
                    try {
                        System.out.println(fileScan.next("username:"));
                        System.out.println(fileScan.next("password:"));
                    } catch (NoSuchElementException nsee) {
                        System.out.println("Does not exist");
                    } // try
                } // if
            } // while
        });
    } // loginFunctionality
} // LoginPage