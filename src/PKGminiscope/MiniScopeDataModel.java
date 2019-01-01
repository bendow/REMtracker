package REMtracker.src.PKGminiscope;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
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
  private Label lbl_scopeName;
  private Group grp_Graph, grp_Results, grp_Controls, grp_HiddenMenu;
  private StackPane stPane_Graph, stPane_Results, stPane_Controls, stPane_HiddenMenu;
  private Rectangle graph_Rect, results_Rect, controls_Rect, menu_Rect;


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

  //stylizeGUI sets BorderPane borders and sizes for all regions: top, bot, left, right & center
  public void stylizeGUI(){
    setBorder();
    rootLayout.setBorder(this.border);
    double screenWidth = getScreenDimensions().getWidth() * 0.95;
    double screenHeight = getScreenDimensions().getHeight();

      //Top pane
      Rectangle rect_TopPane = new Rectangle();
      rect_TopPane.setStroke(Color.BLACK);
      rect_TopPane.setFill(Color.TRANSPARENT);
      rect_TopPane.setWidth(screenWidth);
      rect_TopPane.setTranslateX(-3); //Shifting so the borders overlap
      rect_TopPane.setHeight(screenHeight * 0.10);
      StackPane stPane_Top = new StackPane();
      stPane_Top.getChildren().add(rect_TopPane);
      rootLayout.setTop(stPane_Top);

      //Left Pane
      Rectangle rect_LeftPane = new Rectangle();
      rect_LeftPane.setStroke(Color.BLACK);
      rect_LeftPane.setFill(Color.TRANSPARENT);
      rect_LeftPane.setWidth(screenWidth * 0.10);
      rect_LeftPane.setTranslateX(-3);
      rect_LeftPane.setHeight(screenHeight * 0.75);
      StackPane stPane_Left = new StackPane();
      stPane_Left.getChildren().add(rect_LeftPane);
      rootLayout.setLeft(stPane_Left);


      //Right Pane
      Rectangle rect_RightPane = new Rectangle();
      rect_RightPane.setStroke(Color.BLACK);
      rect_RightPane.setFill(Color.TRANSPARENT);
      rect_RightPane.setWidth(screenWidth * 0.10);
      rect_RightPane.setTranslateX(-5);
      rect_RightPane.setHeight(screenHeight * 0.75);
      StackPane stPane_Right = new StackPane();
      stPane_Right.getChildren().add(rect_RightPane);
      rootLayout.setRight(stPane_Right);

      //Bottom Pane
      Rectangle rect_BottomPane = new Rectangle();
      rect_BottomPane.setStroke(Color.BLACK);
      rect_BottomPane.setFill(Color.TRANSPARENT);
      rect_BottomPane.setWidth(screenWidth);
      rect_BottomPane.setTranslateX(-3);
      rect_BottomPane.setHeight(screenHeight * 0.10);
      StackPane stPane_Bottom = new StackPane();
      stPane_Bottom.getChildren().add(rect_BottomPane);
      rootLayout.setBottom(stPane_Bottom);

      //Center Pane
      Rectangle rect_CenterPane = new Rectangle();
      rect_CenterPane.setStroke(Color.BLACK);
      rect_CenterPane.setFill(Color.TRANSPARENT);
      rect_CenterPane.setWidth(screenWidth - (2 * rect_LeftPane.getWidth()) );
      rect_CenterPane.setTranslateX(-4);
      rect_CenterPane.setHeight(rect_LeftPane.getHeight());
      StackPane stPane_Center = new StackPane();
      stPane_Center.getChildren().add(rect_CenterPane);
      rootLayout.setCenter(stPane_Center);
  }


  //Set up a default scope with all buttons, sliders, graph, etc...
  public void setScope(String aScopeName){

      //Setup the Scope label
      setScopeLabel(aScopeName);

      //Setup groups for all scope sections(Graph, Results, Controls, HiddenMenu)
      setScopeGroups();

      //Setup the StackPanes for all scope sections(Graph, Results, Controls, HiddenMenu)
      setScopeStackPanes();

      //Setup all rectangles for the scope
      setScopeRectangles();

      //Setup the Graph area of this scope

      //Setup the Results area of this scope

      //Setup the Controls area of this scope

      //Setup the Hidden Menu area of this scope

      //Load StackPanes
      loadStackPanes();

      //load Groups
      loadGroups();

      //Place all groups into the center of the BorderPane
      setGroupsToCenterPane();
  }

  public void setScopeLabel(String aName){
      //Scope Section: Name
      this.scopeName = aName;
      lbl_scopeName = new Label(this.scopeName);
      lbl_scopeName.setFont(Font.font(20));
  }

  public void setScopeGroups(){
      grp_Graph = new Group();

      grp_Results = new Group();
      grp_Results.setTranslateY(-3);

      grp_Controls = new Group();
      grp_Controls.setTranslateY(20);

      grp_HiddenMenu = new Group();
  }

  public void setScopeStackPanes(){
      stPane_Graph = new StackPane();
      stPane_Results = new StackPane();
      stPane_Controls = new StackPane();
      stPane_HiddenMenu = new StackPane();
  }

  public void setScopeRectangles(){

      //Scope Section: Graph
      graph_Rect = new Rectangle(500,350);
      graph_Rect.setFill(Color.WHITE);
      graph_Rect.setStroke(Color.BLACK);

      //Scope Section: Results
      results_Rect = new Rectangle(500,100);
      results_Rect.setFill(Color.WHITE);
      results_Rect.setStroke(Color.BLACK);

      //Scope Section: Controls
      controls_Rect = new Rectangle(500, 150);
      controls_Rect.setFill(Color.WHITE);
      controls_Rect.setStroke(Color.BLACK);

      //Scope Section: Hidden Menu
      menu_Rect = new Rectangle(500,100);
      menu_Rect.setFill(Color.WHITE);
      menu_Rect.setStroke(Color.BLACK);
      menu_Rect.setVisible(false);
  }
  
  //Let the scope be renamed
  public void setScopeName(String theScopeName){
    this.scopeName = theScopeName;
  }
  
  //Get the name of the current Scope
  public String getScopeName(){
    return this.scopeName;
  }

  public void setGroupsToCenterPane(){
      //Making a VBox to contain & center the Scope Label and Scope Rectangles
      VBox scope_VBox = new VBox();
      scope_VBox.setAlignment(Pos.CENTER);
      scope_VBox.getChildren().addAll(lbl_scopeName, grp_Graph, grp_Results, grp_Controls, grp_HiddenMenu);

      //Fetching the StackPane that is in Center to load it with scopeVBox
      StackPane stPane_Center = (StackPane)rootLayout.getCenter();
      stPane_Center.getChildren().add(scope_VBox);
  }

  public void loadStackPanes(){
      stPane_Graph.getChildren().add(graph_Rect);
      stPane_Results.getChildren().add(results_Rect);
      stPane_Controls.getChildren().add(controls_Rect);
      stPane_HiddenMenu.getChildren().add(menu_Rect);
  }

  public void loadGroups(){
      grp_Graph.getChildren().add(stPane_Graph);
      grp_Results.getChildren().add(stPane_Results);
      grp_Controls.getChildren().add(stPane_Controls);
      grp_HiddenMenu.getChildren().add(stPane_HiddenMenu);
  }
}
