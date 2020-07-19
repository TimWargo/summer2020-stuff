package summer2020.stuff.projects.profile;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LoginPage extends Scene {

    public LoginPage(Stage stage) {
        super(new Group());
        stage.setTitle("Login");
        Label title = new Label("Log In");
        TextField userField = new TextField("username");
        TextField passField = new TextField("password");
        Region r1 = new Region();
        r1.setMinHeight(10);
        Button logButton = new Button("Log In");
        logButton.setTextAlignment(TextAlignment.CENTER);
        Label passLink = new Label("Forgot Password?");
        passLink.setOnMouseClicked(event -> System.out.println("hi"));
        HBox box = new HBox(passLink);
        box.setAlignment(Pos.CENTER_RIGHT);

        VBox base = new VBox(10, title, r1, userField, passField, box, logButton);
        base.setAlignment(Pos.TOP_CENTER);
        base.setPadding(new Insets(50, 20, 5, 20));
        base.setMinWidth(300);
        base.setMinHeight(200);
        this.setRoot(base);
        
    } // LoginPage
} // LoginPage