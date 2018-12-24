package REMtracker.src.PKGminiscope;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * MiniScope instantiates other framework classes such as:
 * (MiniScopeDataModel, MiniScopeTimerTask, Channel & MiniScopeEventRelayer)
 * 
 * setGUI() shows one default scope in the center of a GridPane Layout
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since   2018-NOV-20
 */

public class MiniScope {
    
    //Global Variables
    Stage primaryStage;
    String appName;
    double version;
    MiniScopeDataModel miniScopeDataModel;
    MiniScopeTimerTask miniScopeTimerTask;
    MiniScopeEventRelayer miniScopeEventRelayer;
    Channel scopeChannel;
    
    //Local Variables

    //Constructor with no arguments
    public MiniScope(){}


    public MiniScope(String theAppName, double theVersion, Stage aStage){
        this.appName = theAppName;
        this.version = theVersion;
        this.primaryStage = aStage;

        miniScopeDataModel = new MiniScopeDataModel();
        miniScopeTimerTask = new MiniScopeTimerTask();
        miniScopeEventRelayer = new MiniScopeEventRelayer();
        scopeChannel = new Channel();

        setGUI();
    }
    
    //setGUI sets a default GUI by using the data from miniScopeDataModel
    //This GUI should leave left, right, top & bottom border blank for REMtracker to fill
    public void setGUI(){
        Rectangle2D screenDimension;
        screenDimension = getScreenSpecs();
        double screenWidth = screenDimension.getWidth();
        double screenHeight = screenDimension.getHeight();

        Parent root = new BorderPane();
        primaryStage.setTitle(appName + " " + version);
        primaryStage.setScene(new Scene(root, screenWidth * 0.90, screenHeight * 0.90));
        primaryStage.show();
    }

    public Rectangle2D getScreenSpecs(){
        return Screen.getPrimary().getVisualBounds();
    }
    
    
    
    
 
    
    


}
