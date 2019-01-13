package REMtracker.src.PKGminiscope;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * MiniScope instantiates other framework classes such as:
 * (MiniScopeDataModel, MiniScopeTimerTask, Channel & MiniScopeEventRelayer)
 * <p>
 * setGUI() shows one default scope in the center of a GridPane Layout
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since 2018-NOV-20
 */

public class MiniScope {

    //Global Variables
    Stage primaryStage;
    String appName;
    double version;
    BorderPane rootLayout;
    MiniScopeDataModel miniScopeDataModel;
    MiniScopeTimerTask miniScopeTimerTask;
    MiniScopeEventRelayer miniScopeEventRelayer;
    Channel scopeChannel;

    //Local Variables

    //Constructor with no arguments
    public MiniScope() {
    }


    public MiniScope(String theAppName, double theVersion, Stage aStage) {
        this.appName = theAppName;
        this.version = theVersion;
        this.primaryStage = aStage;
        rootLayout = new BorderPane();

        miniScopeDataModel = new MiniScopeDataModel(this.primaryStage, this.rootLayout);
        miniScopeTimerTask = new MiniScopeTimerTask();
        miniScopeEventRelayer = new MiniScopeEventRelayer(miniScopeDataModel);
        scopeChannel = new Channel();

        setStage();
    }

    //setStage sets a scene with a pane layout and scene dimensions
    public void setStage() {
        double scaleValue = 0.95;
        double sceneWidth = getScreenDimensions().getWidth() * scaleValue;
        double sceneHeight = getScreenDimensions().getHeight() * scaleValue;

        primaryStage.setTitle(appName + " " + version);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(rootLayout, sceneWidth, sceneHeight));
        primaryStage.show();
    }

    //Getting Screen Dimensions
    public Rectangle2D getScreenDimensions() {
        return new Rectangle2D(0, 0, Screen.getPrimary().getVisualBounds().getWidth(),
                Screen.getPrimary().getVisualBounds().getHeight());
    }


}
