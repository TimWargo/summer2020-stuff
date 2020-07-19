package summer2020.stuff.projects.profile;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProfileApp extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("ProfileApp");
        stage.setScene(new LoginPage(stage));
        stage.sizeToScene();
        stage.show();
    }
} // ProfileApp