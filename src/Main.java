package REMtracker.src;

import REMtracker.src.PKGminiscope.MiniScope;
import REMtracker.src.PKGremtracker.REMtracker;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MiniScope miniScope = new MiniScope("Mini Scope", 1.0, primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
