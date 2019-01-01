package REMtracker.src.PKGminiscope;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
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
  private Border border;

  //Constructor with no arguments instantiates associative classes
  public MiniScopeDataModel(){}
  //Constructor with arguments
  public MiniScopeDataModel(Stage aStage, BorderPane aLayout){
    this.primaryStage = aStage;
    this.rootLayout = aLayout;
    channelFunctions = new ChannelFunctions();
    miniScopeEnums = new MiniScopeEnums();
    stylizeGUI();
    setScope("MiniScope");
  }

  //setBorder sets the borders around each of the borderpane's sections(top, bottom, left, right & center)
  public void setBorder(){
    this.border = new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
  }
  public Border getBorder(){
    return this.border;
  }

    //Getting Screen Dimensions
    public Rectangle2D getScreenDimensions(){
        return new Rectangle2D(0,0, Screen.getPrimary().getVisualBounds().getWidth(),
                Screen.getPrimary().getVisualBounds().getHeight());
    }

  //stylizeGUI sets BorderPane borders and sizes for all regions: top, bot, left, right - except center
  public void stylizeGUI(){
    setBorder();
    rootLayout.setBorder(this.border);
    double screenWidth = getScreenDimensions().getWidth()*.95;
    double screenHeight = getScreenDimensions().getHeight();

      //Top pane
      Rectangle rect_TopPane = new Rectangle();
      rect_TopPane.setStroke(Color.BLACK);
      rect_TopPane.setFill(Color.TRANSPARENT);
      rect_TopPane.setWidth(screenWidth);
      rect_TopPane.setHeight(screenHeight * 0.10);
      StackPane stPane_Top = new StackPane();
      stPane_Top.getChildren().add(rect_TopPane);
      rootLayout.setTop(stPane_Top);

      //Left Pane
      Rectangle rect_LeftPane = new Rectangle();
      rect_LeftPane.setStroke(Color.BLACK);
      rect_LeftPane.setFill(Color.TRANSPARENT);
      rect_LeftPane.setWidth(screenWidth * 0.10);
      rect_LeftPane.setHeight(screenHeight * 0.75);
      StackPane stPane_Left = new StackPane();
      stPane_Left.getChildren().add(rect_LeftPane);
      rootLayout.setLeft(stPane_Left);

      //Right Pane
      Rectangle rect_RightPane = new Rectangle();
      rect_RightPane.setStroke(Color.BLACK);
      rect_RightPane.setFill(Color.TRANSPARENT);
      rect_RightPane.setWidth(screenWidth * 0.10);
      rect_RightPane.setHeight(screenHeight * 0.75);
      StackPane stPane_Right = new StackPane();
      stPane_Right.getChildren().add(rect_RightPane);
      rootLayout.setRight(stPane_Right);

      //Bottom Pane
      Rectangle rect_BottomPane = new Rectangle();
      rect_BottomPane.setStroke(Color.BLACK);
      rect_BottomPane.setFill(Color.TRANSPARENT);
      rect_BottomPane.setWidth(screenWidth);
      rect_BottomPane.setHeight(screenHeight * 0.10);
      StackPane stPane_Bottom = new StackPane();
      stPane_Bottom.getChildren().add(rect_BottomPane);
      rootLayout.setBottom(stPane_Bottom);

      //Center Pane
      Rectangle rect_CenterPane = new Rectangle();
      rect_CenterPane.setStroke(Color.BLACK);
      rect_CenterPane.setFill(Color.TRANSPARENT);
      rect_CenterPane.setWidth(screenWidth - (2 * rect_LeftPane.getWidth())*.9);
      rect_CenterPane.setHeight(rect_LeftPane.getHeight());
      rootLayout.setCenter(rect_CenterPane);
  }


  //Set up a default scope with all buttons, sliders, graph, etc...
  public void setScope(String aScopeName){

      //Scope Section: Name
      this.scopeName = aScopeName;
      Label lbl_scopeName = new Label(this.scopeName);
      lbl_scopeName.setFont(Font.font(20));

      //Scope Section: Graph
      Rectangle scopeRect = new Rectangle(500,350);
      scopeRect.setFill(Color.WHITE);
      scopeRect.setStroke(Color.BLACK);

      //Scope Section: Values
      Rectangle values_Rect = new Rectangle(500,100);
      values_Rect.setFill(Color.WHITE);
      values_Rect.setStroke(Color.BLACK);

      //Scope Section: Controls
      Rectangle controls_Rect = new Rectangle(500, 150);
      controls_Rect.setFill(Color.WHITE);
      controls_Rect.setStroke(Color.BLACK);

      //Scope Section: Hidden Menu
      Rectangle menu_Rect = new Rectangle(500,100);
      menu_Rect.setFill(Color.WHITE);
      menu_Rect.setStroke(Color.BLACK);
      menu_Rect.setVisible(false);

      //Getting a box to act as a space
      //This part can be redone once we know how to add a space another way between items in a VBox
      VBox spaceBox = new VBox();
      spaceBox.getChildren().add(new Rectangle(500,10, Color.TRANSPARENT));

      //Making a box to contain all scope display items
      VBox scope_VBox = new VBox();
      scope_VBox.setAlignment(Pos.CENTER);
      scope_VBox.getChildren().addAll(lbl_scopeName, scopeRect, values_Rect, spaceBox, controls_Rect, menu_Rect);

      //Making a group to store all scope items
      Group miniScopeGroup = new Group();

      miniScopeGroup.getChildren().add(scope_VBox);

  //Place all the contents in the center of the layout
    //rootLayout.setCenter(miniScopeGroup);
      rootLayout.setCenter(scope_VBox);

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
