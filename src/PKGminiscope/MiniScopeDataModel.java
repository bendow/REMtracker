package REMtracker.src.PKGminiscope;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * MiniScopeDataModel instantiates the objects necessary for producing the GUI
 * This class also instantiates other framework classes such as:
 * (ChannelFunctions & MiniScopeEnums)
 * Refer to the REMtracker SDD for GUI Objects
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since   2018-NOV-20
 */
public class MiniScopeDataModel {

  //Global Variables
  public ChannelFunctions channelFunctions;
  public MiniScopeEnums miniScopeEnums;
  
  //Local Variables
  private String scopeName;
  private Stage primaryStage;
  private BorderPane rootLayout;

  //Constructor with no arguments instantiates associative classes
  public MiniScopeDataModel(){}

  public MiniScopeDataModel(Stage aStage, BorderPane aLayout){
    this.primaryStage = aStage;
    this.rootLayout = aLayout;
    channelFunctions = new ChannelFunctions();
    miniScopeEnums = new MiniScopeEnums();
    setScope("MiniScope");
  }

  
  //Set up a default scope with all buttons, sliders, graph, etc...
  public void setScope(String aScopeName){
  this.scopeName = aScopeName;
   //Making a container to hold all scope elements
    Group miniScopeGroup = new Group();
    VBox scope_VBox = new VBox();
    //Scope's name section
    Label lbl_scopeName = new Label(this.scopeName);
    //Scope's graph section
    Rectangle scopeRect = new Rectangle(500,350);
    scopeRect.setFill(Color.WHITE);
    scopeRect.setStroke(Color.BLACK);
    //Scope's values section
      Rectangle values_Rect = new Rectangle(500,100);
      values_Rect.setFill(Color.WHITE);
      values_Rect.setStroke(Color.BLACK);
    //Scopes controls section
    Rectangle controls_Rect = new Rectangle(500, 150);
    controls_Rect.setFill(Color.WHITE);
    controls_Rect.setStroke(Color.BLACK);
    //Scope's HIDDEN menu section
    Rectangle menu_Rect = new Rectangle(500,100);
    menu_Rect.setFill(Color.WHITE);
    menu_Rect.setStroke(Color.BLACK);
    menu_Rect.setVisible(false);
    //Putting all sections together
      VBox spaceBox = new VBox();
      spaceBox.getChildren().add(new Rectangle(500,10, Color.TRANSPARENT));
      scope_VBox.getChildren().addAll(lbl_scopeName, scopeRect, values_Rect, spaceBox, controls_Rect, menu_Rect);


      miniScopeGroup.getChildren().add(scope_VBox);

  //Place all the contents in the center of the layout
    rootLayout.setCenter(miniScopeGroup);
  }
  
  //Let the scope be renamed
  public void setScopeName(String theScopeName){
    this.scopeName = theScopeName;
  }
  
  //Get the name of the current Scope
  public String getScopeName(){
    return this.scopeName;
  }
  
  //Should the data be handled in REMtrackerDataModel leaving the MiniScopeDataModel as a framework?
  //I'm thinking that MiniScopeDataModel creates variables like arrays to store data but are empty for REMtrackerDataModel to fill.
  
  //setColors sets the text, background and foreground color
  public void setColors(){}
  //setCursors sets both cursors for Vertical and Horizontal
  public void setCursors(){}
  //toggleText toggles the visibility of the text section underneath the graph
  public void toggleText(){}
  //setGraph sets the graph
  public void setGraph(){}
  //setButtons sets all of the buttons, sizes, label, visibility and position
  public void setButtons(){}
  
  
}
