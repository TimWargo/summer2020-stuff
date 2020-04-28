package summer2020.stuff;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CancerApp extends Application {

    private HBox box;
    private VBox root;
    private Text message;
    private ImageView view;
    private Button button;
    private Image discordIcon;


    /** {@inheritDoc} **/
    @Override
    public void start(Stage stage) {
        discordIcon = new Image("file:target/resources/bwc49-QUvRk-96s.png", 300, 300,
                                false, false);
        view = new ImageView(discordIcon);
        message = new Text("IM A COMPUTER SCIENCE ENGINEER!!!");
        button = new Button("", view);
        //box = new HBox(10, message, button);
        root = new VBox(button);
        //root = new VBox(5, view, box);




        Scene scene = new Scene(root);
        stage.setTitle("Download Free Ram!!!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    } // start


} // CancerApp
