package REMtracker.src;

import REMtracker.src.PKGminiscope.MiniScope;
import REMtracker.src.PKGremtracker.REMtracker;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane gridpane = new GridPane();
        Parent root = gridpane;
        primaryStage.setTitle("REMtracker v1.0");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        REMtracker reMtracker = new REMtracker();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
